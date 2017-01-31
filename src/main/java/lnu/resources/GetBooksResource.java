package lnu.resources;

import lnu.models.book;
import org.codehaus.jackson.map.ObjectMapper;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

// Response will be JSON
@Produces(MediaType.APPLICATION_JSON)

// This is the class that will be called when "localhost:9090/api/books" get called by the browser.
// FOR THE CURIOUS: Take a look in the config.yml to find out why "/api" is present in the path.
@Path("/books")
public class GetBooksResource {

	@GET
	public String getBooks() {
		List<book> books = new ArrayList<>();
//		StringBuilder sb = new StringBuilder();

		book orwell = new book("1984", "George Orwell");
		book wilkomirski = new book("Fragments", "Benjamin Wilkomirski");

		books.add(orwell);
		books.add(wilkomirski);

		ObjectMapper mapper = new ObjectMapper();

		String out;

		for (book i : books) {
			try {
				out = mapper.writeValueAsString(i);
			} catch (IOException e) {
				out = null;
				e.printStackTrace();
			}
			System.out.println(out);
		}

		return "[{\"id\":\"198401\",\"title\":\"1984\",\"author\":\"George Orwell\"}]";
	}

}
