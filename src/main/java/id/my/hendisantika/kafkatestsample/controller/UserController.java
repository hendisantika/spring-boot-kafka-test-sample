package id.my.hendisantika.kafkatestsample.controller;

import com.github.javafaker.Faker;
import id.my.hendisantika.kafkatestsample.kafka.producer.UserKafkaProducer;
import id.my.hendisantika.kafkatestsample.service.UserService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

    private final Faker faker;
}
