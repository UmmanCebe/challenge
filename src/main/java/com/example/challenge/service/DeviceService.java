package com.example.challenge.service;

import com.example.challenge.entity.Device;
import com.example.challenge.utils.results.DataResult;
import com.example.challenge.utils.results.Result;
import com.example.challenge.utils.results.SuccessDataResult;

import java.util.List;

public interface DeviceService {
    DataResult<List<Device>> getAll();
    Result add(Device device);

    //void saveAll(List<Device> devices);  burası çalışıyor açarsın unutma

    DataResult<List<Device>> getByBrandAndOsVersion(String brand, String osVersion);
}
