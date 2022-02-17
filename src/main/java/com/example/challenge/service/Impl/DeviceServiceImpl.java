package com.example.challenge.service.Impl;


import com.example.challenge.service.DeviceService;
import com.example.challenge.repository.DeviceRepository;
import com.example.challenge.entity.Device;
import com.example.challenge.utils.results.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.apache.commons.lang.StringUtils;


import javax.annotation.PostConstruct;
import javax.persistence.PostPersist;
import java.util.List;
import java.util.Locale;


@Service
public class DeviceServiceImpl implements DeviceService {

    private DeviceRepository deviceDao;

   /* @PostConstruct
    public void init(){
        System.out.println("umman");
    }*/

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
        if(!(device.getOs().toLowerCase().equals("android") || device.getOs().toLowerCase().equals("ios")))
            return new ErrorResult("os kısmı yalnızca android veya ios olabilir.");
        if(StringUtils.isBlank(device.getOs()) || StringUtils.isBlank(device.getModel()) || StringUtils.isBlank(device.getBrand()) || StringUtils.isBlank(device.getOsVersion()))
            return new ErrorResult("Brand,model,os,osVersion kısımları boş bırakılamaz.");
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
