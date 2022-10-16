package com.example.project.service;

import com.example.project.exception.PartnerNotFoundException;
import com.example.project.repository.CreatePartner;
import com.example.project.repository.CreateProspect;
import com.example.project.repository.EditPartner;
import com.example.project.repository.PartnerRepository;
import com.example.project.repository.entity.Partner;
import com.example.project.repository.entity.StateProspect;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.awt.print.Book;
import java.time.LocalDate;
import java.util.List;

@Service
public class PartnerService {

    private PartnerRepository partnerRepository;

    public PartnerService(PartnerRepository partnerRepository) {
        this.partnerRepository = partnerRepository;
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

    public void createProspect (CreateProspect createProspect) {

        Partner prospect = new Partner();
        prospect.setFirstname(createProspect.getFirstname());
        prospect.setLastname(createProspect.getLastname());
        prospect.setEmail(createProspect.getEmail());
        prospect.setPictureUrl(createProspect.getPictureUrl());
        prospect.setMobilePhoneNumber(createProspect.getMobilePhoneNumber());
        prospect.setFixedPhoneNumber(createProspect.getFixedPhoneNumber());
        prospect.setPositionHeld(createProspect.getPositionHeld());
        prospect.setStateProspect(createProspect.getStateProspect());

        this.partnerRepository.save(prospect);

    }

    public void createCustomer (CreateProspect createProspect) {

        Partner customer = new Partner();
        customer.setFirstname(createProspect.getFirstname());
        customer.setLastname(createProspect.getLastname());
        customer.setEmail(createProspect.getEmail());
        customer.setPictureUrl(createProspect.getPictureUrl());
        customer.setMobilePhoneNumber(createProspect.getMobilePhoneNumber());
        customer.setFixedPhoneNumber(createProspect.getFixedPhoneNumber());
        customer.setPositionHeld(createProspect.getPositionHeld());
        customer.setStateProspect(StateProspect.ENDED);

        this.partnerRepository.save(customer);

    }

    public void deletePartner(Long id) {
        this.partnerRepository.deleteById(id);
    }

    public void editPartner(Long id, EditPartner editPartner) {
        Partner partner = this.partnerRepository
                .findById(id)
                .orElseThrow(()-> new PartnerNotFoundException(id));

        partner.setFirstname(editPartner.getFirstname());
        partner.setLastname(editPartner.getLastname());
        partner.setEmail(editPartner.getEmail());
        partner.setPictureUrl(editPartner.getPictureUrl());
        partner.setFixedPhoneNumber(editPartner.getFixedPhoneNumber());
        partner.setMobilePhoneNumber(editPartner.getMobilePhoneNumber());
        partner.setPositionHeld(editPartner.getPositionHeld());
        partner.setStateProspect(StateProspect.valueOf(editPartner.getStateProspect()));

        this.partnerRepository.save(partner);

    }



}
