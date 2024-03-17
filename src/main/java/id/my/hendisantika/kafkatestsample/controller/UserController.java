package id.my.hendisantika.kafkatestsample.controller;

import com.github.javafaker.Faker;
import id.my.hendisantika.kafkatestsample.dto.UserDTO;
import id.my.hendisantika.kafkatestsample.entity.User;
import id.my.hendisantika.kafkatestsample.kafka.producer.UserKafkaProducer;
import id.my.hendisantika.kafkatestsample.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

import static java.util.stream.Collectors.toList;

/**
 * Created by IntelliJ IDEA.
 * Project : spring-boot-kafka-test-sample
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 3/17/24
 * Time: 06:10
 * To change this template use File | Settings | File Templates.
 */
@RestController
@RequestMapping("/v1/users")
@Tag(name = "User", description = "User APIs")
@RequiredArgsConstructor
public class UserController {

    private final UserKafkaProducer kafkaProducer;

    private final UserService userService;

    private final Faker faker = new Faker();

    @GetMapping("/random")
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Create a user", description = "Creates a random user and write it to Kafka which is consumed by the listener")
    public void generateRandomUser() {
        kafkaProducer.writeToKafka(new UserDTO(UUID.randomUUID().toString(), faker.name().firstName(), faker.name().lastName()));
    }

    @GetMapping("/{firstName}")
    @ResponseStatus
    @Operation(summary = "Create a user", description = "Returns a list of users that matchers the given name")
    public List<UserDTO> getUsers(@PathVariable(name = "firstName") String name) {
        List<User> users = userService.getUsers(name);
        return users.stream().map(user -> new UserDTO(user.getId(), user.getFirstName(), user.getLastName())).collect(toList());
    }

    @GetMapping
    @ResponseStatus
    @Operation(summary = "List all users", description = "Returns a list of users")
    public List<UserDTO> getAllUsers() {
        List<User> users = userService.getAllUsers();
        return users.stream().map(user -> new UserDTO(user.getId(), user.getFirstName(), user.getLastName())).collect(toList());
    }
}
