import io.dropwizard.testing.junit.ResourceTestRule;
import lnu.resources.GetBooksResource;
import lnu.resources.PingResource;
import org.junit.ClassRule;
import org.junit.Test;

import static org.fest.assertions.Assertions.assertThat;

/**
 * Created by JorianWielink on 05/03/2017.
 */
public class EditBookApiTest {
    @ClassRule
    public static final ResourceTestRule resources = ResourceTestRule.builder()
            .addResource(new GetBooksResource())
            .build();

    @Test
    public void testGetBooks() {
        assertThat(resources.client().target("/books").request().get(String.class))
                .isEqualTo(new GetBooksResource().getBooks());
    }
}
