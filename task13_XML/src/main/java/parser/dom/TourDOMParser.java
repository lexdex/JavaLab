package parser.dom;


import parser.sax.Parser;
import parser.sax.TourSAXParser;
import menu.Command;
import secondmodel.Hotel;
import secondmodel.Tour;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class TourDOMParser implements Parser<List<Tour>>, Command {
  private DocumentBuilder builder;
  private Document document;

  public TourDOMParser() {
    buildDocument();
  }

  private void buildDocument() {
    try {
      builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
    } catch (ParserConfigurationException e) {
      e.printStackTrace();
    }
  }

  private void createDocument(File file) throws IOException {
    try {
      document = builder.parse(file);
      document.getDocumentElement().normalize();
    } catch (SAXException e) {
      e.printStackTrace();
    }
  }

  @Override
  public List<Tour> parse(File file) throws IOException {
    createDocument(file);
    NodeList nodeList = document.getElementsByTagName("tour");
    List<Tour> tours = new ArrayList<>();

    for (int i = 0; i < nodeList.getLength(); i++) {
      Node node = nodeList.item(i);
      if (node.getNodeType() == Node.ELEMENT_NODE) {
        Element eElement = (Element) node;
        tours.add(parseTour(eElement));
      }
    }
    return tours;
  }

  private Tour parseTour(Element eElement) {
    int id = Integer.parseInt(eElement.getAttribute("tourId"));
    String type = eElement.getElementsByTagName("type").item(0).getTextContent();
    String country = eElement.getElementsByTagName("country").item(0).getTextContent();
    int days = Integer.parseInt(eElement.getElementsByTagName("days").item(0).getTextContent());
    int nights = Integer.parseInt(eElement.getElementsByTagName("nights").item(0).getTextContent());
    String transport = eElement.getElementsByTagName("transport").item(0).getTextContent();
    int cost = Integer.parseInt(eElement.getElementsByTagName("cost").item(0).getTextContent());

    int star = Integer.parseInt(eElement.getElementsByTagName("star").item(0).getTextContent());
    int room = Integer.parseInt(eElement.getElementsByTagName("room").item(0).getTextContent());
    boolean television =
        Boolean.parseBoolean(eElement.getElementsByTagName("television").item(0).getTextContent());
    boolean wiFi =
        Boolean.parseBoolean(eElement.getElementsByTagName("wi-fi").item(0).getTextContent());
    boolean breakfast =
        Boolean.parseBoolean(eElement.getElementsByTagName("breakfast").item(0).getTextContent());
    return new Tour(
        id,
        type,
        country,
        days,
        nights,
        transport,
        new Hotel(star, room, television, wiFi, breakfast),
        cost);
  }

  public void execute() {

    try {
      Parser parser = new TourDOMParser();
      File xml = new File("src\\main\\resources\\tours.xml");
      System.out.println(parser.parse(xml));

    } catch (IOException e) {
      System.out.print("Unhandeled exeption");
    }
  }
}
