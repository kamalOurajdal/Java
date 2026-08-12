package com.example.demo.Repository;

import java.util.List;

import org.springframework.data.repository.Repository;

import com.example.demo.entities.Etudiant;


public interface EtudiantRepo extends Repository<Etudiant, Long> {

    public Etudiant save(Etudiant e);
    public Etudiant findById(Long id);
    public List<Etudiant> findAll();
    
}
