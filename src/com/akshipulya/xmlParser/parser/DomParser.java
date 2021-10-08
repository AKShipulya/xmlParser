package com.akshipulya.xmlParser.parser;

import com.akshipulya.xmlParser.model.Plant;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

public class DomParser implements Parser<Plant>{

    @Override
    public void parse(String pathToFile) {
        try {
            DocumentBuilder documentBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
            Document document = documentBuilder.parse(pathToFile);

            Node root = document.getDocumentElement();

            System.out.println("List of plants:");
            System.out.println();
            NodeList plants = root.getChildNodes();
            for (int i = 0; i < plants.getLength(); i++) {
                Node plant = plants.item(i);
                if (plant.getNodeType() != Node.TEXT_NODE) {
                    NodeList plantProps = plant.getChildNodes();
                    for(int j = 0; j < plantProps.getLength(); j++) {
                        Node plantProp = plantProps.item(j);
                        if (plantProp.getNodeType() != Node.TEXT_NODE) {
                            System.out.println(plantProp.getNodeName() + ":"
                                    + plantProp.getChildNodes().item(0).getTextContent()
                                    + plantProp.getTextContent()
                            );
                        }
                    }
                    System.out.println("===========>>>>");
                }
            }

        } catch (ParserConfigurationException | SAXException | IOException ex) {
            ex.printStackTrace(System.out);
        }
    }

}
