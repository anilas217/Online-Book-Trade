package dev_AnilOrhan.GetirCase.Controller.UserRepository;

import dev_AnilOrhan.GetirCase.Controller.Entity.Book;
import dev_AnilOrhan.GetirCase.Controller.Entity.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRep extends CrudRepository<Book,Long> {

}
