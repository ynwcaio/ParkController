package com.api.cars.service;


import com.api.cars.repository.CarRepo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CarService {

    private final CarRepo carRepo;

    public CarService(CarRepo carRepo){
        this.carRepo = carRepo;
    }

    @Transactional(readOnly = true)

}
