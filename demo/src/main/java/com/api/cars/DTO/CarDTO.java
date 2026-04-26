package com.api.cars.DTO;


import com.api.cars.model.entities.Car;

import java.util.UUID;

public class CarDTO {

    private UUID id;
    private String name;
    private String model;
    private String numberplate;
    private UUID parkId;

    public CarDTO(){

    }

    public CarDTO(Car car){
        this.id = car.getId();
        this.name = car.getName();
        this.model = car.getModel();
        this.numberplate = car.getNumberplate();
        this.parkId = car.getPark().getId();
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getNumberplate() {
        return numberplate;
    }

    public void setNumberplate(String numberplate) {
        this.numberplate = numberplate;
    }

    public UUID getParkId() {
        return parkId;
    }

    public void setParkId(UUID parkId) {
        this.parkId = parkId;
    }
}
