package com.example.creasy.repository;

import com.example.creasy.repository.entity.Partner;
import com.example.creasy.repository.entity.StateProspect;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PartnerRepository extends CrudRepository<Partner, Long> {

    List<Partner> findByStateProspectIsNot (StateProspect stateProspect);

    List<Partner> findByStateProspectIs (StateProspect stateProspect);


}
