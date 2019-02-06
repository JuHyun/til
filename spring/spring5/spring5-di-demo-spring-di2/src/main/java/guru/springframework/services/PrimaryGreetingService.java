package guru.springframework.services;

import guru.springframework.repositories.GreetingRepository;

import org.springframework.beans.factory.annotation.Autowired;

public class PrimaryGreetingService implements GreetingService {

    @Autowired
    private GreetingRepository greetingRepository;

    @Override
    public String sayGreeting() {
        return greetingRepository.getEnglishGreeting();
    }
}
