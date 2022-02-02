package com.example.challenge.service.Impl;


import com.example.challenge.service.DeviceService;
import com.example.challenge.repository.DeviceRepository;
import com.example.challenge.entity.Device;
import com.example.challenge.utils.results.DataResult;
import com.example.challenge.utils.results.Result;
import com.example.challenge.utils.results.SuccessDataResult;
import com.example.challenge.utils.results.SuccessResult;
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
        return new SuccessDataResult<List<Device>>(this.deviceDao.findAll(),"data listelendi");

    }

    @Override
    public Result add(Device device) {
        this.deviceDao.save(device);
        return new SuccessResult("ürün eklendi");
    }

    @Override
    public void saveAll(List<Device> devices) {
        deviceDao.saveAll(devices);
    }
}
