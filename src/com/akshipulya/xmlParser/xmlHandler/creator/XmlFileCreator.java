package com.akshipulya.xmlParser.xmlHandler.creator;

import com.akshipulya.xmlParser.model.Park;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;

public class XmlFileCreator implements Creator {

    private static final String PATH_FOR_FILE_SAVE = "resources/park.xml";

    @Override
    public void create(Park park) {

        try {
            DocumentBuilderFactory documentFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder documentBuilder = documentFactory.newDocumentBuilder();
            Document document = documentBuilder.newDocument();

            Element root = document.createElement("Park");
            document.appendChild(root);

            Element totalPlantsCount = document.createElement("TotalPlantsCount");
            totalPlantsCount.appendChild(document.createTextNode(String.valueOf(park.getTotalPlantsCount())));
            root.appendChild(totalPlantsCount);

            Element totalPlantsHeight = document.createElement("TotalPlantsHeight");
            totalPlantsHeight.appendChild(document.createTextNode(String.valueOf(park.getTotalPlantHeight())));
            root.appendChild(totalPlantsHeight);

            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            DOMSource domSource = new DOMSource(document);
            StreamResult streamResult = new StreamResult(new File(PATH_FOR_FILE_SAVE));

            transformer.transform(domSource, streamResult);

            System.out.println("XML file was created!");

        } catch (ParserConfigurationException | TransformerException e) {
            throw new RuntimeException("XML creator error, please check provided data", e);
        }
    }
}
