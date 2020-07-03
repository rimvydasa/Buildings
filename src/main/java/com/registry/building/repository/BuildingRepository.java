package com.registry.building.repository;

import com.registry.building.model.Building;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BuildingRepository extends JpaRepository<Building, Integer> {

    List<Building> findAllByOwner(String owner);

}
