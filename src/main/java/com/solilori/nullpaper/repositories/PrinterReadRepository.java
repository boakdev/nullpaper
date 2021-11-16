package com.solilori.nullpaper.repositories;

import com.solilori.nullpaper.entities.PrinterRead;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PrinterReadRepository extends JpaRepository<PrinterRead, Long> {

    @Query("SELECT p FROM PrinterRead p WHERE UPPER(p.serialNumber) LIKE CONCAT (UPPER(:serialNumber), '%')")
    List<PrinterRead> findBySerialNumber(String serialNumber);

}
