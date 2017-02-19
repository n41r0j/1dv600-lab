package lnu.resources;

import lnu.dao.booksDAO;
import lnu.models.book;
import org.codehaus.jackson.map.ObjectMapper;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.io.IOException;
import java.util.List;

// Response will be JSON
@Produces(MediaType.APPLICATION_JSON)

// This is the class that will be called when "localhost:9090/api/books" get called by the browser.
// FOR THE CURIOUS: Take a look in the config.yml to find out why "/api" is present in the path.
@Path("/books")
public class GetBooksResource {
	List<book> books;

	@GET
	public String getBooks() {
		books = new booksDAO().XMLtoObject();
		ObjectMapper mapper = new ObjectMapper();

		try {
			String arrayToJson = mapper.writeValueAsString(books);
			return arrayToJson;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return "";
	}
}
