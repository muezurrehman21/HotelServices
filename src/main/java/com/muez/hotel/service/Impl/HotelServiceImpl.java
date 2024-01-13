package com.muez.hotel.service.Impl;

import com.muez.hotel.entities.Hotel;
import com.muez.hotel.exceptions.ResourceNotFoundException;
import com.muez.hotel.respositories.HotelRepositories;
import com.muez.hotel.service.HotelServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class HotelServiceImpl implements HotelServices {

    @Autowired
    private HotelRepositories hotelRepositories;

    @Override
    public Hotel createHotel(Hotel hotel) {
        String randomhotelId = UUID.randomUUID().toString();
        hotel.setId(randomhotelId);
        return hotelRepositories.save(hotel);
    }

    @Override
    public Hotel getById(String hotelId) {
        return hotelRepositories.findById(hotelId)
                .orElseThrow(()->new ResourceNotFoundException("hotel with this id is not found : " + hotelId));
    }

    @Override
    public List<Hotel> getAll() {
        return hotelRepositories.findAll();
    }

    @Override
    public void deleteHotel(String hotelId) {
        hotelRepositories.deleteById(hotelId);
    }

    @Override
    public Hotel updateHotel(Hotel hotel) {
        Hotel updateHotel = this.getById(hotel.getId());
        updateHotel.setName(hotel.getName());
        updateHotel.setAbout(hotel.getAbout());
        updateHotel.setLocation(hotel.getLocation());
        return updateHotel;
    }
}
