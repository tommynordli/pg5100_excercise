import javax.persistence.Embeddable;

/**
 * Created by Tommy on 08/09/2016.
 */
@Embeddable
public class Address {

    private String city;
    private String country;

    public Address(){}

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}