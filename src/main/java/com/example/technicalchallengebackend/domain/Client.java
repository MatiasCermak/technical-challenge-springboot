package com.example.technicalchallengebackend.domain;

import io.swagger.v3.oas.annotations.Hidden;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Entity
@Table(name="client")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Hidden
    private Integer ID;
    private String firstName;
    private String lastName;
    private Integer age;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date birthDate;
}
