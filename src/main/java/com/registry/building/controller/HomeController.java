package com.registry.building.controller;


import com.registry.building.model.Building;
import com.registry.building.repository.BuildingRepository;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@Controller
@RequestMapping("/api/buildings")
public class HomeController {

    @Autowired
    BuildingRepository repository;


    @GetMapping("/")
    @ApiOperation(value = "1.Find all buildings "+
                        "2.Find building by owner name",
                    notes = "1.Look up all buildings " +
                            "2.Provide an owner name to look up specific building",
                    response = Building.class)
    public ResponseEntity<List<Building>> getAllBuildings(@RequestParam (required = false) String owner){
        try {
            List<Building> buildingGET = new ArrayList();

            if (owner == null)
                repository.findAll().forEach(buildingGET::add);
            else
                repository.findAllByOwner(owner).forEach(buildingGET::add);

            if (buildingGET.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(buildingGET, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "Find buildings by id",
            notes = "Provide an id to look up specific building",
            response = Building.class)
    public ResponseEntity<Building> getBuildingById(@PathVariable("id") int id) {
        Optional<Building> buildingByID = repository.findById(id);

        if (buildingByID.isPresent()) {
            return new ResponseEntity<>(buildingByID.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/")
    @ApiOperation(value = "Insert new building record",
            notes = "Dont fill id cell,id generate automatically",
            response = Building.class)
    public ResponseEntity<Building> createBuilding(@RequestBody Building building) {
        try {
            Building buildingRepo = repository
                    .save(new Building(building.getAddress(),building.getOwner(),building.getSize(),building.getMarketValue(),building.getPropertyType()));
            return new ResponseEntity<>(buildingRepo, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.EXPECTATION_FAILED);
        }
    }

    @PutMapping("/{id}")
    @ApiOperation(value = "Update record by id",
                notes = "Provide to update specific/existing record by id ",
                response = Building.class)
    public ResponseEntity<Building> updateBuildingID(@PathVariable("id") int id,@RequestBody Building building) {
        Optional<Building> buildingID = repository.findById(id);
        if(buildingID.isPresent()) {
            Building buildingSET = buildingID.get();
            buildingSET.setAddress(building.getAddress());
            buildingSET.setOwner(building.getOwner());
            buildingSET.setMarketValue(building.getMarketValue());
            buildingSET.setSize(building.getSize());
            buildingSET.setPropertyType(building.getPropertyType());
            return new ResponseEntity<>(repository.save(buildingSET),HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


    @DeleteMapping("/{id}")
    @ApiOperation(value = "Delete building record by id",
                notes = "Provide to delete specific record by id",
                response = Building.class)
    public ResponseEntity<HttpStatus> deleteBuildingID(@PathVariable("id") int id) {
        try{
            repository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
        }
    }

    @DeleteMapping("/")
    @ApiOperation(value = "Delete all building ",
                    notes = "Provide delete all building list",
                    response = Building.class)
    public ResponseEntity<HttpStatus> deleteAllBuildings() {
        try{
            repository.deleteAll();
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
        }
    }

}
