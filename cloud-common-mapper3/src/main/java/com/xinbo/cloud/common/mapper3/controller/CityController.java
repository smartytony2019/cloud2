package com.xinbo.cloud.common.mapper3.controller;

import com.xinbo.cloud.common.mapper3.model.City;
import com.xinbo.cloud.common.mapper3.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("cities")
public class CityController {

    @Autowired
    private CityService cityService;

    @GetMapping("/list")
    public List<City> tolist() {
        List<City> cities = cityService.getAll();
        return cities;
    }

}
