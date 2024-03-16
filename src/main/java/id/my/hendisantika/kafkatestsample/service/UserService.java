package id.my.hendisantika.kafkatestsample.service;

import id.my.hendisantika.kafkatestsample.dto.UserDTO;
import id.my.hendisantika.kafkatestsample.entity.User;
import id.my.hendisantika.kafkatestsample.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * Project : spring-boot-kafka-test-sample
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 3/17/24
 * Time: 06:05
 * To change this template use File | Settings | File Templates.
 */
@Service
@Slf4j
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public void save(UserDTO user) {
        log.info("Saving user with id = {}", user.getUuid());
        userRepository.save(new User(user.getUuid(), user.getFirstName(), user.getLastName()));
    }

    public List<User> getUsers(String firstName) {
        return userRepository.getByFirstNameIgnoreCaseOrderByFirstNameAscLastNameAsc(firstName);
    }
}
