package com.italika.italikasystem.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.italika.italikasystem.models.Client;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long>{

}
