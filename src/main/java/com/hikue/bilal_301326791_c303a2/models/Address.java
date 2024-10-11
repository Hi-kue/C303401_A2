package com.hikue.bilal_301326791_c303a2.models;

import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.io.Serializable;

@Data
@Embeddable
public class Address implements Serializable {
    @NotBlank(message = "Address is required, and must be provided.")
    private String address;

    @NotBlank(message = "City is required, and must be provided.")
    private String city;

    @NotBlank(message = "State is required, and must be provided.")
    private String state;

    @NotBlank(message = "Zip Code is required, and must be provided.")
    private String zipCode;

    @NotBlank(message = "Country is required, and must be provided.")
    private String country;
}