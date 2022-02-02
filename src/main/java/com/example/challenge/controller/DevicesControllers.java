package com.example.challenge.controller;


import com.example.challenge.service.DeviceService;
import com.example.challenge.entity.Device;
import com.example.challenge.utils.results.DataResult;
import com.example.challenge.utils.results.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/devices")
public class DevicesControllers {

    private DeviceService deviceService;

    @Autowired
    public DevicesControllers(DeviceService deviceService){
        this.deviceService = deviceService;
    }

    @GetMapping("/getall")
    public DataResult<List<Device>> getAll(){
        return this.deviceService.getAll();
    }

    @PostMapping("/add")
    public Result add(@RequestBody Device device) {
        return this.deviceService.add(device);
    }
}
