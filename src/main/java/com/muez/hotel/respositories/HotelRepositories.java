package com.muez.hotel.respositories;

import com.muez.hotel.entities.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HotelRepositories extends JpaRepository<Hotel,String> {
}
