package com.akshat.project.university.management.system.controller;


import com.akshat.project.university.management.system.model.Address;
import com.akshat.project.university.management.system.service.AddressService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@AllArgsConstructor
@RestController
@RequestMapping("/api/v1/address")
public class AddressController {
    @Autowired
    private final AddressService addressService;

//    @GetMapping
//    public ResponseEntity<Iterable<Address>> getAllAddresses() {
//        return ResponseEntity.ok(addressService.getAllAddresses());
//    }

    @GetMapping("/{id}")
    public ResponseEntity<Address> getAddressById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(addressService.getAddressById(id));
    }

    @PostMapping
    public ResponseEntity<Address> createAddress(@RequestBody Address address) {
        return ResponseEntity.ok(addressService.createAddress(address));
    }

    @PutMapping
    public ResponseEntity<Address> updateAddress(@RequestBody Address address) {
        Long id = address.getId();
        return ResponseEntity.ok(addressService.updateAddress(id, address));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Address> deleteAddress(@PathVariable("id") Long id) {
        return ResponseEntity.ok(addressService.deleteAddress(id));
    }
}
