package lnu.resources;

import lnu.dao.booksDAO;
import lnu.models.book;
import org.codehaus.jackson.map.ObjectMapper;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.IOException;
import java.util.List;

@Path("books/{id}")
@Produces(MediaType.APPLICATION_JSON)
public class GetBookResource {

    @GET
    public Response getBook(@PathParam("id") String id) {
        booksDAO booksDAO = new booksDAO();
        List<book> books = booksDAO.XMLtoObject();

        for (book b : books) {
            if (b.getId().equals(id)) {
                ObjectMapper mapper = new ObjectMapper();
                try {
                    return Response.status(Response.Status.OK).entity(mapper.writeValueAsString(b)).build();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return Response.status(Response.Status.NOT_FOUND).build();
    }
}