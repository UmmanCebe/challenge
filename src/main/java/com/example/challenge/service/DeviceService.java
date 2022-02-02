package com.example.challenge.service;

import com.example.challenge.entity.Device;
import com.example.challenge.utils.results.DataResult;
import com.example.challenge.utils.results.Result;

import java.util.List;

public interface DeviceService {
    DataResult<List<Device>> getAll();
    Result add(Device device);
    void saveAll(List<Device> devices);
}
