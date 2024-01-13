package com.muez.hotel.controllers;

import com.muez.hotel.entities.Hotel;
import com.muez.hotel.service.HotelServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/hotels")
public class HotelController {

    @Autowired
    private HotelServices hotelServices;

    //create
    @PostMapping
    public ResponseEntity<Hotel> createHotel(@RequestBody Hotel hotel){
        Hotel createHotel = hotelServices.createHotel(hotel);
        return ResponseEntity.status(HttpStatus.CREATED).body(createHotel);
    }

    //getById
    @GetMapping("/{hotelId}")
    public  ResponseEntity<Hotel> getById(@PathVariable String hotelId){
        Hotel hotel = hotelServices.getById(hotelId);
        return ResponseEntity.ok(hotel);
    }

    //getAll
    @GetMapping
    public ResponseEntity<List<Hotel>> getAll(){
        List<Hotel> hotels = hotelServices.getAll();
        return ResponseEntity.ok(hotels);
    }

    //delete
    @DeleteMapping("/hotelId")
    public void deleteHotel(@PathVariable String hotelId){
        hotelServices.deleteHotel(hotelId);
    }

    //update
    @PutMapping
    public ResponseEntity<Hotel> updateHotel(@RequestBody Hotel hotel){
        Hotel updateHotel = hotelServices.updateHotel(hotel);
        return ResponseEntity.ok(updateHotel);
    }
}
