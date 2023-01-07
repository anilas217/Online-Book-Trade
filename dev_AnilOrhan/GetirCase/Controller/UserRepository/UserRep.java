package dev_AnilOrhan.GetirCase.Controller.UserRepository;

import dev_AnilOrhan.GetirCase.Controller.Entity.User;
import org.hibernate.sql.Select;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRep extends CrudRepository<User,Long> {

}
