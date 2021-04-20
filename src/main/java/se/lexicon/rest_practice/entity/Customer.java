package se.lexicon.rest_practice.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private int age;
    private Gender gender;
    @Embedded//********* no need to relation signs when u use this
    private Address address;

}
