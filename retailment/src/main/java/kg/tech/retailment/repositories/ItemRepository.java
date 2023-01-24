package kg.tech.retailment.repositories;

import kg.tech.retailment.entities.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<Item, Long> {

}
