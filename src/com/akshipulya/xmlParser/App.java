package com.akshipulya.xmlParser;

import com.akshipulya.xmlParser.creater.XmlFileCreator;
import com.akshipulya.xmlParser.model.Plant;
import com.akshipulya.xmlParser.parser.XmlFileParser;
import com.akshipulya.xmlParser.parser.Parser;
import com.akshipulya.xmlParser.util.PlantsUtil;

import java.util.List;

public class App {

    public static void main(String[] args) {
        Parser<Plant> parser = new XmlFileParser();
        List<Plant> plants = parser.parse("resources/plants.xml");
        PlantsUtil plantsUtil = new PlantsUtil();
        XmlFileCreator xmlFileCreator = new XmlFileCreator();
        xmlFileCreator.create(plantsUtil.createPark(plants));
    }

}
