package car2spring;

import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class HelloService {

    public String sayHello() {
        return "Üdvözlünk az oldalon! A látogatásod időpontja: " + LocalDateTime.now();
    }
}
