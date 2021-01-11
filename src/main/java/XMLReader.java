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

public class XMLReader {

    public List<Product> read(String filePath) throws ParserConfigurationException, IOException, SAXException {
        File fXmlFile = new File(filePath);

        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
        Document doc = dBuilder.parse(fXmlFile);
        doc.getDocumentElement().normalize();

        NodeList nList = doc.getElementsByTagName("product");

        List<Product> products = new ArrayList<>();

        for (int temp = 0; temp < nList.getLength(); temp++) {
            Node nNode = nList.item(temp);

            if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                Element eElement = (Element) nNode;
                products.add(new Product(
                        eElement.getElementsByTagName("name").item(0).getTextContent(),
                        eElement.getElementsByTagName("extension").item(0).getTextContent(),
                        Double.valueOf(eElement.getElementsByTagName("price").item(0).getTextContent()),
                        Integer.valueOf(eElement.getElementsByTagName("sellNumber").item(0).getTextContent())));
            }
        }

        return products;
    }
}
