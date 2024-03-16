package id.my.hendisantika.kafkatestsample.consumer;

import com.fasterxml.jackson.databind.ObjectMapper;
import id.my.hendisantika.kafkatestsample.dto.UserDTO;
import id.my.hendisantika.kafkatestsample.kafka.consumer.UserKafkaConsumer;
import id.my.hendisantika.kafkatestsample.service.UserService;
import org.apache.kafka.clients.producer.Producer;
import org.junit.jupiter.api.TestInstance;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.mock.mockito.SpyBean;
import org.springframework.kafka.test.EmbeddedKafkaBroker;
import org.springframework.kafka.test.context.EmbeddedKafka;

/**
 * Created by IntelliJ IDEA.
 * Project : spring-boot-kafka-test-sample
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 3/17/24
 * Time: 06:32
 * To change this template use File | Settings | File Templates.
 */
@EmbeddedKafka
@SpringBootTest(properties = "spring.kafka.bootstrap-servers=${spring.embedded.kafka.brokers}")
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class UserKafkaConsumerTest {

    private final String TOPIC_NAME = "com.madadipouya.kafka.user";
    @Captor
    ArgumentCaptor<UserDTO> userArgumentCaptor;
    @Captor
    ArgumentCaptor<String> topicArgumentCaptor;
    @Captor
    ArgumentCaptor<Integer> partitionArgumentCaptor;
    @Captor
    ArgumentCaptor<Long> offsetArgumentCaptor;
    private Producer<String, String> producer;
    @Autowired
    private EmbeddedKafkaBroker embeddedKafkaBroker;
    @Autowired
    private ObjectMapper objectMapper;
    @SpyBean
    private UserKafkaConsumer userKafkaConsumer;
    @MockBean
    private UserService userService;
}
