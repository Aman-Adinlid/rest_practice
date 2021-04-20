package se.lexicon.rest_practice.entity;

import javax.persistence.Embeddable;


@Embeddable
public class Address {

    private String street;
    private String zipCode;
    private String city;
    private String country;
}
