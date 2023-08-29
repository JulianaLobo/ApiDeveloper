package com.iftm.ApiDeveloper.models;

import java.util.Objects;

public class Sector {
    private String name;
    private int floor;

    public Sector() {
    }

    public Sector(String name, int floor) {
        this.name = name;
        this.floor = floor;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getFloor() {
        return floor;
    }

    public void setFloor(int floor) {
        this.floor = floor;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Sector sector)) return false;
        return getFloor() == sector.getFloor() && Objects.equals(getName(), sector.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getFloor());
    }

    @Override
    public String toString() {
        return "Sector{" +
                "name='" + name + '\'' +
                ", floor=" + floor +
                '}';
    }
}
