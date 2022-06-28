package com.wedrive.controller;

import com.wedrive.model.Admin;
import com.wedrive.model.Car;
import com.wedrive.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import com.wedrive.service.CarService;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/car")
public class CarController {
    private final CarService carService;
    private final AdminService adminService;

    @Autowired
    public CarController(CarService carService, AdminService adminService) {
        this.carService = carService;
        this.adminService = adminService;
    }

    @GetMapping
    public List<Car> findAllCar(){
        return carService.findAllCar();
    }

    @GetMapping("/{id}")
    public Optional<Car> findByID(@PathVariable("id") Long id) {
        return carService.findByID(id);
    }

    @PostMapping("/save/{admin_id}")
    public String saveCar(@PathVariable Long admin_id
            ,@RequestPart("file") MultipartFile file, @RequestPart Car car)
    {
        Admin admin = adminService.findAdminbyID(admin_id);
        car.setInsertBy(admin);
        String fileName = StringUtils.cleanPath(file.getOriginalFilename());
         Path uploadPath = Paths.get("Upload").toAbsolutePath().normalize();

         Car new_car = carService.saveCar(car);
        // Copy file to the target location (Replacing existing file with the same name)
        Path targetLocation = uploadPath.resolve( new_car.getCar_id() + "_" + fileName);
        try {
            Files.copy(file.getInputStream(), targetLocation, StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return "Done";
    }

    @PutMapping
    public void updateCar(@RequestBody Car car) {
        carService.updateCar(car);
    }

    @DeleteMapping("/{id}")
    public void deleteCar(@PathVariable("id") Long id){
        carService.deleteCar(id);
    }

}
