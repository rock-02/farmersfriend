package com.example.backendSocial.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.backendSocial.Entity.FeedBack;

@Repository
public interface FeedbackRepository extends JpaRepository<FeedBack, Long>{
    
    
}
