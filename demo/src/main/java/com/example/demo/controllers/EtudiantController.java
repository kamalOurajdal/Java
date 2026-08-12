package com.example.demo.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Repository.EtudiantRepo;
import com.example.demo.entities.Etudiant;

import lombok.AllArgsConstructor;


@RestController
@AllArgsConstructor
public class EtudiantController {

    private EtudiantRepo etudiantRepo;
    
    @GetMapping("/etudiants")
    public List<Etudiant> allEtudiant() {
        List<Etudiant> etudiants = this.etudiantRepo.findAll();
        return etudiants;
    }
    
}
