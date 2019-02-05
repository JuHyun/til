package guru.springframework.services;

import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Primary
@Profile("de")
public class PrimaryGermanyGreetingService implements GreetingService {

    @Override
    public String sayGreeting() {
        return "Guten Morgen!";
    }
}
