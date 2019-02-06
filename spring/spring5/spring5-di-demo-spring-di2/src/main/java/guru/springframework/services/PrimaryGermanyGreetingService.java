package guru.springframework.services;

import guru.springframework.repositories.GreetingRepository;

import org.springframework.beans.factory.annotation.Autowired;

public class PrimaryGermanyGreetingService implements GreetingService {

    private GreetingRepository greetingRepository;

    @Autowired
    public void setGreetingRepository(GreetingRepository greetingRepository) {
        this.greetingRepository = greetingRepository;
    }

    @Override
    public String sayGreeting() {
        return greetingRepository.getGermanGreeting();
    }
}
