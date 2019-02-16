package parser.dom;


import org.xml.sax.SAXException;
import org.w3c.dom.Document;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;

public class DOMDocumentCreator  {

    private DocumentBuilder builder;

    public DOMDocumentCreator() {
        try {
            builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        }
    }

    private Document createDocument(File xml) {
        Document document = null;
        try {
            document = builder.parse(xml);
        } catch (SAXException | IOException e) {
            e.printStackTrace();
        }
        return document;
    }

    public Document getDocument(File xml) {
        return createDocument(xml);
    }
}
