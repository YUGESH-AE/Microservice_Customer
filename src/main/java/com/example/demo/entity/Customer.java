package com.example.demo.entity;


import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "customer_details")
public class Customer {


    @Id
    @Column(name = "phone_no", nullable = false)
    Long phoneNo;
    @Column(nullable = false, length = 50)
    String name;
    @Column(nullable = false)
    Integer age;
    @Column(nullable = false, length = 50)
    String address;
    @Column(nullable = false, length = 50)
    String password;
    @Column(nullable = false, length = 1)
    char gender;
    @Column(name = "plan_id", nullable = false)
    Integer planId;
    @Column(name = "friend_and_family")
    Long friendAndFamily;
}
