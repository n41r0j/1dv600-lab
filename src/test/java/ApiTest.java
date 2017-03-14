import io.dropwizard.testing.junit.ResourceTestRule;
import lnu.resources.*;
import org.junit.ClassRule;
import org.junit.Test;

import static io.dropwizard.testing.FixtureHelpers.fixture;
import static org.fest.assertions.Assertions.assertThat;

/**
 * Created by JorianWielink on 05/03/2017.
 */
public class ApiTest {
    @ClassRule
    public static final ResourceTestRule resources = ResourceTestRule.builder()
            .addResource(new AddBookResource())
            .addResource(new EditBookResource())
            .addResource(new GetBookResource())
            .addResource(new GetBooksResource())
            .addResource(new RemoveBookResource())
            .build();

    @Test
    public void testGetBooks() {
        assertThat(resources.client().target("/books").request().get(String.class))
                .isEqualTo(fixture("books.json"));
        assertThat(resources.client().target("/books").request().get().getStatus())
                .isEqualTo(200);

    }

    @Test
    public void testRemoveBook() {
        //Not sure if the following is ok, but when i look around, a 204 seems to be a good result.
        assertThat(resources.client().target("/books/1").request().delete().getStatus())
                .isEqualTo(404);
        // A 404 status cannot be given, since the book must exist before being able to delete it, GUI-wise.
    }

    @Test
    public void testGetBook() {
        assertThat(resources.client().target("/books/545").request().get().getStatus())
                .isEqualTo(404);
        assertThat(resources.client().target("/books/4").request().get().getStatus())
                .isEqualTo(200); //After implementation this should return 200, since the book exists but the class is not implemented.
    }

    @Test
    public void testAddBook() {
//        assertThat(resources.client().target("1").request().put(Entity.entity())
//                .isEqualTo(404);
    }

    @Test
    public void testEditBook() {
        //Stuff should happen here, using POST etc, but I couldn't find out how.
    }
}