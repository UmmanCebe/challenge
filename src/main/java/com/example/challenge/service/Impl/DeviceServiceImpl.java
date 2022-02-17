package com.example.challenge.service.Impl;


import com.example.challenge.service.DeviceService;
import com.example.challenge.repository.DeviceRepository;
import com.example.challenge.entity.Device;
import com.example.challenge.utils.results.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class DeviceServiceImpl implements DeviceService {

    private DeviceRepository deviceDao;

    @Autowired
    public DeviceServiceImpl(DeviceRepository deviceDao){
        this.deviceDao = deviceDao;
    }


    @Override
    public DataResult<List<Device>> getAll() {
        return new SuccessDataResult<List<Device>>(this.deviceDao.findAll(),"Cihazlar Listelendi");

    }

    @Override
    public Result add(Device device) {
        Boolean checkDevices = deviceDao.existsByBrandAndModelAndOsVersion(device.getBrand(), device.getModel(), device.getOsVersion());
        if (checkDevices)
            return new ErrorResult("Var olan cihaz eklenemez");
        else
            this.deviceDao.save(device);
            return new SuccessResult("Cihaz Eklendi");
    }

    @Override
    public DataResult<List<Device>> getByBrandAndOsVersion(String brand, String osVersion) {
        Boolean checkRecords = deviceDao.existsByBrandAndOsVersion(brand, osVersion);
        if(checkRecords)
            return new SuccessDataResult<List<Device>>(this.deviceDao.getByBrandAndOsVersion(brand,osVersion),"İstenilen Cihazlar");
        else
            return getAll();
    }

   /* @Override
    public void saveAll(List<Device> devices) {
        deviceDao.saveAll(devices);
    }*/
}
