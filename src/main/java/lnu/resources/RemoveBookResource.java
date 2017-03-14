package lnu.resources;

import lnu.dao.booksDAO;
import lnu.models.book;

import javax.ws.rs.DELETE;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;

@Path("books/{id}")
@Produces(MediaType.APPLICATION_JSON)
public class RemoveBookResource {

    @DELETE
    public Response removeBook(@PathParam("id") String id) {
        booksDAO booksDAO = new booksDAO();
        System.out.println("RUNS!");

        boolean found = false;
        List<book> catalog = booksDAO.XMLtoObject();
        List<book> temp = new ArrayList<>(catalog.size());

        for (book b : catalog) {
            if (b.getId().equals(id)) {
                found = true;
            } else {
                temp.add(b);
            }
        }



//        List<book> temp = catalog.stream()
//                .filter(b -> !id.equals(b.getId()))
//                .collect(Collectors.toList());
        booksDAO.objectToXML(temp);

        if (found) return Response.status(Response.Status.OK).build();
        else return Response.status(Response.Status.NOT_FOUND).build();
    }
}