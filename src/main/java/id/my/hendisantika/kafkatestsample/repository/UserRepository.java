package id.my.hendisantika.kafkatestsample.repository;

import id.my.hendisantika.kafkatestsample.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * Project : spring-boot-kafka-test-sample
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 3/17/24
 * Time: 06:04
 * To change this template use File | Settings | File Templates.
 */
@Repository
public interface UserRepository extends JpaRepository<User, String> {

    List<User> getByFirstNameIgnoreCaseOrderByFirstNameAscLastNameAsc(String firstName);
}
