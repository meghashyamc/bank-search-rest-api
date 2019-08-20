package com.meghashyam.banksearch.service;

import com.meghashyam.banksearch.model.Banksearch;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface BanksearchRepository extends JpaRepository<Banksearch, String> {


    @Query("SELECT b FROM Banksearch b where LOWER(b.branch) LIKE LOWER(CONCAT(:searchTerm, '%'))")
    public Page<Banksearch> findByBranchPrefix(@Param("searchTerm") String searchTerm, Pageable pageable);


    @Query("SELECT b FROM Banksearch b where " +
            "LOWER(b.ifsc) LIKE LOWER(CONCAT('%', :searchTerm, '%')) OR " +
            "LOWER(b.branch) LIKE LOWER(CONCAT('%', :searchTerm, '%')) OR " +
            "LOWER(b.address) LIKE LOWER(CONCAT('%', :searchTerm, '%')) OR " +
            "LOWER(b.city) LIKE LOWER(CONCAT('%', :searchTerm, '%')) OR " +
            "LOWER(b.district) LIKE LOWER(CONCAT('%', :searchTerm, '%')) OR " +
            "LOWER(b.state) LIKE LOWER(CONCAT('%', :searchTerm, '%'))")

    public Page<Banksearch> findByKeyword(@Param("searchTerm") String searchTerm, Pageable pageable);


}
