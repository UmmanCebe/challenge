package com.example.challenge.entities.concretes;

import com.sun.istack.NotNull;
import lombok.Data;
import javax.persistence.*;

@Data
@Entity
@Table(name = "devices")
public class Device {
    @Id
    @GeneratedValue
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

    public Device(){

    }

    public Device(String brand, String model, String os, String osVersion) {
        this.brand = brand;
        this.model = model;
        this.os = os;
        this.osVersion = osVersion;
    }
}
