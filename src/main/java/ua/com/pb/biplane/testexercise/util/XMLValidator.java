package ua.com.pb.biplane.testexercise.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;
import ua.com.pb.biplane.testexercise.util.exceptions.IncorrectInputXML;

import javax.xml.XMLConstants;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Source;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import java.io.File;
import java.io.IOException;

import static javax.xml.parsers.DocumentBuilderFactory.*;

/**
 * Created by Baelousov Artur Igorevich. E-mail: g.infosecurity@gmail.com on 13.04.15.
 */
public class XMLValidator {
    protected Logger logger = LoggerFactory.getLogger(XMLValidator.class);
    String SCHEMA_XSD = "src/main/resources/xml/schema.xsd";

    public boolean validate(File file) throws IOException, IncorrectInputXML {

        SchemaFactory factory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
        Source schemaFile = new StreamSource(new File(SCHEMA_XSD));
        Schema schema ;
        DocumentBuilder parser;
        Document document;


        try {
            parser = newInstance().newDocumentBuilder();
            document = parser.parse(file);
            schema = factory.newSchema(schemaFile);
            Validator validator = schema.newValidator();
            validator.validate(new DOMSource(document));
            return true;
        } catch (ParserConfigurationException e) {
            logger.error(e.getMessage());
            throw new IncorrectInputXML(e.getMessage());
        } catch (SAXException e) {
            logger.error(e.getMessage());
            throw new IncorrectInputXML(e.getMessage());
        }
    }

}

