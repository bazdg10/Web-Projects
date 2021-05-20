package baz.springframework.demo.bootstrap;

import baz.springframework.demo.domain.Author;
import baz.springframework.demo.domain.Book;
import baz.springframework.demo.domain.Publisher;
import baz.springframework.demo.repositories.AuthorRepository;
import baz.springframework.demo.repositories.BookRepository;
import baz.springframework.demo.repositories.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootStrapData implements CommandLineRunner {
    // When spring finds commandLineRunner classes, Spring runs them

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;

    public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        Publisher p1 = new Publisher();
        p1.setAddressl1("%5th and Queens");
        p1.setCity("New York City");
        p1.setState("New York");
        //Publisher p2 = new Publisher();
        publisherRepository.save(p1);
        System.out.println("Started Bootstrap!");
        System.out.println( "Number of publishers: " + publisherRepository.count());
        //        publisherRepository.save(p2);
        Author eric = new Author("Ed", "Sheeran");
        Book ddd = new Book("Domain Driven Design","123098");
        //Publisher p1 = new Publisher("Bo", "6th and Broad", "New York City", "New York");
        eric.getBooks().add(ddd);
        ddd.getAuthors().add(eric);
        authorRepository.save(eric);
        bookRepository.save(ddd);
//        publisherRepository.save(p1);
        ddd.setPublisher(p1);
        Author mark = new Author("Mark", "Mason");
        Book cool = new Book("Subtle Art of not giving a ... ", "1223421");
        Publisher p2 = new Publisher();
        p2.setState("Texas");
        p2.setCity("Dallas");
        publisherRepository.save(p2);
        cool.setPublisher(p2);
        p1.getBooks().add(ddd);
        authorRepository.save(mark);
        bookRepository.save(cool);
  //      publisherRepository.save(p2);
        p2.getBooks().add(cool);
        System.out.println("Books Count : " + bookRepository.count() );


    }
}
