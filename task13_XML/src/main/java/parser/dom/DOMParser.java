package parser.dom;


import menu.Command;
import model.Gem;

import org.w3c.dom.Document;
import java.io.File;
import java.util.List;

public class DOMParser implements Command {


  public static List<Gem> getElList(File xml) {
    DOMDocumentCreator creator = new DOMDocumentCreator();
    Document document = creator.getDocument(xml);

    DOMDocumentReader<Gem> parser = new DOMDocumentReader<>();
    return parser.readDoc(document);
   }

    public void execute() {
      File xml = new File("src/main/resources/tours.xml");
      getElList(xml);
    }


}
