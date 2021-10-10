package com.akshipulya.xmlParser;

import com.akshipulya.xmlParser.xmlHandler.creator.XmlFileCreator;
import com.akshipulya.xmlParser.model.Plant;
import com.akshipulya.xmlParser.xmlHandler.parser.XmlFileParser;
import com.akshipulya.xmlParser.xmlHandler.parser.Parser;
import com.akshipulya.xmlParser.util.PlantsUtil;

import java.util.List;

public class App {

    private static final String PATH_TO_XML_FILE = "resources/plants.xml";

    public static void main(String[] args) {
        Parser<Plant> parser = new XmlFileParser();
        List<Plant> plants = parser.parse(PATH_TO_XML_FILE);

        System.out.println("List of plants from XML file:");
        System.out.println(plants);

        PlantsUtil plantsUtil = new PlantsUtil();

        System.out.println(plantsUtil.createPark(plants));

        XmlFileCreator xmlFileCreator = new XmlFileCreator();
        xmlFileCreator.create(plantsUtil.createPark(plants));
    }

}
