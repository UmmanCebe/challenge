package com.example.challenge.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@Table(name = "devices")
@AllArgsConstructor
@NoArgsConstructor
public class    Device {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "device_id")
    private int id;

    @NotNull
    @Column(name = "brand")
    private String brand;

    @NotNull
    @Column(name = "model")
    private String model;

    @NotNull
    @Column(name = "os")
    private String os;

    @NotNull
    @Column(name = "os_version")
    private String osVersion;

}
