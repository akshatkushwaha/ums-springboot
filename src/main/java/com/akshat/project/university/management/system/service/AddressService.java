package com.akshat.project.university.management.system.service;

import com.akshat.project.university.management.system.model.Address;
import com.akshat.project.university.management.system.repository.AddressRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class AddressService {
    @Autowired
    private final AddressRepository addressRepository;

    public Address getAddressById(Long id) {
        return addressRepository.findById(id).orElseThrow(() -> new IllegalStateException("Address not found"));
    }

    public Address createAddress(Address address) {
        return addressRepository.save(address);
    }

    public Address updateAddress(Long id, Address addressDetails) {
        Address address = addressRepository.findById(id).orElseThrow(() -> new IllegalStateException("Address not found"));
        address.setHouseNo(addressDetails.getHouseNo());
        address.setStreet(addressDetails.getStreet());
        address.setCity(addressDetails.getCity());
        address.setState(addressDetails.getState());
        address.setCountry(addressDetails.getCountry());
        address.setPincode(addressDetails.getPincode());
        return addressRepository.save(address);
    }

    public Address deleteAddress(Long id) {
        Address address = addressRepository.findById(id).orElseThrow(() -> new IllegalStateException("Address not found"));
        addressRepository.deleteById(id);
        return address;
    }
}
