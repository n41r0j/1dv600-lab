import io.dropwizard.testing.junit.ResourceTestRule;
import lnu.models.book;
import lnu.resources.EditBookResource;
import org.junit.ClassRule;
import org.junit.Test;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

import static org.fest.assertions.Assertions.assertThat;

/**
 * Created by JorianWielink on 04/03/2017.
 */
public class EditBookResourceTest {

    @Test
    public void testEditBooks() {
        book endResultBook = new book();
        endResultBook.setId("678");
        endResultBook.setTitle("Wars");
        List<book> resultList = new ArrayList<>();
        resultList.add(endResultBook);

        String expectedPathName = "editBooksTest.xml";

        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(book.class);
            Marshaller ms = jaxbContext.createMarshaller();
            ms.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            ms.marshal(endResultBook, new File(expectedPathName));

        } catch (JAXBException e) {
            e.printStackTrace();
        }

        book toChangeBook = new book();
        toChangeBook.setId("678");
        toChangeBook.setTitle("Star");
        List<book> startList = new ArrayList<>();
        startList.add(toChangeBook);

        EditBookResource editBookResource = new EditBookResource();

        // This 'fakes' the call from the REST API, being a JSON string
        editBookResource.createBookObject("678","","Wars","",0,"","");
        editBookResource.replaceAndSaveBookToXML();

        assertThat(new File(expectedPathName)).isEqualTo(new File(editBookResource.getFileLocation()));

    }
}
