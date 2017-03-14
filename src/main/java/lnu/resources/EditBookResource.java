package lnu.resources;

import lnu.models.book;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Produces(MediaType.APPLICATION_JSON)
public class EditBookResource {
    private book bookToUpdate;
    private String fileLocation;

    public void createBookObject(@PathParam("{id}") String id,
                                 @PathParam("{author}") String author,
                                 @PathParam("{title}") String title,
                                 @PathParam("{genre}") String genre,
                                 @PathParam("{price}") double price,
                                 @PathParam("{publishDate}") String publishdate,
                                 @PathParam("{description}") String description) {
        throw new NotImplementedException();
    }

    public void replaceAndSaveBookToXML() {
        throw new NotImplementedException();
    }

    public String getFileLocation() {
        return fileLocation;
    }
}