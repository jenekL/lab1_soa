import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import java.io.IOException;
import java.net.URL;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class FileHandler {

    private final XMLReader xmlReader = new XMLReader();
    private final XMLWriter xmlWriter = new XMLWriter();

    public void handleFile(String fileName, Double minimalPrice) throws IOException, SAXException, ParserConfigurationException, TransformerException {
        URL resource = this.getClass().getClassLoader().getResource(fileName);

        List<Product> products = xmlReader.read(resource.getPath());

        List<Product> firstCatalog = products.stream()
                .filter(product -> product.getSellNumber() <= 2)
                .sorted(Comparator.comparing(Product::getName))
                .collect(Collectors.toList());

        List<Product> secondCatalog = products.stream()
                .filter(product -> product.getPrice() >= minimalPrice)
                .sorted(Comparator.comparing(Product::getName))
                .collect(Collectors.toList());

        xmlWriter.writeToXML("bla.xml", firstCatalog, secondCatalog);

    }

}
