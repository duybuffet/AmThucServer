/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.amthuc.utils;

import com.amthuc.model.Table;
import java.util.List;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 *
 * @author Pia
 */
public class Helper {

    public static List<Table> loadTables(String fileName) throws ParserConfigurationException,
            SAXException, IOException {
        List<Table> lst = new ArrayList<>();

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();

        // Load the input XML document, parse it and return an instance of the
        // Document class.
        Document document = builder.parse(new File(fileName));

        NodeList nodeList = document.getDocumentElement().getChildNodes();
        
        for (int i = 0; i < nodeList.getLength(); i++) {
            Node node = nodeList.item(i);

            if (node.getNodeType() == Node.ELEMENT_NODE) {
                Element elem = (Element) node;
                
                // Get the value of the ID attribute.
                Integer ID = Integer.parseInt(node.getAttributes().getNamedItem("ID").getNodeValue());
                // Get the value of all sub-elements.
                String name = elem.getElementsByTagName("Name")
                        .item(0).getChildNodes().item(0).getNodeValue();

                Integer floor = Integer.parseInt(elem.getElementsByTagName("Floor")
                        .item(0).getChildNodes().item(0).getNodeValue());
                
                Integer type = Integer.parseInt(elem.getElementsByTagName("Type")
                        .item(0).getChildNodes().item(0).getNodeValue());

                

                lst.add(new Table(ID, name, floor, type));
            }
        }

        return lst;
    }        
}
