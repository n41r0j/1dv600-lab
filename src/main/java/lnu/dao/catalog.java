package lnu.dao;

import lnu.models.book;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

/**
 * Created by n41r0j on 2017-02-19.
 */

@XmlRootElement(name = "catalog")
@XmlAccessorType(XmlAccessType.FIELD)

public class catalog {

    @XmlElement(name = "book")
    private List<book> books = null;

    public List<book> getBooks() {
        return books;
    }

    public void setBooks(List<book> books) {
        this.books = books;
    }
}
