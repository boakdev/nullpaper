package com.solilori.nullpaper.repositories;

import com.solilori.nullpaper.entities.Printer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PrinterRepository extends JpaRepository<Printer,  Long> {
}
