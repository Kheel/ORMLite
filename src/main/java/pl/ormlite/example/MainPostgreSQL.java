package pl.ormlite.example;

import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.jdbc.JdbcConnectionSource;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;

import java.io.IOException;
import java.sql.SQLException;

/**
 * Created by Admin on 2017-04-23.
 */
public class MainPostgreSQL {

    public static void main(String[] args) throws SQLException, IOException {
        String url="jdbc:postgresql://localhost:5433/ormlite";
        //"jdbc:postgresql://host:port/database"
        ConnectionSource connectionSource = new JdbcConnectionSource(url, "postgres" ,"op81u22s" );

        TableUtils.dropTable(connectionSource, Book.class , true);  //przekazujemy połączenie, informacje o tabeli tworzonej na podstawie danej klasy
                                                                                // true - pomija informacje o ewentualnych błędach
        TableUtils.createTableIfNotExists(connectionSource, Book.class);        //przekazujemy połączenie, informacje o tabeli tworzonej na podstawie danej klasy

        TableUtils.dropTable(connectionSource, Author.class , true);

        TableUtils.createTableIfNotExists(connectionSource, Author.class);

        Dao<Book, Integer> daoBook= DaoManager.createDao(connectionSource, Book.class);
        //Dao<Book, Integer> daoAuthor= DaoManager.createDao(connectionSource, Author.class);

        Author author = DataCreator.author();
        Book book = DataCreator.firstBook();
        book.setAuthor(author);

        daoBook.createOrUpdate(book);

        connectionSource.close();
    }


}
