package com.example.demo;

import java.sql.Date;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.Repository.CourRepo;
import com.example.demo.Repository.EtudiantRepo;
import com.example.demo.Repository.InscriptionRepo;
import com.example.demo.entities.Cour;
import com.example.demo.entities.Etudiant;
import com.example.demo.entities.Inscription;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner {

	final CourRepo courRepo;
	final EtudiantRepo etudiantRepo;
	final InscriptionRepo inscriptionRepo;


	DemoApplication(CourRepo courRepo, EtudiantRepo etudiantRepo, InscriptionRepo inscriptionRepo) {
		this.courRepo = courRepo;
		this.etudiantRepo = etudiantRepo;
		this.inscriptionRepo = inscriptionRepo;
	}
	

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Etudiant e1 = etudiantRepo.save(new Etudiant(null, "kamal", null));
		Etudiant e2 = etudiantRepo.save(new Etudiant(null, "jamal", null));

		Cour c1 = courRepo.save(new Cour(null, "Math", 2, null));
		Cour c2 = courRepo.save(new Cour(null, "English", 4, null));

		inscriptionRepo.save(new Inscription(null, new Date(System.currentTimeMillis()), 95.0, e1, c1));
		inscriptionRepo.save(new Inscription(null, new Date(System.currentTimeMillis()), 88.0, e2, c2));


	}

}
