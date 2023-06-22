package com.akshat.project.university.management.system.controller;

import com.akshat.project.university.management.system.model.Address;
import com.akshat.project.university.management.system.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/v1/address")
public class AddressController {
    @Autowired
    private final AddressService addressService;
    public AddressController(AddressService addressService) {
        this.addressService = addressService;
    }
    @GetMapping
    public List<Address> getAllAddresses() {
        return addressService.getAllAddresses();
    }
    @GetMapping("/{id}")
    public Address getAddressById(@PathVariable(value = "id") Long id) {
        return addressService.getAddressById(id);
    }
    @PostMapping
    public Address createAddress(Address address) {
        return addressService.createAddress(address);
    }
    @PutMapping("/{id}")
    public Address updateAddress(@PathVariable(value = "id") Long id, @RequestBody Address addressDetails) {
        return addressService.updateAddress(id, addressDetails);
    }
    @DeleteMapping("/{id}")
    public Address deleteAddress(@PathVariable(value = "id") Long id) {
        return addressService.deleteAddress(id);
    }

}
