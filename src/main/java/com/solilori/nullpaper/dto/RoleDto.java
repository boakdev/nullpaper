package com.solilori.nullpaper.dto;

import com.solilori.nullpaper.entities.Role;

import java.io.Serializable;
import java.util.Objects;

public class RoleDto implements Serializable {

    private Long id;
    private String authority;

    public RoleDto() {

    }

    public RoleDto(Long id, String authority) {
        this.id = id;
        this.authority = authority;
    }

    public RoleDto(Role role) {
        id = role.getId();
        authority = role.getAuthority();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAuthority() {
        return authority;
    }

    public void setAuthority(String authority) {
        this.authority = authority;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RoleDto roleDto = (RoleDto) o;
        return Objects.equals(id, roleDto.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
