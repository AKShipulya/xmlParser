package com.akshipulya.xmlParser.parser;

import com.akshipulya.xmlParser.model.Bush;
import com.akshipulya.xmlParser.model.Plant;
import com.akshipulya.xmlParser.model.Tree;
import com.sun.xml.internal.bind.v2.TODO;
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
import java.util.stream.Stream;

public class XmlFileParser implements Parser<Plant>{


    @Override
    public List<Plant> parse(String pathToFile) {
        List<Plant> plants = new ArrayList<>();

        try {
            DocumentBuilder documentBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
            Document document = documentBuilder.parse(pathToFile);

            // TODO: 10/10/21 обработать выводы сообщений на консоль
            System.out.println("List of plants:");
            System.out.println();

            List<Plant> trees = getTrees(document);
            List<Plant> bushes = getBushes(document);

            plants.addAll(trees);
            plants.addAll(bushes);

        } catch (ParserConfigurationException | SAXException | IOException ex) {
            //TODO soobjenie
            throw new RuntimeException("", ex);
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
            Plant plant = new Tree(Double.parseDouble(height),name);
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
            Plant plant = new Bush(Double.parseDouble(height),name);
            bushes.add(plant);
        }
        return bushes;
    }

    private String getAttributeValueByName(Node item, String attrName) {
        return item.getAttributes().getNamedItem(attrName).getTextContent();
    }

}
