package com.muez.hotel.service;

import com.muez.hotel.entities.Hotel;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface HotelServices {
    //create
    Hotel createHotel(Hotel hotel);

    //getbyId
    Hotel getById(String hotelId);

    //getAll
    List<Hotel> getAll();

    //Delete
    void deleteHotel(String hotelId);

    //update
    Hotel updateHotel(Hotel hotel);
}
