package com.example.backendSocial.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class FeedBack {

    @Id
    @SequenceGenerator(name = "feedback_sequnce", sequenceName = "feedback_sequnce", allocationSize = 1)
    @GeneratedValue(generator = "feedback_sequnce")
    private Long id;

    private String name;

    private String email;

    private String message;

    private String subject;

    @ManyToOne
    private User user;

}
