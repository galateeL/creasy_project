package com.example.project.service;

import com.example.project.exception.PartnerNotFoundException;
import com.example.project.repository.EditPartner;
import com.example.project.repository.PartnerRepository;
import com.example.project.repository.entity.Partner;
import com.example.project.repository.entity.StateProspect;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Service;

import javax.servlet.http.Part;
import java.awt.print.Book;
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
        partner.setAddress(editPartner.getAddress());
        partner.setPictureUrl(editPartner.getPictureUrl());
        partner.setFixedPhoneNumber(editPartner.getFixedPhoneNumber());
        partner.setMobilePhoneNumber(editPartner.getMobilePhoneNumber());
        partner.setPositionHeld(editPartner.getPositionHeld());
        partner.setStateProspect(StateProspect.valueOf(editPartner.getStateProspect()));

        this.partnerRepository.save(partner);

    }



}
