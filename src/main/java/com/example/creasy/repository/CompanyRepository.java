package com.example.creasy.repository;

import com.example.creasy.model.Company;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CompanyRepository extends CrudRepository<Company, Long> {

    List<Company> findCompanyByNameContaining(String name);
}
