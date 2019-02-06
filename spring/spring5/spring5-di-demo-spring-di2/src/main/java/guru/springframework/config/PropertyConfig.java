package guru.springframework.config;

import guru.springframework.examplebeans.FakeDataSource;
import guru.springframework.examplebeans.FakeJMSBroker;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PropertyConfig {

    @Value("${guru.username}")
    private String username;

    @Value("${guru.password}")
    private String password;

    @Value("${guru.url}")
    private String url;

    @Value("${guru.jms.username}")
    private String jmsUserName;

    @Value("${guru.jms.password}")
    private String jmsPassword;

    @Value("${guru.jms.url}")
    private String jmsUrl;

    @Bean
    public FakeDataSource fakeDataSource() {
        FakeDataSource fakeDataSource = new FakeDataSource();
        fakeDataSource.setUsername(username);
        fakeDataSource.setPassword(password);
        fakeDataSource.setUrl(url);
        return fakeDataSource;
    }

    @Bean
    public FakeJMSBroker fakeJMSBroker() {
        FakeJMSBroker jmsBroker = new FakeJMSBroker();
        jmsBroker.setUsername(jmsUserName);
        jmsBroker.setPassword(jmsPassword);
        jmsBroker.setUsername(jmsUrl);
        return jmsBroker;
    }
}
