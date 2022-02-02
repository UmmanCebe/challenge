package com.example.challenge.repository;

import com.example.challenge.entity.Device;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DeviceRepository extends JpaRepository<Device,Integer> {
}
