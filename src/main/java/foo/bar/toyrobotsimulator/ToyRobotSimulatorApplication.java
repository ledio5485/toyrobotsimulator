package foo.bar.toyrobotsimulator;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties()
public class ToyRobotSimulatorApplication {

	public static void main(String[] args) {
		SpringApplication.run(ToyRobotSimulatorApplication.class, args);
	}

}
