package repository;

import User.User;
import org.springframework.data.repository.CrudRepository;

public interface userRepository extends CrudRepository<User, String> {

}
