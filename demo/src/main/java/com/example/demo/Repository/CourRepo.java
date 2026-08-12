package com.example.demo.Repository;

import org.springframework.data.repository.Repository;

import com.example.demo.entities.Cour;


public interface CourRepo extends Repository<Cour, Long>  {

    public Cour save(Cour c);
    public Cour findById(Long id);

}
