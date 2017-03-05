import lnu.models.book;
import lnu.resources.GetBooksResource;
import org.codehaus.jackson.map.ObjectMapper;
import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.fest.assertions.Assertions.assertThat;

/**
 * Created by JorianWielink on 04/03/2017.
 */
public class GetBooksResourcesTest {

    @Test
    public void testGetZeroBooks() {
        ObjectMapper mapper = new ObjectMapper();
        String expectedJSON = "";
        List<book> bookList = new ArrayList<>();

        GetBooksResource getBooksResource = new GetBooksResource();
        getBooksResource.setBooks(bookList);

        // Assertion for 0 books:
        try {
            expectedJSON = mapper.writeValueAsString(bookList);
        } catch (IOException e) {
            e.printStackTrace();
        }

        assertThat(getBooksResource.getBooks()).isEqualTo(expectedJSON);
    }

    @Test
    public void testGetOneBook() {

        ObjectMapper mapper = new ObjectMapper();
        String expectedJSON = "";
        List<book> bookList = new ArrayList<>();

        GetBooksResource getBooksResource = new GetBooksResource();
        getBooksResource.setBooks(bookList);

        // Assertion for 1 book:
        book book = new book();
        book.setAuthor("J.K. Rowling");
        book.setTitle("Harry Potter");

        bookList.add(book);

        try {
            expectedJSON = mapper.writeValueAsString(bookList);
        } catch (IOException e) {
            e.printStackTrace();
        }

        assertThat(getBooksResource.getBooks()).isEqualTo(expectedJSON);
    }

    @Test
    public void testGetTwoBooks() {
        ObjectMapper mapper = new ObjectMapper();
        String expectedJSON = "";
        List<book> bookList = new ArrayList<>();

        GetBooksResource getBooksResource = new GetBooksResource();
        getBooksResource.setBooks(bookList);

        // Assertion for 2 books:
        book book = new book();
        book.setAuthor("J.K. Rowling");
        book.setTitle("Harry Potter");

        bookList.add(book);

        book = new book();
        book.setAuthor("Hans Rudolf");
        book.setTitle("Get zhe Flammenwerfer, Hans!");

        bookList.add(book);

        try {
            expectedJSON = mapper.writeValueAsString(bookList);
        } catch (IOException e) {
            e.printStackTrace();
        }

        assertThat(getBooksResource.getBooks()).isEqualTo(expectedJSON);
    }
}
