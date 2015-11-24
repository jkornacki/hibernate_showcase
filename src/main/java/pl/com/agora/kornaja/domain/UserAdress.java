package pl.com.agora.kornaja.domain;

import javax.persistence.Embeddable;

/**
 * Created by P on 2015-11-23.
 */
@Embeddable
public class UserAdress {
    private String country;
    private String city;
    private String zipCode;

    @Override
    public String toString() {
        return "UserAdress{" +
                "country='" + country + '\'' +
                ", city='" + city + '\'' +
                ", zipCode='" + zipCode + '\'' +
                '}';
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }
}
