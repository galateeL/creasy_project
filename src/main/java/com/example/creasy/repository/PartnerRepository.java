package com.example.creasy.repository;

import com.example.creasy.model.Partner;
import com.example.creasy.model.StateProspect;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PartnerRepository extends CrudRepository<Partner, Long> {
    // All prospects
    @Query("select p from Partner p where p.stateProspect in ?1 and (p.firstname like ?2% or p.lastname like ?2% or p.company.name like ?2%) and p.user.email = ?3")
    List<Partner>  findProspectByKeyword (List<StateProspect> prospectStates, String keywordProspect, String email);

    @Query("select p from Partner  p where p.stateProspect in ?1 and p.user.email = ?2")
    List<Partner> findProspectsByUser (List<StateProspect> prospectStates, String email);

    // All customers
    @Query("select p from Partner p where p.stateProspect in ?1 and (p.firstname like ?2% or p.lastname like ?2% or p.company.name like ?2%) and p.user.email = ?3 ")
    List<Partner> findCustomerByKeyword (List<StateProspect> customerState, String keywordCustomer, String email);

    @Query("select p from Partner  p where p.stateProspect in ?1 and p.user.email = ?2")
    List <Partner> findCustomerByUser(List<StateProspect> customerState, String email);

    @Query("select p from Partner p where p.stateProspect = ?1 OR p.stateProspect =?2")
    List<Partner> findCustomer (StateProspect stateProspect,StateProspect stateProspect2);


    // Customers
    @Query("select p from Partner p where p.stateProspect in ?1 and p.user.email = ?2 order by p.lastname desc")
    List <Partner> findCustomerOrderByLastnameDesc(List<StateProspect> customerState, String email);
    @Query("select p from Partner p where p.stateProspect in ?1 and p.user.email = ?2 order by p.lastname asc")
    List<Partner> findCustomerOrderByLastnameAsc(List<StateProspect> customerState, String email);
    @Query("select p from Partner p where p.stateProspect in ?1 and p.user.email = ?2 order by p.registerDate asc")
    List<Partner> findCustomerOrderByRegisterDateAsc(List<StateProspect> customerState, String email);
    @Query("select p from Partner p where p.stateProspect in ?1 and p.user.email = ?2 order by p.registerDate desc")
    List<Partner> findCustomerOrderByRegisterDateDesc(List<StateProspect> customerState, String email);


    // Prospects
    @Query("select p from Partner p where p.stateProspect in ?1 and p.user.email = ?2 order by p.lastname desc")
    List<Partner> findProspectOrderByLastnameDesc (List<StateProspect> prospectStates, String email);

    @Query("select p from Partner p where p.stateProspect in ?1 and p.user.email = ?2 order by p.lastname asc")
    List<Partner> findProspectOrderByLastnameAsc(List<StateProspect> prospectStates, String email);

    @Query("select p from Partner p where p.stateProspect in ?1 and p.user.email = ?2 order by p.registerDate asc")
    List<Partner> findProspectOrderByRegisterDateAsc(List<StateProspect> prospectStates, String email);

    @Query("select p from Partner p where p.stateProspect in ?1 and p.user.email = ?2 order by p.registerDate desc")
    List<Partner> findProspectOrderByRegisterDateDesc(List<StateProspect> prospectStates, String email);

    @Query("SELECT p FROM Partner p WHERE p.company.id = :id")
    List<Partner> findByCompanyId(@Param("id") Long id);


    // Number of prospects with specific state by user
    @Query("select count(p.stateProspect) from Partner  p where p.stateProspect = ?1 and p.user.email = ?2")
    int findProspectIsAndUserEmailIs (StateProspect stateProspect, String email);


    // Numbers of customers by user
    @Query("select count(p.stateProspect)from Partner  p where p.stateProspect = ?1 and p.user.email = ?2")
    int findNumberCustomersByUserEmail (StateProspect stateProspect, String email);

    // Number of prospects by user
    @Query("select count(p.stateProspect)from Partner  p where p.stateProspect <> ?1 and p.user.email = ?2")
    int findNumberProspectsByUserEmail (StateProspect stateProspect, String email);



    // Prospect List by user
    @Query("select p from Partner p WHERE p.stateProspect <> ?1 and p.stateProspect <> ?2 and p.user.email = ?3")
    List <Partner> findProspectsListByUser(StateProspect stateProspect1, StateProspect stateProspect2, String email);
}
