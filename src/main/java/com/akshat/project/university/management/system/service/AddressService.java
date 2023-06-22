package com.akshat.project.university.management.system.service;

import com.akshat.project.university.management.system.model.Address;
import com.akshat.project.university.management.system.repository.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressService {
    @Autowired
    private final AddressRepository addressRepository;
    public AddressService(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }
    public List<Address> getAllAddresses() {
        return addressRepository.findAll();
    }
    public Address getAddressById(Long id) {
        return addressRepository.findById(id).orElseThrow(() -> new IllegalStateException("Address not found"));
    }
    public Address createAddress(Address address) {
        return addressRepository.save(address);
    }
    public Address updateAddress(Long id, Address addressDetails) {
        Address address = addressRepository.findById(id).orElseThrow(() -> new IllegalStateException("Address not found"));
        return addressRepository.save(addressDetails);
    }
    public Address deleteAddress(Long id) {
        Address address = addressRepository.findById(id).orElseThrow(() -> new IllegalStateException("Address not found"));
        addressRepository.deleteById(id);
        return address;
    }
}
