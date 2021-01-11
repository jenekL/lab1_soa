import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.util.List;

public class XMLWriter {

    public void writeToXML(String fileName, List<Product> first, List<Product> second) throws TransformerException, ParserConfigurationException {
        DocumentBuilderFactory documentFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder documentBuilder = documentFactory.newDocumentBuilder();
        Document document = documentBuilder.newDocument();

        Element root = document.createElement("catalog");
        document.appendChild(root);

        createCatalog(document, root, "list1", first);
        createCatalog(document, root, "list2", second);

        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();
        DOMSource domSource = new DOMSource(document);
        StreamResult streamResult = new StreamResult(new File(fileName));

        transformer.transform(domSource, streamResult);
    }

    private void createCatalog(Document document, Element root, String listName, List<Product> products){
        Element listElement = document.createElement(listName);
        root.appendChild(listElement);

        products.forEach(product -> {
            Element productElement = document.createElement("product");
            listElement.appendChild(productElement);

            Element name = document.createElement("name");
            name.appendChild(document.createTextNode(product.getName()));
            productElement.appendChild(name);

            Element extension = document.createElement("extension");
            extension.appendChild(document.createTextNode(product.getExtension()));
            productElement.appendChild(extension);

            Element price = document.createElement("price");
            price.appendChild(document.createTextNode(product.getPrice().toString()));
            productElement.appendChild(price);

            Element sellNumber = document.createElement("sellNumber");
            sellNumber.appendChild(document.createTextNode(product.getSellNumber().toString()));
            productElement.appendChild(sellNumber);
        });
    }

}
