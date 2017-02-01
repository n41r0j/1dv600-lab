package lnu.models;


public class book {
    public String title;
    public String author;
    public String id;

    public book(String id, String title, String author) {
        this.id = id;
        this.title = title;
        this.author = author;
    }

    public String toString() {
        StringBuilder output = new StringBuilder();
        output.append(this.title).append(this.author);
        return String.valueOf(output);
    }
}