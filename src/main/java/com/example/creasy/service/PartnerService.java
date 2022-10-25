package com.example.creasy.service;

import com.example.creasy.controller.dto.EventDto;
import com.example.creasy.controller.dto.MapCustomerDto;
import com.example.creasy.exception.PartnerNotFoundException;
import com.example.creasy.repository.*;
import com.example.creasy.repository.entity.Event;
import com.example.creasy.repository.entity.Partner;
import com.example.creasy.repository.entity.StateProspect;
import com.example.creasy.repository.entity.User;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.Part;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class PartnerService {

    private PartnerRepository partnerRepository;
    private CompanyRepository companyRepository;
    private StorageService storageService;


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
    public int findNumberOfProspectsToFollowUp(StateProspect stateProspect, String email) {
        return this.partnerRepository.findProspectIsAndUserEmailIs(StateProspect.TO_FOLLOW_UP, email);
    }

    // Find number of prospects with IN_PROGRESS state
    public int findNumberOfProspectsInProgress(StateProspect stateProspect, String email) {
        return this.partnerRepository.findProspectIsAndUserEmailIs(StateProspect.IN_PROGRESS, email);
    }

    // Find number of prospects with NOT_STARTED state
    public int findNumberOfProspectsInNotStarted(StateProspect stateProspect, String email) {
        return this.partnerRepository.findProspectIsAndUserEmailIs(StateProspect.NOT_STARTED, email);
    }



    public List<Partner> findAllProspectsByList (StateProspect stateProspect1, StateProspect stateProspect2, String email){
        return this.partnerRepository.findProspectsListByUser(StateProspect.ENDED, StateProspect.TO_FOLLOW_UP, email);
    }



    public List<Partner> getAllProspect(String keywordProspect, String sort, String email) {
        if(keywordProspect != null && !keywordProspect.isEmpty()) {
            if(sort != null) {
                if(sort.equals("ZA")){
                    return this.partnerRepository.findProspectZA(StateProspect.ENDED, keywordProspect, email);
                } else if (sort.equals("AZ")) {
                    return this.partnerRepository.findProspectAZ(StateProspect.ENDED, keywordProspect, email);
                } else if (sort.equals("ON")) {
                    return this.partnerRepository.findProspectON(StateProspect.ENDED, keywordProspect, email);
                } else if (sort.equals("NO" )) {
                    return this.partnerRepository.findProspectNO(StateProspect.ENDED, keywordProspect, email);
                }
            }

            return this.partnerRepository.findProspectByStateProspectAndFirstnameOrLastnameOrCompanyName(StateProspect.ENDED, keywordProspect, email);
        }

        if(sort != null) {
            if(sort.equals("ZA")){
                return this.partnerRepository.findByStateProspectIsNotOrderByLastnameDesc(StateProspect.ENDED, email);
            } else if (sort.equals("AZ")) {
                return this.partnerRepository.findByStateProspectIsNotOrderByLastnameAsc(StateProspect.ENDED, email);
            } else if (sort.equals( "ON")) {
                return this.partnerRepository.findByStateProspectIsNotOrderByRegisterDateAsc(StateProspect.ENDED, email);
            } else if (sort.equals("NO" )) {
                return this.partnerRepository.findByStateProspectIsNotOrderByRegisterDateDesc(StateProspect.ENDED, email);
            }
        }

        return this.partnerRepository.findByStateProspectIsNotAndUserEmailIs(StateProspect.ENDED, email);
    }


    public List<Partner> getAllCustomer(String keywordCustomer, String sort, String email) {
        if(keywordCustomer != null && !keywordCustomer.isEmpty()) {
            if(sort != null) {
                if(sort.equals("ZA")){
                    return this.partnerRepository.findCustomerZA(StateProspect.ENDED, keywordCustomer, email);
                } else if (sort.equals("AZ")) {
                    return this.partnerRepository.findCustomerAZ(StateProspect.ENDED, keywordCustomer, email);
                } else if (sort.equals("ON")) {
                    return this.partnerRepository.findCustomerON(StateProspect.ENDED, keywordCustomer, email);
                } else if (sort.equals("NO" )) {
                    return this.partnerRepository.findCustomerNO(StateProspect.ENDED, keywordCustomer, email);
                }
            }
            return this.partnerRepository.findCustomerByStateProspectAndFirstnameOrLastnameOrCompanyName(StateProspect.ENDED, keywordCustomer, email);
        }

        if(sort != null) {
            if(sort.equals("ZA")){
                return this.partnerRepository.findByStateProspectIsOrderByLastnameDesc(StateProspect.ENDED, email);
            } else if (sort.equals("AZ")) {
                return this.partnerRepository.findByStateProspectIsOrderByLastnameAsc(StateProspect.ENDED, email);
            } else if (sort.equals( "ON")) {
                return this.partnerRepository.findByStateProspectIsOrderByRegisterDateAsc(StateProspect.ENDED, email);
            } else if (sort.equals("NO" )) {
                return this.partnerRepository.findByStateProspectIsOrderByRegisterDateDesc(StateProspect.ENDED, email);
            }
        }

        return this.partnerRepository.findByStateProspectIsAndUserEmailIs(StateProspect.ENDED, email);
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
        return this.partnerRepository.findById(id).get();
    }


    public Partner getPartner(Long id) {
        return this.partnerRepository
                .findById(id)
                .orElseThrow(() -> new PartnerNotFoundException(id));
    }

    public void createProspect(CreateProspect createProspect, User user) {

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
            prospect.setPictureUrl("http://localhost:8080/images/" + picture.getOriginalFilename());
        }

        this.partnerRepository.save(prospect);

    }

    public void createCustomer(CreateCustomer createCustomer, User user) {

        Partner customer = new Partner();
        customer.setFirstname(createCustomer.getFirstname());
        customer.setLastname(createCustomer.getLastname());
        customer.setEmail(createCustomer.getEmail());
        customer.setPictureUrl(createCustomer.getPictureUrl());
        customer.setMobilePhoneNumber(createCustomer.getMobilePhoneNumber());
        customer.setFixedPhoneNumber(createCustomer.getFixedPhoneNumber());
        customer.setPositionHeld(createCustomer.getPositionHeld());
        customer.setStateProspect(StateProspect.ENDED);
        customer.setCompany(createCustomer.getCompany());
        customer.setRegisterDate(LocalDateTime.now());

        customer.setUser(user);

        this.partnerRepository.save(customer);

    }

    public void deletePartner(Long id) {
        this.partnerRepository.deleteById(id);
    }

    public void editPartner(Long id, EditPartner editPartner) {
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
            partner.setCompany(companyRepository.findById(Long.parseLong(editPartner.getCompanyId())).get());
        }

        MultipartFile picture = editPartner.getPictureFile();
        if (picture == null || picture.isEmpty()) {
            partner.setPictureUrl(editPartner.getPictureUrl());
        } else {
            storageService.store(picture);
            partner.setPictureUrl("http://localhost:8080/images/" + picture.getOriginalFilename());
        }

        this.partnerRepository.save(partner);

    }


    public void addDunningPeriod(Long id, CreateDunning createDunning) {
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
