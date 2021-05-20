package baz.springframework.demo.repositories;
import baz.springframework.demo.domain.Author;
import org.springframework.data.repository.CrudRepository;

public interface AuthorRepository extends CrudRepository<Author, Long> {



}
