package baz.springframework.demo.repositories;
import baz.springframework.demo.domain.Publisher;
import org.springframework.data.repository.CrudRepository;

public interface PublisherRepository extends CrudRepository<Publisher, Long> {
}
