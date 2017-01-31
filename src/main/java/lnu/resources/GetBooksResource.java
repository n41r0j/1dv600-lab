package lnu.resources;

import lnu.models.book;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
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

		for (book i : books) {
			System.out.println(i.toString());
		}

		return "";
	}

}
