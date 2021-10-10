package com.akshipulya.xmlParser.model;

public abstract class Plant {

    private final double height;
    private final String name;

    public Plant(double height, String name) {
        this.height = height;
        this.name = name;
    }

    public double getHeight() {
        return height;
    }

    public String getName() {
        return name;
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

}
