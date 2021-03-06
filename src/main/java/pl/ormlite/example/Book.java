package pl.ormlite.example;

import com.j256.ormlite.field.DataType;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

import java.util.Date;

/**
 * Created by Admin on 2017-04-11.
 */
@DatabaseTable(tableName = "books")
public class Book {

    public Book() {

    }

    @DatabaseField(generatedId = true)
    private int id;

    @DatabaseField(columnName = "TITLE", canBeNull = false)
    private String title;

    @DatabaseField(columnName = "AUTHOR_ID" , foreign = true, foreignAutoCreate = true , foreignAutoRefresh = true )
    private Author author; //author_id

    @DatabaseField(columnName = "DESCRIPTION", dataType = DataType.LONG_STRING)
    private String description;

    @DatabaseField(columnName = "PRICE")
    private double price;

    @DatabaseField(columnName = "ISBN", unique = true)
    private String isbn;

    @DatabaseField(columnName = "ADDED_DATE")
    private Date addedDate;

    @DatabaseField(columnName = "DATE_RELASE", dataType = DataType.DATE_STRING, format = "yyyy-mm-dd")
    private Date dateRelase;

    @DatabaseField(columnName = "RATING", width = 1)
    private String rating;

    @DatabaseField(columnName = "BORROWED", defaultValue = "false")
    private boolean borrowed;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public Date getAddedDate() {
        return addedDate;
    }

    public void setAddedDate(Date addedDate) {
        this.addedDate = addedDate;
    }

    public Date getDateRelase() {
        return dateRelase;
    }

    public void setDateRelase(Date dateRelase) {
        this.dateRelase = dateRelase;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public boolean isBorrowed() {
        return borrowed;
    }

    public void setBorrowed(boolean borrowed) {
        this.borrowed = borrowed;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", author=" + author +
                ", description='" + description + '\'' +
                ", price=" + price +
                ", isbn='" + isbn + '\'' +
                ", addedDate=" + addedDate +
                ", dateRelase=" + dateRelase +
                ", rating='" + rating + '\'' +
                ", borrowed=" + borrowed +
                '}';
    }

}
