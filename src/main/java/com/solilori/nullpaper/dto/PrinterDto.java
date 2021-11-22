package com.solilori.nullpaper.dto;

import com.solilori.nullpaper.entities.Customer;
import com.solilori.nullpaper.entities.Printer;

import java.io.Serializable;
import java.util.Objects;

public class PrinterDto implements Serializable {

    private Long id;
    private String manufacturer;
    private String model;
    private String serialNumber;
    private boolean active;

    private Customer customer;

    public PrinterDto() {

    }

    public PrinterDto(Long id, String manufacturer, String model, String serialNumber, boolean active, Customer customer) {
        this.id = id;
        this.manufacturer = manufacturer;
        this.model = model;
        this.serialNumber = serialNumber;
        this.active = active;
        this.customer = customer;
    }

    public PrinterDto(Printer entity) {
        id = entity.getId();
        manufacturer = entity.getManufacturer();
        model = entity.getModel();
        serialNumber = entity.getSerialNumber();
        active = entity.isActive();
        customer = entity.getCustomer();
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

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PrinterDto that = (PrinterDto) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
