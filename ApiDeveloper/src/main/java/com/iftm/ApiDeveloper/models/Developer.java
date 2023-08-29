package com.iftm.ApiDeveloper.models;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.io.Serializable;
import java.util.Objects;

@Document(collection = "developers")
public class Developer implements Serializable {

    @Id //@MongoId ou @MongoId(targetType = FieldType.OBJECT_ID) ou @BsonId
    private ObjectId id;
    @Field("name")
    private String name;
    private String lastName;
    private String level;
    private String specialization;
    private Sector sector;
    private Address address;

    public Developer() {
    }

    public Developer(String name, String lastName, String level, String specialization, Sector sector, Address address) {
        this.name = name;
        this.lastName = lastName;
        this.level = level;
        this.specialization = specialization;
        this.sector = sector;
        this.address = address;
    }

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastname) {
        this.lastName = lastname;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    public Sector getSector() {
        return sector;
    }

    public void setSector(Sector sector) {
        this.sector = sector;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Developer developer)) return false;
        return Objects.equals(getId(), developer.getId()) && Objects.equals(getName(), developer.getName()) && Objects.equals(getLastName(), developer.getLastName()) && Objects.equals(getLevel(), developer.getLevel()) && Objects.equals(getSpecialization(), developer.getSpecialization()) && Objects.equals(getSector(), developer.getSector()) && Objects.equals(getAddress(), developer.getAddress());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName(), getLastName(), getLevel(), getSpecialization(), getSector(), getAddress());
    }

    @Override
    public String toString() {
        return "Developer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", lastname='" + lastName + '\'' +
                ", level='" + level + '\'' +
                ", specialization='" + specialization + '\'' +
                ", sector=" + sector +
                ", address=" + address +
                '}';
    }
}
