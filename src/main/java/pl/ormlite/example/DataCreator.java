package pl.ormlite.example;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Admin on 2017-04-24.
 */
public class DataCreator {

    public static Book firstBook() {
        Book book = new Book();
        book.setTitle("Władca Pierścieni");
        book.setDescription("Wielki świat stworzony przez Tolkiena, opowieść o zniszczeniu pierścienia");
        book.setIsbn("123456789");
        book.setAddedDate(new Date());

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/mm/dd");
        String dateInString = "2012/11/11";
        Date date = null;

        try {
            date = sdf.parse(dateInString);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        book.setDateRelase(date);
        book.setRating("5");
        book.setBorrowed(true);
        book.setPrice(100);
        return book;
    }

    public static Author author(){
        Author author = new Author();
        author.setName("Tolkien");
        return author;
    }
}
