package se.lexicon.rest_practice.entity;

import lombok.Data;

import javax.persistence.Embeddable;

@Data
@Embeddable
public class Address {

    private String street;
    private String zipCode;
    private String city;
    private String country;
}
