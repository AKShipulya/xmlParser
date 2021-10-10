package com.akshipulya.xmlParser.util;

import com.akshipulya.xmlParser.model.Park;
import com.akshipulya.xmlParser.model.Plant;

import java.util.List;

public class PlantsUtil {

    private int getPlantsCount(List<Plant> plants) {
        return plants.size();
    }

    private double getTotalPlantsHeight(List<Plant> plants) {
        return plants.stream()
                .mapToDouble(Plant::getHeight)
                .sum();
    }

    public Park createPark(List<Plant> plants) {
        int plantsCount = getPlantsCount(plants);
        double plantsTotalHeight = getTotalPlantsHeight(plants);
        return new Park(plantsCount, plantsTotalHeight);
    }

}
