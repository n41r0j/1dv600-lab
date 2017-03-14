package lnu.models;

import javax.xml.bind.annotation.*;

@XmlRootElement(name = "book")
public class book {

    private String id;
    private String author;
    private String title;
    private String genre;
    private double price;
    private String publishDate;
    private String description;

    public book() {

    }

//    public book(String id, String title, String author) {
//        this.setId(id);
//        this.setTitle(title);
//        this.setAuthor(author);
//    }

    public String toString() {
        StringBuilder output = new StringBuilder();
        output.append(this.getTitle()).append(this.getAuthor()).append(this.getId());
        return String.valueOf(output);
    }

    @XmlAttribute
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(String publishDate) {
        this.publishDate = publishDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}