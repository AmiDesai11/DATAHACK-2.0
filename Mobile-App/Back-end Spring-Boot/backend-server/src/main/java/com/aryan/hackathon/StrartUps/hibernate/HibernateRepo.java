package com.aryan.hackathon.StrartUps.hibernate;

import com.aryan.hackathon.StrartUps.model.Founder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HibernateRepo extends JpaRepository<Founder,String> {
}
