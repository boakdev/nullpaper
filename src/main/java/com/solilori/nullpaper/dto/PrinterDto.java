package com.solilori.nullpaper.dto;

import com.solilori.nullpaper.entities.Customer;
import com.solilori.nullpaper.entities.Printer;
import com.solilori.nullpaper.services.validation.PrinterValid;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.util.Objects;

@PrinterValid
public class PrinterDto implements Serializable {

    private Long id;

    @NotBlank(message = "Campo obrigatório")
    private String manufacturer;

    @NotBlank(message = "Campo obrigatório")
    private String model;

    @NotBlank(message = "Campo obrigatório")
    private String serialNumber;
    private boolean active;




    public PrinterDto() {

    }

    public PrinterDto(Long id, String manufacturer, String model, String serialNumber, boolean active) {
        this.id = id;
        this.manufacturer = manufacturer;
        this.model = model;
        this.serialNumber = serialNumber;
        this.active = active;


    }

    public PrinterDto(Printer entity) {
        id = entity.getId();
        manufacturer = entity.getManufacturer();
        model = entity.getModel();
        serialNumber = entity.getSerialNumber();
        active = entity.isActive();
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
