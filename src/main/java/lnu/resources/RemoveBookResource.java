package lnu.resources;

import lnu.dao.booksDAO;
import lnu.models.book;

import javax.ws.rs.DELETE;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;
import java.util.List;

@Produces(MediaType.APPLICATION_JSON)
@Path("/books/")
public class RemoveBookResource {

    @DELETE
    @Path("{id}")
    public void removeBook(@PathParam("id") String id) {
        booksDAO booksDAO = new booksDAO();
        List<book> catalog = booksDAO.XMLtoObject();
        List<book> temp = new ArrayList<>();

        for (book b: catalog) {
            if (!b.getId().equals(id)) {
                temp.add(b);
            }
            System.out.println(id + "==" + b.getId());
        }
        booksDAO.ObjectToXML(temp);
    }
}