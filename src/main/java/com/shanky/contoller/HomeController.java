package com.shanky.contoller;

import com.shanky.dao.CustomerDAO;

import com.shanky.model.customer;
import org.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.lang.*;
import java.io.*;
import java.util.List;
import java.util.Arrays;
/**
 * Created by shanky on 9/12/16.
 */
@RestController
public class HomeController {
    @RequestMapping(value="/")
    public String home(){
        return "home matlab ghar ";
    }

//    @Autowired
    @Autowired
    private CustomerDAO customerDAO;




    @RequestMapping(value="/customers")
    public JSONArray getCustomers() {
        List x=customerDAO.list();;
        JSONArray mJSONArray = new JSONArray(Arrays.asList(x));
        return mJSONArray;
    }

    @RequestMapping(value="/customers/{id}")
    public String getCustomer(@PathVariable("id") Long id) {

        customer customer = customerDAO.get(id);
        if (customer == null) {
            return "Not Found";
        }

        return customer.getEmail();
//        return new ResponseEntity(customer, HttpStatus.OK);

    }
//
//    @PostMapping(value = "/customers")
//    public ResponseEntity createCustomer(@RequestBody customer customer) {
//
//        customerDAO.create(customer);
//
//        return new ResponseEntity(customer, HttpStatus.OK);
//    }
//
//    @DeleteMapping("/customers/{id}")
//    public ResponseEntity deleteCustomer(@PathVariable Long id) {
//
//        if (null == customerDAO.delete(id)) {
//            return new ResponseEntity("No Customer found for ID " + id, HttpStatus.NOT_FOUND);
//        }
//
//        return new ResponseEntity(id, HttpStatus.OK);
//
//    }
//
//    @PutMapping("/customers/{id}")
//    public ResponseEntity updateCustomer(@PathVariable Long id, @RequestBody customer customer) {
//
//        customer = customerDAO.update(id, customer);
//
//        if (null == customer) {
//            return new ResponseEntity("No Customer found for ID " + id, HttpStatus.NOT_FOUND);
//        }
//
//        return new ResponseEntity(customer, HttpStatus.OK);
//    }
}
