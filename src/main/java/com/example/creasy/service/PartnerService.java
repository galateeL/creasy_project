package com.example.creasy.service;

import com.example.creasy.exception.PartnerNotFoundException;
import com.example.creasy.repository.*;
import com.example.creasy.repository.entity.Partner;
import com.example.creasy.repository.entity.StateProspect;
import com.example.creasy.repository.entity.User;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class PartnerService {

    private PartnerRepository partnerRepository;
    private CompanyRepository companyRepository;

    public PartnerService(PartnerRepository partnerRepository, CompanyRepository companyRepository) {
        this.partnerRepository = partnerRepository;
        this.companyRepository = companyRepository;
    }

    public List<Partner> getAllPartner() {
        return (List<Partner>) this.partnerRepository.findAll();
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
        prospect.setPictureUrl(createProspect.getPictureUrl());
        prospect.setMobilePhoneNumber(createProspect.getMobilePhoneNumber());
        prospect.setFixedPhoneNumber(createProspect.getFixedPhoneNumber());
        prospect.setPositionHeld(createProspect.getPositionHeld());
        prospect.setStateProspect(createProspect.getStateProspect());
        prospect.setCompany(createProspect.getCompany());
        prospect.setRegisterDate(LocalDateTime.now());

        prospect.setUser(user);

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
        partner.setPictureUrl(editPartner.getPictureUrl());
        partner.setFixedPhoneNumber(editPartner.getFixedPhoneNumber());
        partner.setMobilePhoneNumber(editPartner.getMobilePhoneNumber());
        partner.setPositionHeld(editPartner.getPositionHeld());
        partner.setCompany(editPartner.getCompany());

        this.partnerRepository.save(partner);

    }

}
