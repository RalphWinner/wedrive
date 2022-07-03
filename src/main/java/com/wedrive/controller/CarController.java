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
    public List<Car> findAllCar()
    {
        return carService.findAllCar();
    }

    @GetMapping("/available")
    public List<Car> findAllCarAvailable()
    {
        return carService.findAllCarAvailable();
    }

    @GetMapping("/{id}")
    public Optional<Car> findByID(@PathVariable("id") Long id) {
        return carService.findByID(id);
    }

    @PostMapping("/save/{admin_id}")
    public String saveCar(@PathVariable Long admin_id
            ,@RequestPart("file") MultipartFile file, @RequestPart Car car)
    {
        Admin admin;
        try{
            admin = adminService.findAdminbyID(admin_id);
        }catch (Exception exception){
            return "Cannot save, Admin not exist -> " + exception.toString();
        }

        String fileExtension = StringUtils.getFilenameExtension(file.getOriginalFilename());

        if(!fileExtension.equals("jpg") && !fileExtension.equals("png") && !fileExtension.equals("jpeg")){
            return "File not allowed to save << ." + fileExtension + " >>";
        }

        car.setInsertBy(admin);
        car.setIs_rent(false);

        // I save my car to get the auto generatedID
        Car newCar = carService.saveCar(car);

        //File name format CarID.png

        String fileName = newCar.getCar_id()+"."+fileExtension;
        newCar.setImage1(fileName);
        carService.saveCar(newCar);
        // Copy file to the target location (Replacing existing file with the same name)
        Path uploadPath = Paths.get("Upload").toAbsolutePath().normalize();
        Path targetLocation = uploadPath.resolve(fileName);
        try {
            Files.copy(file.getInputStream(), targetLocation, StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return "Saved";
    }

    @PutMapping("/update/{admin_id}")
    public String updateCar(@RequestBody Car car, @PathVariable Long admin_id)
    {
        Admin admin;
        try{
            admin = adminService.findAdminbyID(admin_id);
        }catch (Exception exception){
            return "Cannot update, Admin not exist -> " + exception.toString();
        }

        if(!carService.isCarExist(car.getCar_id())){
            return "Cannot update, Car not exist -> " + car.getCar_id();
        }

        carService.updateCar(car);

        return "updated";
    }

    @DeleteMapping("/{id}")
    public void deleteCar(@PathVariable("id") Long id){
        carService.deleteCar(id);
    }

}
