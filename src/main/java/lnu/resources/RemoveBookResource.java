package lnu.resources;

import lnu.dao.booksDAO;
import lnu.models.book;

import javax.ws.rs.DELETE;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;
import java.util.stream.Collectors;

@Produces(MediaType.APPLICATION_JSON)
@Path("/books/")
public class RemoveBookResource {

    @DELETE
    @Path("{id}")
    public void removeBook(@PathParam("id") String id) {
        booksDAO booksDAO = new booksDAO();
        List<book> catalog = booksDAO.XMLtoObject();
        List<book> temp = catalog.stream()
                .filter(b -> !id.equals(b.getId()))
                .collect(Collectors.toList());

        booksDAO.ObjectToXML(temp);
    }
}