package com.example.demo.Repository;

import org.springframework.data.repository.Repository;

import com.example.demo.entities.Inscription;


public interface InscriptionRepo extends Repository<Inscription, Long> {

    public Inscription save(Inscription i);
    public Inscription findById(Long id);
    
}
