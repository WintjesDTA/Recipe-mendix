package src;
import org.springframework.boot.*;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.hateoas.config.*;


@EnableEntityLinks
@EnableHypermediaSupport(type = org.springframework.hateoas.config.EnableHypermediaSupport.HypermediaType.HAL)
@SpringBootApplication
public class App {
	public static void main( String[] args )
    {
		SpringApplication.run(App.class, args);
    }
}
