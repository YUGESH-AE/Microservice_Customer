package com.example.demo.commons;

import com.example.demo.entity.Customer;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ResponseC {

    private Customer customer;
    private PlanDto planDto;
    private FriendFamilyDto friendFamilyDto;
}
