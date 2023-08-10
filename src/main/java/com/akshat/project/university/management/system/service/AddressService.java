package com.akshat.project.university.management.system.service;

import com.akshat.project.university.management.system.error.ApiRequestException;
import com.akshat.project.university.management.system.model.Address;
import com.akshat.project.university.management.system.repository.AddressRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class AddressService {
    private final AddressRepository addressRepository;

    public Address getAddressById(Long id) {
        return addressRepository.findById(id).orElseThrow(() -> new ApiRequestException(
                "Address with id: " + id + " does not exist",
                HttpStatus.NOT_FOUND
        ));
    }

    public Address createAddress(Address address) {
        try {
            return addressRepository.save(address);
        } catch (Exception e) {
            throw new ApiRequestException("Could not create address", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public Address updateAddress(Long id, Address addressDetails) {
        Address address = addressRepository.findById(id).orElseThrow(() -> new ApiRequestException("Address with id: " + id + " does not exist",
                HttpStatus.NOT_FOUND));
        address.setHouseNo(addressDetails.getHouseNo());
        address.setStreet(addressDetails.getStreet());
        address.setCity(addressDetails.getCity());
        address.setState(addressDetails.getState());
        address.setCountry(addressDetails.getCountry());
        address.setPincode(addressDetails.getPincode());
        try {
            return addressRepository.save(address);
        } catch (Exception e) {
            throw new ApiRequestException("Could not update address with id: " + id, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public Address deleteAddress(Long id) {
        Address address = addressRepository.findById(id).orElseThrow(() -> new ApiRequestException("Address with id: " + id + " does not exist",
                HttpStatus.NOT_FOUND));
        try {
            addressRepository.deleteById(id);
        } catch (Exception e) {
            throw new ApiRequestException("Could not delete address with id: " + id, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return address;
    }
}
