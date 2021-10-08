package com.akshipulya.xmlParser;

import com.akshipulya.xmlParser.model.Plant;
import com.akshipulya.xmlParser.parser.DomParser;
import com.akshipulya.xmlParser.parser.Parser;

public class App {

    public static void main(String[] args) {
        Parser<Plant> parser = new DomParser();
        parser.parse("resources/plants.xml");
    }

}
