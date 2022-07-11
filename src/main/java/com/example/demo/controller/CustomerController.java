package com.example.demo.controller;

import com.example.demo.commons.FriendFamilyDto;
import com.example.demo.commons.PlanDto;
import com.example.demo.commons.RequestC;
import com.example.demo.commons.ResponseC;
import com.example.demo.entity.Customer;
import com.example.demo.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/customer")
@RefreshScope
public class CustomerController {

    @Autowired
    CustomerService customerService;

    @Autowired
    RestTemplate restTemplate;

    @Value("${plan.uri}")
    String planuri;

    @Value("${friend.uri}")
    String frienduri;

    @PostMapping(value = "/insert")
    public ResponseEntity<ResponseC> insertCustomer(@RequestBody RequestC requestC){
        Customer customer=requestC.getCustomer();
        PlanDto planDto=requestC.getPlanDto();
        FriendFamilyDto friendFamilyDto=requestC.getFriendFamilyDto();
        planDto.setPlanId(customer.getPlanId());
        friendFamilyDto.setPhoneNo(customer.getPhoneNo());
        friendFamilyDto.setFriendAndFamily(customer.getFriendAndFamily());
        customerService.insertCustomer(customer);

        PlanDto planDto1=restTemplate.postForObject(planuri+"/insert",planDto,PlanDto.class);
        FriendFamilyDto friendFamilyDto1=restTemplate.postForObject(frienduri+"/insert",friendFamilyDto,FriendFamilyDto.class);
        Customer customer1=customerService.getCustomer(customer.getPhoneNo());

        ResponseC responseC=new ResponseC(customer1,planDto1,friendFamilyDto1);
        return new ResponseEntity<>(responseC, HttpStatus.ACCEPTED);
    }

    @GetMapping(value = "/get/{phoneNo}")
    public ResponseC getOnecustomer(@PathVariable("phoneNo") Long phoneNo){
        Customer customer=customerService.getCustomer(phoneNo);
        PlanDto planDto=restTemplate.getForObject(planuri+"/get/"+customer.getPlanId(),PlanDto.class);
        FriendFamilyDto friendFamilyDto=restTemplate.getForObject(frienduri+"/get/"+customer.getPhoneNo(),FriendFamilyDto.class);
        ResponseC responseC=new ResponseC(customer,planDto,friendFamilyDto);
        return responseC;
    }
}
