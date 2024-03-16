package id.my.hendisantika.kafkatestsample.kafka.consumer;

import id.my.hendisantika.kafkatestsample.dto.UserDTO;
import id.my.hendisantika.kafkatestsample.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

/**
 * Created by IntelliJ IDEA.
 * Project : spring-boot-kafka-test-sample
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 3/17/24
 * Time: 06:08
 * To change this template use File | Settings | File Templates.
 */
@Component
@Slf4j
public class UserKafkaConsumer {

    private final UserService userService;

    public UserKafkaConsumer(UserService userService) {
        this.userService = userService;
    }

    @KafkaListener(topics = "${spring.kafka.topic.name}",
            concurrency = "${spring.kafka.consumer.level.concurrency:3}")
    public void logKafkaMessages(@Payload UserDTO user,
                                 @Header(KafkaHeaders.RECEIVED_TOPIC) String topic,
                                 @Header(KafkaHeaders.RECEIVED_PARTITION) Integer partition,
                                 @Header(KafkaHeaders.OFFSET) Long offset) {
        log.info("Received a message contains a user information with id {}, from {} topic, " +
                "{} partition, and {} offset", user.getUuid(), topic, partition, offset);
        userService.save(user);
    }
}
