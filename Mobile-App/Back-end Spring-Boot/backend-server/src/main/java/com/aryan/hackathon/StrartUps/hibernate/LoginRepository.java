package com.aryan.hackathon.StrartUps.hibernate;

import com.aryan.hackathon.StrartUps.model.FounderLogin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LoginRepository extends JpaRepository<FounderLogin,String> {

}
