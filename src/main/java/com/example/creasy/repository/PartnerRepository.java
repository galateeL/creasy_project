package com.example.creasy.repository;

import com.example.creasy.repository.entity.Note;
import com.example.creasy.repository.entity.Partner;
import com.example.creasy.repository.entity.StateProspect;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PartnerRepository extends CrudRepository<Partner, Long> {

    @Query("select p from Partner p where p.stateProspect <> ?1 and (p.firstname like ?2% or p.lastname like ?2% or p.company.name like ?2%)")
    List<Partner>  findProspectByStateProspectAndFirstnameOrLastnameOrCompanyName (StateProspect stateProspect, String keywordProspect);

    List<Partner> findByStateProspectIsNot (StateProspect stateProspect);



    @Query("select p from Partner p where p.stateProspect = ?1 and (p.firstname like ?2% or p.lastname like ?2% or p.company.name like ?2%)")
    List<Partner> findCustomerByStateProspectAndFirstnameOrLastnameOrCompanyName (StateProspect stateProspect, String keywordCustomer);

    List <Partner> findByStateProspectIs(StateProspect stateProspect);

}
