package com.example.demo.service;

import com.example.demo.domain.Car;
import com.example.demo.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

@Service
public class CarService {

  private final CarRepository carRepository;

  @Autowired
  public CarService(CarRepository carRepository) {
    this.carRepository = carRepository;
  }

  public Optional<Car> getById(Long id) {
    return Optional.ofNullable(carRepository.getOne(id));
  }

  public List<Car> getAllPageableByDate(Date date, Pageable pageable) {
    return carRepository.findAllByDate(date, pageable);
  }

  public void delete(Long id) {
    carRepository.deleteById(id);
  }

  public Car save(Car car) {
    return carRepository.save(car);
  }

  public void readFile(File file) {
    List<Car> cars = new ArrayList<>();
    try {
      Scanner reader = new Scanner(file);
      reader.nextLine();
      while (reader.hasNextLine()) {
        String line = reader.nextLine();
        String [] data = line.split(",");
        Car car = new Car(checkId(data[0]), data[1], data[2], checkDate(data[3]));
        cars.add(car);
      }
      cars.forEach(car -> save(car));
    }
    catch (IOException e) {
      e.printStackTrace();
    }
  }

  private static Long checkId(String s) {
    return Long.parseLong(s);
  }

  private static Date checkDate(String s) {
    return Date.valueOf(s);
  }
}
