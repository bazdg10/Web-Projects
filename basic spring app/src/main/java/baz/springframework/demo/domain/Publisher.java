package baz.springframework.demo.domain;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;


@Entity
public class Publisher {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

    private String name;
    //private Addres address;
    private String addressl1;
    private String city;
    private String state;

    @OneToMany
    private Set<Book> books = new HashSet<>();

    public Publisher(){
    }
    /*public Publisher (String name, String addressl1, String city, String state) {
        this.name = name;
    //    this.address = new Address((addressl1, city, state));
        this.addressl1 = addressl1;
        this.city = city;
        this.state = state;
    }*/

    /*public void setAddress(Address address) {
        this.address = address;
    }*/

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    /*public Address getAddress() {
        return this.address;
    }*/

    public String getAddressl1() {
        return addressl1;
    }
    public String getCity() {
        return city;
    }
    public String getState() {
        return state;
    }
    public void setAddressl1(String addressl1) {
        this.addressl1 = addressl1;
    }
    public void setState(String state) {
        this.state = state;
    }
    public void setCity(String city) {
        this.city = city;
    }

    public Set<Book> getBooks() {
        return books;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Publisher publisher = (Publisher) o;
        return Objects.equals(id, publisher.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Publisher{" +
                "id=" + id +
                ", name='" + name + '\'' +
                //", address=" + address +
                ", addressl1='" + addressl1 + '\'' +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                '}';
    }
}


