import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import java.io.IOException;

public class Main {

    public static void main(String... args) throws SAXException, TransformerException, ParserConfigurationException, IOException {
        FileHandler fileHandler = new FileHandler();
        fileHandler.handleFile("example.xml", 100.0);
    }

}
