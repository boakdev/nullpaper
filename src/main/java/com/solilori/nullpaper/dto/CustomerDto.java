package com.solilori.nullpaper.dto;

import com.solilori.nullpaper.entities.Customer;
import com.solilori.nullpaper.entities.Printer;
import org.springframework.hateoas.RepresentationModel;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class CustomerDto extends RepresentationModel<CustomerDto> implements Serializable {

    private Long id;

    @NotBlank(message = "Campo obrigatório")
    private String name;

    private String cpfCnpj;
    private String email;
    private String company;
    private String cellPhone;
    private String phone;
    private String streetAddress;
    private String zipCodeAddress;
    private String numberAddress;
    private String complementAddress;
    private String districtAddress;
    private String cityAddress;
    private String stateAddress;
    private String countryAddress;
    private String comments;

    private Set<PrinterDto> printers = new HashSet<>();

    public CustomerDto() {
    }

    public CustomerDto(Long id, String name, String cpfCnpj, String email, String company, String cellPhone, String phone, String streetAddress, String zipCodeAddress, String numberAddress, String complementAddress, String districtAddress, String cityAddress, String stateAddress, String countryAddress, String comments) {
        this.id = id;
        this.name = name;
        this.cpfCnpj = cpfCnpj;
        this.email = email;
        this.company = company;
        this.cellPhone = cellPhone;
        this.phone = phone;
        this.streetAddress = streetAddress;
        this.zipCodeAddress = zipCodeAddress;
        this.numberAddress = numberAddress;
        this.complementAddress = complementAddress;
        this.districtAddress = districtAddress;
        this.cityAddress = cityAddress;
        this.stateAddress = stateAddress;
        this.countryAddress = countryAddress;
        this.comments = comments;
    }

    public CustomerDto(Customer entity) {
        id = entity.getId();
        name = entity.getName();
        cpfCnpj = entity.getCpfCnpj();
        email = entity.getEmail();
        company = entity.getCompany();
        cellPhone = entity.getCellPhone();
        phone = entity.getPhone();
        streetAddress = entity.getStreetAddress();
        zipCodeAddress = entity.getZipCodeAddress();
        numberAddress = entity.getNumberAddress();
        complementAddress = entity.getComplementAddress();
        districtAddress = entity.getDistrictAddress();
        cityAddress = entity.getCityAddress();
        stateAddress = entity.getStateAddress();
        countryAddress = entity.getCountryAddress();
        comments = entity.getComments();

    }

    public CustomerDto(Customer entity, Set<Printer> printers) {
        this(entity);
        printers.forEach(pri -> this.printers.add(new PrinterDto(pri)));
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCpfCnpj() {
        return cpfCnpj;
    }

    public void setCpfCnpj(String cpfCnpj) {
        this.cpfCnpj = cpfCnpj;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getCellPhone() {
        return cellPhone;
    }

    public void setCellPhone(String cellPhone) {
        this.cellPhone = cellPhone;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getStreetAddress() {
        return streetAddress;
    }

    public void setStreetAddress(String streetAddress) {
        this.streetAddress = streetAddress;
    }

    public String getZipCodeAddress() {
        return zipCodeAddress;
    }

    public void setZipCodeAddress(String zipCodeAddress) {
        this.zipCodeAddress = zipCodeAddress;
    }

    public String getNumberAddress() {
        return numberAddress;
    }

    public void setNumberAddress(String numberAddress) {
        this.numberAddress = numberAddress;
    }

    public String getComplementAddress() {
        return complementAddress;
    }

    public void setComplementAddress(String complementAddress) {
        this.complementAddress = complementAddress;
    }

    public String getDistrictAddress() {
        return districtAddress;
    }

    public void setDistrictAddress(String districtAddress) {
        this.districtAddress = districtAddress;
    }

    public String getCityAddress() {
        return cityAddress;
    }

    public void setCityAddress(String cityAddress) {
        this.cityAddress = cityAddress;
    }

    public String getStateAddress() {
        return stateAddress;
    }

    public void setStateAddress(String stateAddress) {
        this.stateAddress = stateAddress;
    }

    public String getCountryAddress() {
        return countryAddress;
    }

    public void setCountryAddress(String countryAddress) {
        this.countryAddress = countryAddress;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public Set<PrinterDto> getPrinters() {
        return printers;
    }

    public void setPrinters(Set<PrinterDto> printers) {
        this.printers = printers;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CustomerDto that = (CustomerDto) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
