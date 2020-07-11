package com.example.demo.controller;

import com.example.demo.domain.Car;
import com.example.demo.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.File;
import java.sql.Date;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/car")
public class CarController {

  private final CarService carService;

  @Autowired
  public CarController(CarService carService) {
    this.carService = carService;
  }

  @GetMapping("/{id}")
  public ResponseEntity<Car> getCar(@PathVariable Long id) {
    Optional<Car> optionalCar = carService.getById(id);
    if (optionalCar.isPresent()) {
      return ResponseEntity.ok(optionalCar.get());
    }
    return ResponseEntity.notFound().build();
  }

  @GetMapping("/all")
  public ResponseEntity<List<Car>> getAll(
          @RequestParam Date date,
          @RequestParam(defaultValue = "0") int page,
          @RequestParam(defaultValue = "5") int size
          ) {
    Pageable pageable = PageRequest.of(page, size);
    return ResponseEntity.ok(carService.getAllPageableByDate(date, pageable));
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> deleteCar(@PathVariable Long id) {
    carService.delete(id);
    return ResponseEntity.noContent().build();
  }

  @PostMapping
  public ResponseEntity<Void> saveCars(File file) {
    carService.readFile(file);
    return ResponseEntity.status(HttpStatus.CREATED).build();
  }
}
