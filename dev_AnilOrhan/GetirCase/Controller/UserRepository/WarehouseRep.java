package dev_AnilOrhan.GetirCase.Controller.UserRepository;

import dev_AnilOrhan.GetirCase.Controller.Entity.User;
import dev_AnilOrhan.GetirCase.Controller.Entity.WareHouse;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WarehouseRep extends CrudRepository<WareHouse,Long> {


}


