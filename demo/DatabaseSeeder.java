package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class DatabaseSeeder implements CommandLineRunner {
    private BookingRepository bookingRepository;

    @Autowired
    public DatabaseSeeder(BookingRepository bookingRepository){
        this.bookingRepository = bookingRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        HotelBooking Indra = new HotelBooking("Indra", 90, 3);
        HotelBooking Elvian = new HotelBooking("Elvian", 500, 2);
        HotelBooking Ahmad = new HotelBooking("Ahmad", 200, 1);

        List<HotelBooking> hotels = new ArrayList();
        hotels.add(Indra);
        hotels.add(Elvian);
        hotels.add(Ahmad);
        this.bookingRepository.saveAll(hotels);
    }
}
