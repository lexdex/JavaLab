package parser.dom;



import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

import java.util.ArrayList;
import java.util.List;

public class DOMDocumentReader<T> {

    public List<T> readDoc(Document document){
        document.getDocumentElement().normalize();
        List<T> list = new ArrayList<>();
        NodeList nodes = document.getElementsByTagName("gems");
        return null;
    }
}
