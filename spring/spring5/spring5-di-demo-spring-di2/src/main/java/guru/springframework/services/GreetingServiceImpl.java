package guru.springframework.services;

import org.springframework.stereotype.Service;

@Service
public class GreetingServiceImpl implements GreetingService {

    public static final String GREETING = "Hello Gurus!!!! - original";

    @Override
    public String sayGreeting() {
        return GREETING;
    }
}
