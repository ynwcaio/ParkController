package com.api.cars.service;


import com.api.cars.DTO.CarDTO;
import com.api.cars.exceptions.ResourceNotFound;
import com.api.cars.model.entities.Car;
import com.api.cars.model.entities.Park;
import com.api.cars.repository.CarRepository;
import com.api.cars.repository.ParkRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
public class CarService {

    private final CarRepository carRepository;
    private final ParkRepository parkRepository;

    public CarService(CarRepository carRepository, ParkRepository parkRepository){
        this.carRepository = carRepository;
        this.parkRepository = parkRepository;
    }

    @Transactional(readOnly = true)
    public List<CarDTO> findAll(){
        List<Car> car = carRepository.findAll();
        return car.stream().map(CarDTO :: new).toList();
    }

    @Transactional(readOnly = true)
    public CarDTO findById(UUID id){
        Car car = carRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFound("Car not found!"));
        return new CarDTO(car);
    }

    @Transactional
    public CarDTO insertCar(CarDTO dto){
        Car car = new Car();

        car.setName(dto.getName());
        car.setModel(dto.getModel());
        car.setNumberplate(dto.getNumberplate());
        Park park = parkRepository.findById(dto.getParkId())
                .orElseThrow(() -> new ResourceNotFound("Park not found!"));
        car.setPark(park);
        car = carRepository.save(car);

        return new CarDTO(car);
    }

    @Transactional
    public CarDTO updateCar(UUID id, CarDTO dto){
        Car car = carRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFound("Car not found!"));
        car.setName(dto.getName());
        car.setModel(dto.getModel());
        car.setNumberplate(dto.getNumberplate());
        if (!car.getPark().getId().equals(dto.getParkId())) {
            Park park = parkRepository.findById(dto.getParkId())
                    .orElseThrow(() -> new ResourceNotFound("Park not found!"));
            car.setPark(park);
        }

        carRepository.save(car);

        return new CarDTO(car);
    }


    @Transactional
    public void deleteById(UUID id){
        carRepository.deleteById(id);
    }
}
