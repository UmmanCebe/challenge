package com.example.challenge.repository;

import com.example.challenge.entity.Device;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface DeviceRepository extends JpaRepository<Device,Integer> {

   List <Device> getByBrandAndOsVersion(String brand, String osVersion);

   Boolean existsByBrandAndOsVersion(String brand, String osVersion);

   Boolean existsByBrandAndModelAndOsVersion(String brand,String model, String osVersion);

   // @Query("From Device where brand=:brand and model=:model and osVersion=:osVersion")
   // List<Device> getByBrandAndModelAndOsAndOsVersion(String brand,String model,String osVersion);

}
