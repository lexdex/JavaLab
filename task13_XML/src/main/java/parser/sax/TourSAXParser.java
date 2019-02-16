package parser.sax;

import secondmodel.Hotel;
import secondmodel.Tour;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.XMLConstants;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import javax.xml.validation.SchemaFactory;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import menu.Command;

public class TourSAXParser implements Parser<List<Tour>>, Command {

  private SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();

  public TourSAXParser() {
    createSchema();
  }

  private void createSchema() {
    try {
      String language = XMLConstants.W3C_XML_SCHEMA_NS_URI;
      SchemaFactory factory = SchemaFactory.newInstance(language);
      saxParserFactory.setSchema(factory.newSchema());
    } catch (SAXException ex) {
      ex.printStackTrace();
    }
  }

  @Override
  public List<Tour> parse(File xml) throws IOException {
    List<Tour> deviceList = new ArrayList<>();
    try {
      SAXParser saxParser = saxParserFactory.newSAXParser();
      XMLHandler saxHandler = new XMLHandler();
      saxParser.parse(xml, saxHandler);

      deviceList = saxHandler.getTourList();
    } catch (SAXException | ParserConfigurationException ex) {
      ex.printStackTrace();
    }

    return deviceList;
  }

  private static class XMLHandler extends DefaultHandler {
    private Tour tour;
    private Hotel hotel;
    private List<Tour> tours = new ArrayList<>();
    private boolean bType;
    private boolean bCountry;
    private boolean bDays;
    private boolean bNights;
    private boolean bTransport;
    private boolean bStar;
    private boolean bRoom;
    private boolean bTelevision;
    private boolean bWiFi;
    private boolean bBreakfast;
    private boolean bCost;

    public List<Tour> getTourList() {
      return tours;
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes)
        throws SAXException {
      if (qName.equalsIgnoreCase("tour")) {
        int tourId = Integer.parseInt(attributes.getValue("tourId"));
        tour = new Tour();
        hotel = new Hotel();
        tour.setTourId(tourId);
      } else if (qName.equalsIgnoreCase("type")) {
        bType = true;
      } else if (qName.equalsIgnoreCase("country")) {
        bCountry = true;
      } else if (qName.equalsIgnoreCase("days")) {
        bDays = true;
      } else if (qName.equalsIgnoreCase("nights")) {
        bNights = true;
      } else if (qName.equalsIgnoreCase("transport")) {
        bTransport = true;
      } else if (qName.equalsIgnoreCase("star")) {
        bStar = true;
      } else if (qName.equalsIgnoreCase("room")) {
        bRoom = true;
      } else if (qName.equalsIgnoreCase("television")) {
        bTelevision = true;
      } else if (qName.equalsIgnoreCase("wi-fi")) {
        bWiFi = true;
      } else if (qName.equalsIgnoreCase("breakfast")) {
        bBreakfast = true;
      } else if (qName.equalsIgnoreCase("cost")) {
        bCost = true;
      }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
      if (qName.equalsIgnoreCase("tour")) {
        tour.setHotel(hotel);
        tours.add(tour);
      }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
      if (bType) {
        tour.setType(new String(ch, start, length));
        bType = false;
      }
      if (bCountry) {
        tour.setCountry(new String(ch, start, length));
        bCountry = false;
      }
      if (bDays) {
        tour.setDays(Integer.parseInt(new String(ch, start, length)));
        bDays = false;
      }
      if (bNights) {
        tour.setNights(Integer.parseInt(new String(ch, start, length)));
        bNights = false;
      }
      if (bTransport) {
        tour.setTransport(new String(ch, start, length));
        bTransport = false;
      }
      if (bStar) {
        hotel.setStar(Integer.parseInt(new String(ch, start, length)));
        bStar = false;
      }
      if (bRoom) {
        hotel.setRoom(Integer.parseInt(new String(ch, start, length)));
        bRoom = false;
      }
      if (bTelevision) {
        hotel.setTelevision(Boolean.parseBoolean(new String(ch, start, length)));
        bTelevision = false;
      }
      if (bWiFi) {
        hotel.setWiFi(Boolean.parseBoolean(new String(ch, start, length)));
        bWiFi = false;
      }
      if (bBreakfast) {
        hotel.setBreakfast(Boolean.parseBoolean(new String(ch, start, length)));
        bBreakfast = false;
      }
      if (bCost) {
        tour.setCost(Integer.parseInt(new String(ch, start, length)));
        bCost = false;
      }
    }
  }

  public void execute() {
    try {
      Parser parser = new TourSAXParser();
      File xml = new File("src\\main\\resources\\tours.xml");
      System.out.println(parser.parse(xml));

    } catch (IOException e) {
      System.out.print("Unhandeled exeption");
    }
  }
}
