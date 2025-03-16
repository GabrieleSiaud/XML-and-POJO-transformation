package util;

import org.xml.sax.SAXException;

import javax.xml.XMLConstants;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import java.io.File;
import java.io.IOException;

/**
 * Klase kuri tikrina ar egzistuoja XML ir XSD failai
 * Gautus failus validuoja
 */

public class XMLValidator {
    public static void validateXML(File xmlFile, File xsdFile) throws SAXException, IOException {
        if (!xmlFile.exists()) {
            throw new IOException("XML file not found: " + xmlFile.getAbsolutePath());
        }
        if (!xsdFile.exists()) {
            throw new IOException("XSD file not found: " + xsdFile.getAbsolutePath());
        }

        SchemaFactory factory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
        Schema schema = factory.newSchema(xsdFile);
        Validator validator = schema.newValidator();
        validator.validate(new StreamSource(xmlFile));
        System.out.println("XML validation successful.");
    }
}
