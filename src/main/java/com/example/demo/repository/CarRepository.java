package com.example.demo.repository;

import com.example.demo.domain.Car;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.util.List;

@Repository
public interface CarRepository extends JpaRepository<Car, Long> {

  List<Car> findAllByDate(Date date, Pageable pageable);
}
