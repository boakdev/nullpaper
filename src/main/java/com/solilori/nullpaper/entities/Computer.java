package com.solilori.nullpaper.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

@Entity
public class Computer implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String computerName;
    private String userName;
    private String userFolder;
    private String nameOS;
    private String versionOS;
    private String arcOS;
    private String ipAddressComputer;
    private String countrySystem;
    private String languageSystem;
    private String serialHD;
    private String serialCPU;
    private String serialMotherboard;
    private String serialMAC;

    public Computer() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getComputerName() {
        return computerName;
    }

    public void setComputerName(String computerName) {
        this.computerName = computerName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserFolder() {
        return userFolder;
    }

    public void setUserFolder(String userFolder) {
        this.userFolder = userFolder;
    }

    public String getNameOS() {
        return nameOS;
    }

    public void setNameOS(String nameOS) {
        this.nameOS = nameOS;
    }

    public String getVersionOS() {
        return versionOS;
    }

    public void setVersionOS(String versionOS) {
        this.versionOS = versionOS;
    }

    public String getArcOS() {
        return arcOS;
    }

    public void setArcOS(String arcOS) {
        this.arcOS = arcOS;
    }

    public String getIpAddressComputer() {
        return ipAddressComputer;
    }

    public void setIpAddressComputer(String ipAddressComputer) {
        this.ipAddressComputer = ipAddressComputer;
    }

    public String getCountrySystem() {
        return countrySystem;
    }

    public void setCountrySystem(String countrySystem) {
        this.countrySystem = countrySystem;
    }

    public String getLanguageSystem() {
        return languageSystem;
    }

    public void setLanguageSystem(String languageSystem) {
        this.languageSystem = languageSystem;
    }

    public String getSerialHD() {
        return serialHD;
    }

    public void setSerialHD(String serialHD) {
        this.serialHD = serialHD;
    }

    public String getSerialCPU() {
        return serialCPU;
    }

    public void setSerialCPU(String serialCPU) {
        this.serialCPU = serialCPU;
    }

    public String getSerialMotherboard() {
        return serialMotherboard;
    }

    public void setSerialMotherboard(String serialMotherboard) {
        this.serialMotherboard = serialMotherboard;
    }

    public String getSerialMAC() {
        return serialMAC;
    }

    public void setSerialMAC(String serialMAC) {
        this.serialMAC = serialMAC;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Computer computer = (Computer) o;
        return Objects.equals(id, computer.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
