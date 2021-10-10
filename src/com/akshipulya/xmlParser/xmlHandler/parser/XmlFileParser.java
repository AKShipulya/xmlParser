package com.akshipulya.xmlParser.xmlHandler.parser;

import com.akshipulya.xmlParser.model.Bush;
import com.akshipulya.xmlParser.model.Plant;
import com.akshipulya.xmlParser.model.Tree;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class XmlFileParser implements Parser<Plant> {

    @Override
    public List<Plant> parse(String pathToFile) {

        List<Plant> plants = new ArrayList<>();

        try {
            DocumentBuilder documentBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
            Document document = documentBuilder.parse(pathToFile);

            List<Plant> trees = getTrees(document);
            List<Plant> bushes = getBushes(document);

            plants.addAll(trees);
            plants.addAll(bushes);

        } catch (ParserConfigurationException | SAXException | IOException e) {
            throw new RuntimeException("XML parser error, please check provided file or/and data", e);
        }

        return plants;

    }

    private List<Plant> getTrees(Document document) {
        List<Plant> trees = new ArrayList<>();
        NodeList treesNodes = document.getElementsByTagName("Tree");
        for (int i = 0; i < treesNodes.getLength(); i++) {
            Node item = treesNodes.item(i);
            String name = getAttributeValueByName(item, "name");
            String height = getAttributeValueByName(item, "height");
            Plant plant = new Tree(Double.parseDouble(height), name);
            trees.add(plant);
        }
        return trees;
    }

    private List<Plant> getBushes(Document document) {
        List<Plant> bushes = new ArrayList<>();
        NodeList treesNodes = document.getElementsByTagName("Bush");
        for (int i = 0; i < treesNodes.getLength(); i++) {
            Node item = treesNodes.item(i);
            String name = getAttributeValueByName(item, "name");
            String height = getAttributeValueByName(item, "height");
            Plant plant = new Bush(Double.parseDouble(height), name);
            bushes.add(plant);
        }
        return bushes;
    }

    private String getAttributeValueByName(Node item, String attrName) {
        return item.getAttributes().getNamedItem(attrName).getTextContent();
    }

}
