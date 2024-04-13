package com.italika.italikasystem.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.italika.italikasystem.models.Motorcicle;

@Repository
public interface MotorcicleRepository extends JpaRepository<Motorcicle, Long>{
    
}
