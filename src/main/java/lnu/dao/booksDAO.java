package lnu.dao;

// Use this file to write and read the xml file.
// http://www.journaldev.com/1234/jaxb-tutorial-example-to-convert-object-to-xml-and-xml-to-object
// javax.xml.bind is added as a part of the sdk from java7 and forward.

import lnu.models.book;
import lnu.models.catalog;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.util.List;

public class booksDAO {
    private String pathName = "books.xml";

    public List<book> XMLtoObject() {
        catalog catalog = new catalog();
        try {
            JAXBContext context = JAXBContext.newInstance(catalog.class);
            Unmarshaller un = context.createUnmarshaller();
            catalog = (catalog) un.unmarshal(new File(pathName));
        } catch (JAXBException j) {
            j.printStackTrace();
        }
        return catalog.getBooks();
    }

    public void objectToXML(List<book> list) {
        catalog catalog = new catalog();
        catalog.setBooks(list);

        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(catalog.class);
            Marshaller ms = jaxbContext.createMarshaller();

            ms.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

            ms.marshal(catalog, new File(pathName));

        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        booksDAO temp = new booksDAO();
        temp.XMLtoObject();
    }

    public String getPathName() {
        return pathName;
    }

    public void setPathName(String pathName) {
        this.pathName = pathName;
    }
}
