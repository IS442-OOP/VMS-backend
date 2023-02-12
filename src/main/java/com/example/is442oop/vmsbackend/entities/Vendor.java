package com.example.is442oop.vmsbackend.entities;

import jakarta.persistence.*;

@Entity
public class Vendor extends UserType {
    private String companyDescription;


    public Vendor(String companyDescription) {
        super();
        this.companyDescription = companyDescription;
    }

    public String getCompanyDescription() {
        return companyDescription;
    }

    public void setCompanyDescription(String companyDescription) {
        this.companyDescription = companyDescription;
    }

    
}
