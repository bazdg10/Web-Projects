package baz.springframework.demo.domain;
import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @ManyToOne
    @JoinColumn(name ="publisher_id")
    private Publisher publisher;
    private String title;
    private String isBn;

    @ManyToMany
    @JoinTable(name = "author_book", joinColumns = @JoinColumn(name = "book_id"),
    inverseJoinColumns = @JoinColumn(name = "author_id"))
    private Set<Author> authors = new HashSet<>();

    public Book(){

    }
    public Book(String title, String isBn) {
        this.title = title;
        this.isBn = isBn;
    //    this.authors = authors;
    }

    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public String getTitle() {
        return title;
    }
    public String getIsBn() {
        return isBn;
    }
    public Set<Author> getAuthors() {
        return authors;
    }
    public void setTitle(String title){
        this.title = title;
    }
    public void setIsBn(String isBn) {
        this.isBn = isBn;
    }
    public void setAuthors(Set<Author> authors) {
        this.authors = authors;
    }
    public void setPublisher(Publisher publisher) {
        this.publisher = publisher;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", isBn='" + isBn + '\'' +
                ", authors=" + authors +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return id == book.id;
    }
    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
