package com.xinbo.cloud.common.mapper3.service;

import com.xinbo.cloud.common.mapper3.mapper.CityMapper;
import com.xinbo.cloud.common.mapper3.model.City;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CityService  {

    @Autowired
    private CityMapper cityMapper;

    public List<City> getAll() {
        return cityMapper.selectAll();
    }

}
