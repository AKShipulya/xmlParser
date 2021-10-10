package com.akshipulya.xmlParser.model;

public class Park {

    private final int totalPlantsCount;
    private final double totalPlantHeight;

    public Park(int totalPlantsCount, double totalPlantHeight) {
        this.totalPlantsCount = totalPlantsCount;
        this.totalPlantHeight = totalPlantHeight;
    }

    public int getTotalPlantsCount() {
        return totalPlantsCount;
    }

    public double getTotalPlantHeight() {
        return totalPlantHeight;
    }

    @Override
    public String toString() {
        return "Park{" +
                "totalPlantsCount=" + totalPlantsCount +
                ", totalPlantHeight=" + totalPlantHeight +
                '}';
    }
}
