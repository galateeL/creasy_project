package com.example.creasy.service;

import com.example.creasy.controller.CreateCompany;
import com.example.creasy.exception.PartnerNotFoundException;
import com.example.creasy.repository.*;
import com.example.creasy.repository.entity.Company;
import com.example.creasy.repository.entity.Partner;
import com.example.creasy.repository.entity.StateProspect;
import org.springframework.stereotype.Service;

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

    public List<Partner> getAllProspect() {
        return this.partnerRepository.findByStateProspectIsNot(StateProspect.ENDED);
    }

    public List<Partner> getAllCustomer() {
        return this.partnerRepository.findByStateProspectIs(StateProspect.ENDED);
    }


    public Partner findPartnerById(Long id) {
        return this.partnerRepository.findById(id).get();
    }

    public Partner getPartner(Long id) {
        return this.partnerRepository
                .findById(id)
                .orElseThrow(() -> new PartnerNotFoundException(id));
    }

    public void createProspect(CreateProspect createProspect) {

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

        this.partnerRepository.save(prospect);

    }

    public void createCustomer(CreateCustomer createCustomer) {

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
