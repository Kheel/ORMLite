package pl.ormlite.example;

import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.jdbc.JdbcConnectionSource;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;
import org.postgresql.jdbc2.optional.SimpleDataSource;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.SimpleTimeZone;

/**
 * Created by Admin on 2017-04-10.
 */
public class Main {

    public static void main (String[] args) throws SQLException, IOException, ParseException {
        System.out.println("Hello world");

        // this uses h2 but you can change it to match your database
        String databaseUrlH2 = "jdbc:h2:./database";
        String databaseUrl = "jdbc:sqlite:bazadanych";
        // create a connection source to our database
        ConnectionSource connectionSource = new JdbcConnectionSource(databaseUrl); // konstruktor jdbc , baza danych, login, hasł
        //ConnectionSource connectionSource = new JdbcConnectionSource(databaseUrlH2, "admin", "admin"); // konstruktor jdbc , baza danych, login, hasło
        // instantiate the DAO to handle Account with String id
        //Dao<Account,String> accountDao = DaoManager.createDao(connectionSource, Account.class);
        // if you need to create the 'accounts' table make this call

        TableUtils.dropTable(connectionSource, Book.class, true);
        TableUtils.createTableIfNotExists(connectionSource, Book.class);

        Book book = new Book();
        book.setTitle("Władca Pierścieni");
        book.setIsbn("1111");
        book.setAddedDate(new Date());

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/DD");
        String dateInString = "2012/11/11";
        Date date = sdf.parse(dateInString);


        book.setDateRelase(date);
        book.setRating("1");
        book.setBorrowed(true);
        book.setPrice(33.99);

        Dao<Book, ?> dao = DaoManager.createDao(connectionSource, Book.class);

        dao.create(book);



        /*TableUtils.createTable(connectionSource, Account.class);
        // create an instance of Account
        String name = "Jim Smith";
        Account account = new Account();
        account.setName(name);
        account.setPassword("tajne");
        // persist the account object to the database
        accountDao.create(account);
        // retrieve the account
        Account account2 = accountDao.queryForId(name);
        // show its password
        System.out.println("Account: " + account2.getPassword());
        */

        // close the connection source
        connectionSource.close();
    }
}
