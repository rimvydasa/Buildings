package com.registry.building.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;

@Entity (name = "building")
//@SequenceGenerator(name="id",sequenceName = "id",allocationSize=1 )
@ApiModel(description="All details about the buildings. ")
public class Building {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // generator = "id
    private int id;
    @Column(nullable = false)
    @ApiModelProperty(notes="Address need have name and street number")
    private String address;
    @Column(nullable = false)
    private String owner;
    @Column(nullable = false)
    @ApiModelProperty(notes="Size need to be positive numbers")
    private long size;
    @Column(nullable = false)
    @ApiModelProperty(notes="MarketValue need to be positive numbers")
    private long marketValue;
    @Column(nullable = false)
    @ApiModelProperty(notes="PropertyType need to be apartment, house, industrial")
    private String propertyType;


    public Building() {
    }
    public Building(String address,String owner,long size,long marketValue,String propertyType) {
        this.address = address;
        this.owner = owner;
        this.size = size;
        this.marketValue = marketValue;
        this.propertyType = propertyType;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public long getSize() {
        return size;
    }

    public void setSize(long size) {
        this.size = size;
    }

    public long getMarketValue() {
        return marketValue;
    }

    public void setMarketValue(long marketValue) {
        this.marketValue = marketValue;
    }

    public String getPropertyType() {
        return propertyType;
    }

    public void setPropertyType(String propertyType) {
        this.propertyType = propertyType;
    }

    @Override
    public String toString() {
        return "Building{" +
                "id=" + id +
                ", address='" + address + '\'' +
                ", Owner='" + owner + '\'' +
                ", size=" + size +
                ", marketValue=" + marketValue +
                ", propertyType='" + propertyType + '\'' +
                '}';
    }
}
