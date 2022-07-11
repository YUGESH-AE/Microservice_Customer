package com.example.demo.commons;

import com.example.demo.entity.Customer;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class RequestC {
    private Customer customer;
    private PlanDto planDto;
    private FriendFamilyDto friendFamilyDto;
}
