package com.aryan.hackathon.StrartUps.controller;

import com.aryan.hackathon.StrartUps.hibernate.HibernateRepo;
import com.aryan.hackathon.StrartUps.hibernate.LoginRepository;
import com.aryan.hackathon.StrartUps.model.Founder;
import com.aryan.hackathon.StrartUps.model.FounderLogin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1")
public class FounderController {

    @Autowired
    HibernateRepo hibernate;

    @Autowired
    LoginRepository loginRepository;

    @PostMapping("/save-founder")
    public ResponseEntity<?> saveFounder(@RequestBody Founder founder){
        System.out.println(founder.toString());
        Optional<Founder> exists = hibernate.findById(founder.getEmail());
        if (exists.isPresent()){
            return new ResponseEntity<>("user already exists with that email", HttpStatus.NOT_FOUND);
        }
        else{
            Founder f = hibernate.save(founder);
            return new ResponseEntity<>(f, HttpStatus.OK);
        }
    }

    @PostMapping("/login")
    public ResponseEntity<?> loginFounder(@RequestBody FounderLogin login){
        System.out.println(login.toString());
        Optional<Founder> exists = hibernate.findById(login.getEmail());
        if (exists.isPresent()){
            FounderLogin l = loginRepository.save(login);
            if (l.getPassword().equals(login.getPassword())){
                return new ResponseEntity<>(l, HttpStatus.OK);
            }
            else{
                return new ResponseEntity<>("password not matched",HttpStatus.NOT_FOUND);
            }
        }
        else{
            return new ResponseEntity<>("not found", HttpStatus.NOT_FOUND);
        }
    }
}
