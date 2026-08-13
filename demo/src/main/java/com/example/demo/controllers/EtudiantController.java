package com.example.demo.controllers;

import java.util.List;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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

    @GetMapping("")
    public String indString() {
        return "hello world";
    }

    @GetMapping("/users/{id}")
    @PreAuthorize("hasRole('USER')")
    @PostAuthorize("returnObject == #id")
    public Long usersIndex(@PathVariable Long id) {
        return 2L;
    }

    @GetMapping("/admin/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    @PostAuthorize("returnObject.id == #id")
    public Long adminIndex(@PathVariable Long id) {
        return 2L;
    }
    
    
}
