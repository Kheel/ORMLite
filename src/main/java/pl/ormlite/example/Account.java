package pl.ormlite.example;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

/**
 * Created by Admin on 2017-04-10.
 */
@DatabaseTable(tableName = "accounts")

    public class Account {
        @DatabaseField(id = true)
        private String name;
        @DatabaseField(canBeNull = false)
        private String password;

        public Account() { // all persisted classes must define a no-arg constructor with at least package visibility } ... }

        }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
