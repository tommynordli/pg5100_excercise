import javax.persistence.*;

/**
 * Created by Tommy on 08/09/2016.
 */

@NamedQueries({
        @NamedQuery(name = User.GET_ALL_COUNTRIES, query = "select distinct u.address.country from User u"),
        @NamedQuery(name = User.GET_SUM_USERS_NORWAY, query = "select sum(u.id) from User u where u.address.country = 'Norway'"),
        @NamedQuery(name = User.GET_SUM_USERS, query = "select sum(u.id) from User u"),
        @NamedQuery(name = User.GET_ALL, query = "select u from User u")
})

@Entity
public class User {

    public static final String GET_ALL_COUNTRIES = "GET_ALL_COUNTRIES";
    public static final String GET_SUM_USERS = "GET_SUM_USERS";
    public static final String GET_SUM_USERS_NORWAY = "GET_SUM_USERS_NORWAY";
    public static final String GET_ALL = "GET_ALL";

    @Id
    @GeneratedValue
    private Long id;

    private String name;
    private Address address;

    @Column(unique = true)
    private String email;

    private String password;

    public User(){}

    public Long getUserId() {
        return id;
    }

    public String getName() {
        if (name == null) {
            name = "";
        }
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Address getAddress() {
        if (address == null) {
            address = new Address();
        }
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}

