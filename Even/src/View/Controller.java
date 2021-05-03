package View;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import com.sun.glass.ui.CommonDialogs;
import javafx.stage.FileChooser;
/*import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.swing.text.html.parser.Element;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.*;
import java.util.ArrayList;*/

public class Controller {
    ArrayList<Attribute> xmlData;

    public class Attribute {
        private String name;
        private String describe;
        private String type;

        public Attribute(String name, String describe, String type) {
            this.name = name;
            this.describe = describe;
            this.type = type;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getDescribe() {
            return describe;
        }

        public void setDescribe(String describe) {
            this.describe = describe;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }
    }

    public void openXml() {
        FileChooser fc = new FileChooser();
        fc.setTitle("Choose file");
        fc.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("xml files", "*.xml"));
        // fc.showOpenDialog(null);
        File chosen = fc.showOpenDialog(null);
        if (chosen != null) {
            System.out.println(chosen.getName());
        }
        try {
            //an instance of factory that gives a document builder
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            //an instance of builder to parse the specified xml file
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document doc = db.parse(chosen);
           // doc.getDocumentElement().normalize();
            System.out.println("Root element: " + doc.getDocumentElement().getNodeName());
            NodeList nodeList = doc.getElementsByTagName("chunk");
            // nodeList is not iterable, so we are using for loop
            for (int itr = 0; itr < nodeList.getLength(); itr++) {
                Node node = nodeList.item(itr);
                System.out.println("\nNode Name :" + node.getNodeName());
                if (node.getNodeType() == Node.ELEMENT_NODE) {
                   Element eElement = (Element) node;
                    //System.out.println("Atr name: "+ eElement.getElementsByTagName("Name").item(0).getTextContent());
                    System.out.println("Atr name: "+ eElement.getElementsByTagName("Name").item(itr).getTextContent());
                    //System.out.println("Name: " + node.getNodeName());

                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        /*try {
            xmlData = new ArrayList<>();
            BufferedReader bf = new BufferedReader(new FileReader(chosen));
            Element eElement = (Element) node;
            System.out.println("Student id: "+ eElement.getElementsByTagName("id").item(0).getTextContent());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }*/
    }
}

