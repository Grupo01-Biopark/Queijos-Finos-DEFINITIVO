package com.example.demo.repository;



import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Producer;

import java.util.List;
import java.util.Map;

public interface ProducerRepository extends JpaRepository<Producer, Long>{


}
