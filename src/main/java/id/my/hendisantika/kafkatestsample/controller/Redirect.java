package id.my.hendisantika.kafkatestsample.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by IntelliJ IDEA.
 * Project : spring-boot-kafka-test-sample
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 3/17/24
 * Time: 06:09
 * To change this template use File | Settings | File Templates.
 */
@RestController
public class Redirect {

    @GetMapping(value = {"/api-docs", "/swagger-ui.html"})
    public ModelAndView redirectToApiPage() {
        return new ModelAndView("redirect:/swagger-ui/index.html");
    }
}
