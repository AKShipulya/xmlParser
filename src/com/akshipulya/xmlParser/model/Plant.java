package com.akshipulya.xmlParser.model;

public class Plant {

    private double height;

    public Plant(double height) {
        this.height = height;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Plant plant = (Plant) o;

        return Double.compare(plant.height, height) == 0;
    }

    @Override
    public int hashCode() {
        long temp = Double.doubleToLongBits(height);
        return (int) (temp ^ (temp >>> 32));
    }

    @Override
    public String toString() {
        return "Plant{" +
                "height=" + height +
                '}';
    }
}
