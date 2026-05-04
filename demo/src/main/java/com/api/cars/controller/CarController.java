package com.api.cars.controller;


import com.api.cars.DTO.CarDTO;
import com.api.cars.service.CarService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/v1/cars")
public class CarController {

    private final CarService carService;

    public CarController(CarService carService){
        this.carService = carService;
    }

    @GetMapping
    public List<CarDTO> findAll(){
        return carService.findAll();
    }

    @GetMapping("v1/{id}")
    public ResponseEntity<CarDTO> findById(@PathVariable UUID id){
        return ResponseEntity.ok(carService.findById(id));
    }

    @PostMapping
    public ResponseEntity<CarDTO> insert(@RequestBody CarDTO dto){
        CarDTO carDTO = carService.insertCar(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(carDTO);
    }

    @PutMapping("v1/{id}")
    public ResponseEntity<CarDTO> updateCar(@PathVariable UUID id, @RequestBody CarDTO dto){
        return ResponseEntity.ok(carService.updateCar(id, dto));
    }

    @DeleteMapping("v1/{id}")
    public ResponseEntity<Void> delete(@PathVariable UUID id){
        carService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

}
