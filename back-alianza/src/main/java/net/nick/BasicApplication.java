package net.nick;


import java.util.Date;
import net.nick.model.User;
import net.nick.repositories.UserRepository;
import java.util.stream.Stream;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;


@SpringBootApplication
public class BasicApplication {

    static final Logger log =
        LoggerFactory.getLogger(BasicApplication.class);
    
	public static void main(String[] args) {
		SpringApplication.run(BasicApplication.class, args);
	}
        
    @Bean
    CommandLineRunner init(UserRepository userRepository) {
        return args -> {
            Stream.of("Nick Cobos", "Valerie Cobos", "Kelberos", "Tiger", "Kevin Cobos").forEach(name -> {                
                Date date = new Date(); 
                User user = new User(genSKey(name), name, genSKey(name)+"@gmail.com", date);
                userRepository.save(user);
            });
            userRepository.findAll().forEach(System.out::println);
        };
    }
    
    public String genSKey(String name)
    {
        String sKey;
        sKey = name.toLowerCase();
        sKey = sKey.replaceAll("\\s+","");
        return sKey;
    }
}
