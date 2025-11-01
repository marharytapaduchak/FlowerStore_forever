package ucu.edu.ua.lab7;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.TimeZone;


@SpringBootApplication
@RestController
public class DemoApplication {

	public static void main(String[] args) {
		TimeZone.setDefault(TimeZone.getTimeZone("Europe/Kyiv"));
		SpringApplication.run(DemoApplication.class, args);
	}

	@GetMapping("/ping")
    public String ping() {
        return "ok";
    }
}
