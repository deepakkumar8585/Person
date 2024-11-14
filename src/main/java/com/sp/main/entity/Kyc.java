package com.sp.main.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "kyc")
public class Kyc {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "pan_number", nullable = false)
    private String panNumber;

    @Column(name = "mobile", nullable = false)
    private String mobile;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

}