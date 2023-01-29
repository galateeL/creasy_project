package com.example.creasy.service;

import com.example.creasy.controller.dto.*;
import com.example.creasy.exception.CompanyNotFoundException;
import com.example.creasy.exception.PartnerNotFoundException;
import com.example.creasy.model.SortType;
import com.example.creasy.repository.*;
import com.example.creasy.model.Partner;
import com.example.creasy.model.StateProspect;
import com.example.creasy.model.User;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


@Service
public class PartnerService {

    private PartnerRepository partnerRepository;
    private CompanyRepository companyRepository;
    private StorageService storageService;

    private static final String IMAGE_VALUE = "http://localhost:8080/images/";

    public PartnerService(PartnerRepository partnerRepository, CompanyRepository companyRepository, StorageService storageService) {
        this.partnerRepository = partnerRepository;
        this.companyRepository = companyRepository;
        this.storageService = storageService;
    }

    public List<Partner> getAllPartner() {
        return (List<Partner>) this.partnerRepository.findAll();
    }

    // Find all prospects by user
    public int findAllProspectsByUser(String email){
        return this.partnerRepository.findNumberProspectsByUserEmail(StateProspect.ENDED, email);
    }

    // Find all customers by user
    public int findAllCustomersByUser(String email){
        return this.partnerRepository.findNumberCustomersByUserEmail(StateProspect.ENDED, email);
    }

    // Find number of prospects with TO_FOLLOW_UP state
    public int findNumberOfProspectsToFollowUp(String email) {
        return this.partnerRepository.findProspectIsAndUserEmailIs(StateProspect.TO_FOLLOW_UP, email);
    }

    // Find number of prospects with IN_PROGRESS state
    public int findNumberOfProspectsInProgress(String email) {
        return this.partnerRepository.findProspectIsAndUserEmailIs(StateProspect.IN_PROGRESS, email);
    }

    // Find number of prospects with NOT_STARTED state
    public int findNumberOfProspectsInNotStarted(String email) {
        return this.partnerRepository.findProspectIsAndUserEmailIs(StateProspect.NOT_STARTED, email);
    }


    public List<Partner> findAllProspectsByList (String email){
        return this.partnerRepository.findProspectsListByUser(StateProspect.ENDED, StateProspect.TO_FOLLOW_UP, email);
    }


    public List <Partner> getAllProspectFromKeyword(String keywordProspect, String email) {
        return this.partnerRepository.findProspectByKeyword(StateProspect.getProspectStates(), keywordProspect, email);
    }


    public List <Partner> getAllProspectBySort(String sort, String email) {

        SortType sortType = SortType.fromValue(sort);

        switch (sortType) {
            case ORDER_BY_LASTNAME_DESC :
                return this.partnerRepository.findProspectOrderByLastnameDesc(StateProspect.getProspectStates(), email);
            case ORDER_BY_LASTNAME_ASC:
                return this.partnerRepository.findProspectOrderByLastnameAsc(StateProspect.getProspectStates(), email);
            case  ORDER_BY_REGISTER_DATE_DESC:
                return this.partnerRepository.findProspectOrderByRegisterDateAsc(StateProspect.getProspectStates(), email);
            case ORDER_BY_REGISTER_DATE_ASC:
                return this.partnerRepository.findProspectOrderByRegisterDateDesc(StateProspect.getProspectStates(), email);
        }

        return this.partnerRepository.findProspectsByUser(StateProspect.getProspectStates(), email);
    }

    public List<Partner> getAllProspect(String keywordProspect, String sort, String email) {

        if(keywordProspect != null && !keywordProspect.isEmpty()) {
            return getAllProspectFromKeyword(keywordProspect, email);
        }

        if(sort != null) {
            return getAllProspectBySort(sort, email);
        }

        return this.partnerRepository.findProspectsByUser(StateProspect.getProspectStates(), email);
    }


    public List<Partner> getAllCustomerFromKeyword(String keywordCustomer, String email) {

        return this.partnerRepository.findCustomerByKeyword(StateProspect.getCustomerState(), keywordCustomer, email);
    }

    public List <Partner> getAllCustomerBySort(String sort, String email) {

        SortType sortType = SortType.fromValue(sort);

        switch (sortType) {
            case ORDER_BY_LASTNAME_DESC :
                return this.partnerRepository.findCustomerOrderByLastnameDesc(StateProspect.getCustomerState(), email);
            case ORDER_BY_LASTNAME_ASC:
                return this.partnerRepository.findCustomerOrderByLastnameAsc(StateProspect.getCustomerState(), email);
            case ORDER_BY_REGISTER_DATE_DESC:
                return this.partnerRepository.findCustomerOrderByRegisterDateAsc(StateProspect.getCustomerState(), email);
            case ORDER_BY_REGISTER_DATE_ASC:
                return this.partnerRepository.findCustomerOrderByRegisterDateDesc(StateProspect.getCustomerState(), email);
        }

        return this.partnerRepository.findCustomerByUser(StateProspect.getProspectStates(), email);
    }


    public List<Partner> getAllCustomer(String keywordCustomer, String sort, String email) {
        if(keywordCustomer != null && !keywordCustomer.isEmpty()) {
           return getAllCustomerFromKeyword(keywordCustomer, email);
        }

        if(sort != null) {
            return  getAllCustomerBySort(sort, email);
        }

        return this.partnerRepository.findCustomerByUser(StateProspect.getCustomerState(), email);
    }



