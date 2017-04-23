package pl.ormlite.example;

import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.dao.GenericRawResults;
import com.j256.ormlite.jdbc.JdbcConnectionSource;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;
import org.postgresql.jdbc2.optional.SimpleDataSource;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
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

        //Władca Pierścieni
        Book book = new Book();
        book.setTitle("Władca Pierścieni");
        book.setDescription("Wielkie dzieło Tolkiena");
        book.setIsbn("1111");
        book.setAddedDate(new Date());

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/mm/dd");
        String dateInString = "2012/11/11";
        Date date = sdf.parse(dateInString);

        book.setDateRelase(date);
        book.setRating("1");
        book.setBorrowed(true);
        book.setPrice(33.99);

        //Piesn Lodu i Ognia
        Book book2 = new Book();
        book2.setTitle("Pieśń Lodu i Ognia");
        book2.setDescription("Gra o Tron");
        book2.setIsbn("2222");
        book2.setAddedDate(new Date());

        SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy/mm/dd");
        String dateInString2 = "2013/11/11";
        Date date2 = sdf2.parse(dateInString2);

        book2.setDateRelase(date2);
        book2.setRating("2");
        book2.setPrice(200.88);

        //Wiedzmin
        Book book3 = new Book();
        book3.setTitle("Wiedzmin");
        book3.setDescription("Cykl odpowiadań o Geralcie");
        book3.setIsbn("3333");
        book3.setAddedDate(new Date());

        SimpleDateFormat sdf3 = new SimpleDateFormat("yyyy/mm/dd");
        String dateInString3 = "2014/11/11";
        Date date3 = sdf3.parse(dateInString3);

        book3.setDateRelase(date3);
        book3.setRating("3");
        book3.setPrice(50.99);

        Dao<Book, Integer> dao = DaoManager.createDao(connectionSource, Book.class); // metoda statyczna createDao, przekazujemy połaczenie do bazdy danych, nazwe naszej klasy
        // <parametr naszej klasy, naszego id>

        dao.create(book);
        dao.create(book2);
        dao.create(book3);
        System.out.println(book);

        /*
        GenericRawResults<String[]> rawResults = dao.queryRaw("SELECT * FROM books");
        List<String[]> result = rawResults.getResults(); //tablica stringów , 3 ksiązki - 3 tablice
        result.forEach( e->{
            for(String s : e){
                System.out.println(s);
            }
        });
        System.out.println("");

        GenericRawResults<String[]> where = dao.queryRaw("SELECT * FROM books WHERE title ='Pieśń Lodu i Ognia'");
        List<String[]> resultsWhere = where.getResults(); //tablica stringów , 3 ksiązki - 3 tablice
        resultsWhere.forEach( e->{
            for(String s : e){
                System.out.println(s);
            }
        });


        GenericRawResults<String[]> selectMinMax = dao.queryRaw("SELECT MIN(price), MAX(price) FROM books");
        List<String[]> resultsMinMax = selectMinMax.getResults(); //tablica stringów , 3 ksiązki - 3 tablice
        resultsMinMax.forEach( e->{
            for(String s : e){
                System.out.println(s);
            }
        });
        System.out.println("");

        GenericRawResults<String[]> selectCount = dao.queryRaw("SELECT count(*) FROM books WHERE borrowed=1");
        List<String[]> resultsCount = selectCount.getResults(); //tablica stringów , 3 ksiązki - 3 tablice
        resultsCount.forEach( e->{
            for(String s : e){
                System.out.println(s);
            }
        });
        System.out.println("");

        double maxUnits = dao.queryRawValue("SELECT AVG(price) FROM books");
        System.out.println(maxUnits);
        */

        /*
        book.setTitle("Hobbit");
        dao.update(book);
        System.out.println("Po update"+book);

        dao.delete(book);
        System.out.println("Po delete"+book);

        dao.queryForId(book.getId());
        System.out.println("Po query"+book);
        */




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
