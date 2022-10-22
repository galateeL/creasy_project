package com.example.creasy.repository;

import com.example.creasy.repository.entity.Partner;
import com.example.creasy.repository.entity.StateProspect;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import org.springframework.data.repository.query.Param;
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

    // Tri customer Z-A
    @Query("select p from Partner p where p.stateProspect = ?1 and (p.firstname like ?2% or p.lastname like ?2% or p.company.name like ?2%) order by p.lastname DESC")
    List<Partner> findCustomerZA (StateProspect stateProspect, String keywordCustomer);

    // Tri prospect Z-A
    @Query("select p from Partner p where p.stateProspect <> ?1 and (p.firstname like ?2% or p.lastname like ?2% or p.company.name like ?2%) order by p.lastname DESC")
    List<Partner>  findProspectZA (StateProspect stateProspect, String keywordProspect);

    // Tri customer A-Z
    @Query("select p from Partner p where p.stateProspect = ?1 and (p.firstname like ?2% or p.lastname like ?2% or p.company.name like ?2%) order by p.lastname ASC")
    List<Partner> findCustomerAZ (StateProspect stateProspect, String keywordCustomer);

    // Tri customer A-Z
    @Query("select p from Partner p where p.stateProspect <> ?1 and (p.firstname like ?2% or p.lastname like ?2% or p.company.name like ?2%) order by p.lastname ASC")
    List<Partner>  findProspectAZ (StateProspect stateProspect, String keywordProspect);

    // Tri customer Oldest to Newest
    @Query("select p from Partner p where p.stateProspect = ?1 and (p.firstname like ?2% or p.lastname like ?2% or p.company.name like ?2%) order by p.registerDate ASC")
    List<Partner> findCustomerON (StateProspect stateProspect, String keywordCustomer);

    // Tri prospect Oldest to Newest
    @Query("select p from Partner p where p.stateProspect <> ?1 and (p.firstname like ?2% or p.lastname like ?2% or p.company.name like ?2%) order by p.registerDate ASC")
    List<Partner>  findProspectON (StateProspect stateProspect, String keywordProspect);

    // Tri customer Newest to Oldest
    @Query("select p from Partner p where p.stateProspect = ?1 and (p.firstname like ?2% or p.lastname like ?2% or p.company.name like ?2%) order by p.registerDate DESC")
    List<Partner> findCustomerNO (StateProspect stateProspect, String keywordCustomer);

    // Tri prospect Oldest to Newest
    @Query("select p from Partner p where p.stateProspect <> ?1 and (p.firstname like ?2% or p.lastname like ?2% or p.company.name like ?2%) order by p.registerDate DESC")
    List<Partner>  findProspectNO (StateProspect stateProspect, String keywordProspect);


    // Customers
    List <Partner> findByStateProspectIsOrderByLastnameDesc(StateProspect stateProspect);

    List<Partner> findByStateProspectIsOrderByLastnameAsc(StateProspect stateProspect);

    List<Partner> findByStateProspectIsOrderByRegisterDateAsc(StateProspect stateProspect);

    List<Partner> findByStateProspectIsOrderByRegisterDateDesc(StateProspect stateProspect);


    // Prospects
    List<Partner> findByStateProspectIsNotOrderByLastnameDesc (StateProspect stateProspect);
    List<Partner> findByStateProspectIsNotOrderByLastnameAsc(StateProspect stateProspect);

    List<Partner> findByStateProspectIsNotOrderByRegisterDateAsc(StateProspect stateProspect);

    List<Partner> findByStateProspectIsNotOrderByRegisterDateDesc(StateProspect stateProspect);

    @Query("SELECT p FROM Partner p WHERE p.company.id = :id")
    List<Partner> findByCompanyId(@Param("id") Long id);


}
