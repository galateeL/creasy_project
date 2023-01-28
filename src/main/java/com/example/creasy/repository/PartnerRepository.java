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
    @Query("select p from Partner p where p.stateProspect <> ?1 and (p.firstname like ?2% or p.lastname like ?2% or p.company.name like ?2%) and p.user.email = ?3")
    List<Partner>  findProspectByStateProspectAndFirstnameOrLastnameOrCompanyName (StateProspect stateProspect, String keywordProspect, String email);


    @Query("select p from Partner  p where p.stateProspect <> ?1 and p.user.email = ?2")
    List<Partner> findByStateProspectIsNotAndUserEmailIs (StateProspect stateProspect, String email);

    // All customers
    @Query("select p from Partner p where p.stateProspect = ?1 and (p.firstname like ?2% or p.lastname like ?2% or p.company.name like ?2%) and p.user.email = ?3 ")
    List<Partner> findCustomerByStateProspectAndFirstnameOrLastnameOrCompanyName (StateProspect stateProspect, String keywordCustomer, String email);

    @Query("select p from Partner  p where p.stateProspect = ?1 and p.user.email = ?2")
    List <Partner> findByStateProspectIsAndUserEmailIs(StateProspect stateProspect, String email);

    // Tri customer Z-A
    @Query("select p from Partner p where p.stateProspect = ?1 and (p.firstname like ?2% or p.lastname like ?2% or p.company.name like ?2%) and p.user.email = ?3 order by p.lastname DESC")
    List<Partner> findCustomerZA (StateProspect stateProspect, String keywordCustomer, String email);

    // Tri prospect Z-A
    @Query("select p from Partner p where p.stateProspect <> ?1 and (p.firstname like ?2% or p.lastname like ?2% or p.company.name like ?2%) and p.user.email = ?3 order by p.lastname DESC")
    List<Partner>  findProspectZA (StateProspect stateProspect, String keywordProspect, String email);

    // Tri customer A-Z
    @Query("select p from Partner p where p.stateProspect = ?1 and (p.firstname like ?2% or p.lastname like ?2% or p.company.name like ?2%) and p.user.email = ?3 order by p.lastname ASC")
    List<Partner> findCustomerAZ (StateProspect stateProspect, String keywordCustomer, String email);

    // Tri prospect A-Z
    @Query("select p from Partner p where p.stateProspect <> ?1 and (p.firstname like ?2% or p.lastname like ?2% or p.company.name like ?2%) and p.user.email = ?3 order by p.lastname ASC")
    List<Partner>  findProspectAZ (StateProspect stateProspect, String keywordProspect, String email);

    // Tri customer Oldest to Newest
    @Query("select p from Partner p where p.stateProspect = ?1 and (p.firstname like ?2% or p.lastname like ?2% or p.company.name like ?2%) and p.user.email = ?3 order by p.registerDate ASC")
    List<Partner> findCustomerON (StateProspect stateProspect, String keywordCustomer, String email);

    // Tri prospect Oldest to Newest
    @Query("select p from Partner p where p.stateProspect <> ?1 and (p.firstname like ?2% or p.lastname like ?2% or p.company.name like ?2%) and p.user.email = ?3 order by p.registerDate ASC")
    List<Partner>  findProspectON (StateProspect stateProspect, String keywordProspect, String email);

    // Tri customer Newest to Oldest
    @Query("select p from Partner p where p.stateProspect = ?1 and (p.firstname like ?2% or p.lastname like ?2% or p.company.name like ?2%) and p.user.email = ?3 order by p.registerDate DESC")
    List<Partner> findCustomerNO (StateProspect stateProspect, String keywordCustomer, String email);

    @Query("select p from Partner p where p.stateProspect = ?1 OR p.stateProspect =?2")
    List<Partner> findCustomer (StateProspect stateProspect,StateProspect stateProspect2);

    // Tri prospect Oldest to Newest
    @Query("select p from Partner p where p.stateProspect <> ?1 and (p.firstname like ?2% or p.lastname like ?2% or p.company.name like ?2%) and p.user.email = ?3 order by p.registerDate DESC")
    List<Partner>  findProspectNO (StateProspect stateProspect, String keywordProspect,String email);


    // Customers
    @Query("select p from Partner p where p.stateProspect = ?1 and p.user.email = ?2 order by p.lastname desc")
    List <Partner> findByStateProspectIsOrderByLastnameDesc(StateProspect stateProspect, String email);
    @Query("select p from Partner p where p.stateProspect = ?1 and p.user.email = ?2 order by p.lastname asc")
    List<Partner> findByStateProspectIsOrderByLastnameAsc(StateProspect stateProspect, String email);
    @Query("select p from Partner p where p.stateProspect = ?1 and p.user.email = ?2 order by p.registerDate asc")
    List<Partner> findByStateProspectIsOrderByRegisterDateAsc(StateProspect stateProspect, String email);
    @Query("select p from Partner p where p.stateProspect = ?1 and p.user.email = ?2 order by p.registerDate desc")
    List<Partner> findByStateProspectIsOrderByRegisterDateDesc(StateProspect stateProspect, String email);


    // Prospects
    @Query("select p from Partner p where p.stateProspect <> ?1 and p.user.email = ?2 order by p.lastname desc")
    List<Partner> findByStateProspectIsNotOrderByLastnameDesc (StateProspect stateProspect, String email);

    @Query("select p from Partner p where p.stateProspect <> ?1 and p.user.email = ?2 order by p.lastname asc")
    List<Partner> findByStateProspectIsNotOrderByLastnameAsc(StateProspect stateProspect, String email);

    @Query("select p from Partner p where p.stateProspect <> ?1 and p.user.email = ?2 order by p.registerDate asc")
    List<Partner> findByStateProspectIsNotOrderByRegisterDateAsc(StateProspect stateProspect, String email);

    @Query("select p from Partner p where p.stateProspect <> ?1 and p.user.email = ?2 order by p.registerDate desc")
    List<Partner> findByStateProspectIsNotOrderByRegisterDateDesc(StateProspect stateProspect, String email);

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
