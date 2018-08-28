package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
//@RequestMapping(value = "/bookings")
public class BookingController {
    private BookingRepository bookingRepository;

    @Autowired
    public BookingController(BookingRepository bookingRepository) {
        this.bookingRepository = bookingRepository;
    }

    @GetMapping("/hello")
    public String hello() {
        return "Hello, world";
    }

    @GetMapping("/hotels")
    public List<HotelBooking> getAll() {
        List<HotelBooking> hotels = this.bookingRepository.findAll();
        return this.bookingRepository.findAll();
    }

    @RequestMapping(value = "/affordable/{price}", method = RequestMethod.GET)
    public List<HotelBooking> getAffordable(@PathVariable double price) {
        //return bookings.stream().filter(x -> x.getPricePerNight() <= price).collect(Collectors.toList());
        return bookingRepository.findByPricePerNightLessThan(price);
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public List<HotelBooking> create(@RequestBody HotelBooking hotelBooking) {
        bookingRepository.save(hotelBooking);
        return bookingRepository.findAll();
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public List<HotelBooking> remove(@PathVariable long id){
        bookingRepository.deleteById(id);
        return bookingRepository.findAll();
    }
}
