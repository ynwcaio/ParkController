package com.api.cars.DTO;


import com.api.cars.model.entities.Car;
import com.api.cars.model.entities.Park;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

public class ParkDTO {

    private UUID id;
    private LocalDate date;
    private BigDecimal price;
    private List<Car> cars;


    public ParkDTO(){

    }

    public ParkDTO(Park park){
        this.id = park.getId();
        this.date = park.getDate();
        this.price = park.getPrice();
        this.cars = park.getCar();
    }

    public UUID getId() {
        return id;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public List<Car> getCars() {
        return cars;
    }

    public void setCars(List<Car> cars) {
        this.cars = cars;
    }
}