    public List<Partner> getAllCustomerForMap() {
        StateProspect stateProspect2= null;
                    return this.partnerRepository.findCustomer(StateProspect.ENDED,stateProspect2);
    }

    public List<MapCustomerDto> getAllMapCustomeDto(){
        List<Partner> partners= getAllCustomerForMap();
        List<MapCustomerDto> partnersDto = new ArrayList<>();
        partners.forEach(e->partnersDto.add(e.toMapCustomerDto()));
        return partnersDto;
    }
    public List<Partner> getAllbyCompany(Long id){
        return this.partnerRepository.findByCompanyId(id);
    }


    public Partner findPartnerById(Long id) {
        return this.partnerRepository
                .findById(id)
                .orElseThrow(()-> new PartnerNotFoundException(id));
    }

    public void createProspect(CreateProspectDto createProspect, User user) {

        Partner prospect = new Partner();
        prospect.setFirstname(createProspect.getFirstname());
        prospect.setLastname(createProspect.getLastname());
        prospect.setEmail(createProspect.getEmail());
        prospect.setMobilePhoneNumber(createProspect.getMobilePhoneNumber());
        prospect.setFixedPhoneNumber(createProspect.getFixedPhoneNumber());
        prospect.setPositionHeld(createProspect.getPositionHeld());
        prospect.setStateProspect(createProspect.getStateProspect());
        prospect.setCompany(createProspect.getCompany());
        prospect.setRegisterDate(LocalDateTime.now());

        prospect.setUser(user);

        MultipartFile picture = createProspect.getPictureFile();
        if (picture == null || picture.isEmpty()) {
            prospect.setPictureUrl(createProspect.getPictureUrl());
        } else {
            storageService.store(picture);
            prospect.setPictureUrl(IMAGE_VALUE + picture.getOriginalFilename());
        }

        this.partnerRepository.save(prospect);

    }

    public void createCustomer(CreateCustomerDto createCustomer, User user) {

        Partner customer = new Partner();
        customer.setFirstname(createCustomer.getFirstname());
        customer.setLastname(createCustomer.getLastname());
        customer.setEmail(createCustomer.getEmail());
        customer.setMobilePhoneNumber(createCustomer.getMobilePhoneNumber());
        customer.setFixedPhoneNumber(createCustomer.getFixedPhoneNumber());
        customer.setPositionHeld(createCustomer.getPositionHeld());
        customer.setStateProspect(StateProspect.ENDED);
        customer.setCompany(createCustomer.getCompany());
        customer.setRegisterDate(LocalDateTime.now());

        customer.setUser(user);

        MultipartFile picture = createCustomer.getPictureFile();
        if (picture == null || picture.isEmpty()) {
            customer.setPictureUrl(createCustomer.getPictureUrl());
        } else {
            storageService.store(picture);
            customer.setPictureUrl(IMAGE_VALUE + picture.getOriginalFilename());
        }

        this.partnerRepository.save(customer);

    }

    public void deletePartner(Long id) {
        this.partnerRepository.deleteById(id);
    }

    public void editPartner(Long id, EditPartnerDto editPartner) {
        Partner partner = this.partnerRepository
                .findById(id)
                .orElseThrow(() -> new PartnerNotFoundException(id));

        partner.setFirstname(editPartner.getFirstname());
        partner.setLastname(editPartner.getLastname());
        partner.setEmail(editPartner.getEmail());
        partner.setFixedPhoneNumber(editPartner.getFixedPhoneNumber());
        partner.setMobilePhoneNumber(editPartner.getMobilePhoneNumber());
        partner.setPositionHeld(editPartner.getPositionHeld());
        if(editPartner.getStateProspect() != null) {
            StateProspect stateProspect = StateProspect.valueOf(editPartner.getStateProspect());
            partner.setStateProspect(stateProspect);
        }
        if(editPartner.getCompanyId() != null ) {
            partner.setCompany(companyRepository
                    .findById(Long.parseLong(editPartner.getCompanyId()))
                    .orElseThrow(() -> new CompanyNotFoundException(id)));
        }

        MultipartFile picture = editPartner.getPictureFile();
        if (picture != null && !picture.isEmpty()) {
            storageService.store(picture);
            partner.setPictureUrl(IMAGE_VALUE + picture.getOriginalFilename());
        }

        this.partnerRepository.save(partner);

    }


    public void addDunningPeriod(Long id, CreateDunningDto createDunning) {
        Partner partner = this.partnerRepository
                .findById(id)
                .orElseThrow(() -> new PartnerNotFoundException(id));

        partner.setDunningPeriod(createDunning.getDunningPeriod());
        partner.setDunningRegisterDate(LocalDateTime.now());

        this.partnerRepository.save(partner);

    }

    public void setToFollowUpIfNecessary(List<Partner> partnerList){
        for (Partner partner : partnerList) {
            if(partner.getDunningRegisterDate() != null && partner.getDunningPeriod() != 0 &&
                    partner.getDunningRegisterDate()
                            .plusDays(partner.getDunningPeriod())
                            .isBefore(LocalDateTime.now())) {

                partner.setStateProspect(StateProspect.TO_FOLLOW_UP);
                partnerRepository.save(partner);
            }
        }
    }


}
