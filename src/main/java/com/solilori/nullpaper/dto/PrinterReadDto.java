package com.solilori.nullpaper.dto;

import com.solilori.nullpaper.entities.Computer;
import com.solilori.nullpaper.entities.PrinterRead;
import org.springframework.hateoas.RepresentationModel;

import java.io.Serializable;
import java.time.Instant;
import java.util.Objects;

public class PrinterReadDto extends RepresentationModel<PrinterReadDto> implements Serializable {

    private Long id;
    private String manufacturer;
    private String model;
    private String serialNumber;
    private String ipAddress;
    private Long tonerRemaining;
    private Long tonerCapacity;
    private Long totalPages;
    private Instant date;
    private Computer computer;


    public PrinterReadDto() {
    }

    public PrinterReadDto(Long id, String manufacturer, String model, String serialNumber, String ipAddress,
                          Long tonerRemaining, Long tonerCapacity, Long totalPages, Instant date, Computer computer) {
        this.id = id;
        this.manufacturer = manufacturer;
        this.model = model;
        this.serialNumber = serialNumber;
        this.ipAddress = ipAddress;
        this.tonerRemaining = tonerRemaining;
        this.tonerCapacity = tonerCapacity;
        this.totalPages = totalPages;
        this.date = date;
        this.computer = computer;
    }

    public PrinterReadDto(PrinterRead entity) {
        this.id = entity.getId();
        this.manufacturer = entity.getManufacturer();
        this.model = entity.getModel();
        this.serialNumber = entity.getSerialNumber();
        this.ipAddress = entity.getIpAddress();
        this.tonerRemaining = entity.getTonerRemaining();
        this.tonerCapacity = entity.getTonerCapacity();
        this.totalPages = entity.getTotalPages();
        this.date = entity.getDate();
        this.computer = entity.getComputer();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public String getIpAddress() {
        return ipAddress;
    }

    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }

    public Long getTonerRemaining() {
        return tonerRemaining;
    }

    public void setTonerRemaining(Long tonerRemaining) {
        this.tonerRemaining = tonerRemaining;
    }

    public Long getTonerCapacity() {
        return tonerCapacity;
    }

    public void setTonerCapacity(Long tonerCapacity) {
        this.tonerCapacity = tonerCapacity;
    }

    public Long getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(Long totalPages) {
        this.totalPages = totalPages;
    }

    public Computer getComputer() {
        return computer;
    }

    public void setComputer(Computer computer) {
        this.computer = computer;
    }

    public Instant getDate() {
        return date;
    }

    public void setDate(Instant date) {
        this.date = date;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PrinterReadDto that = (PrinterReadDto) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
