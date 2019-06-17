package foo.bar.toyrobotsimulator.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Collections;

@Configuration
@EnableSwagger2
public class SwaggerConfiguration {
    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.any())
                .build()
                .apiInfo(apiInfo());
    }

    private ApiInfo apiInfo() {
        return new ApiInfo(
                "Toy Robot Simulator",
                "'" +
                        "<b>Code problem details:</b>\n" +
                        "  <ul>\n" +
                        "    <li>\n" +
                        "      The application is a simulation of a toy robot moving con a square tabletop, of dimensions 5 x 5 units.\n" +
                        "    </li>\n" +
                        "  <li>\n" +
                        "    There are no other obstructions on the table surface.\n" +
                        "  </li>\n" +
                        "  <li>\n" +
                        "    The robot is free to roam around the surface of the table, but must be prevented from falling to destruction. Any movement that would result in the robot falling from the table must be prevented, however further valid movement commands must still be allowed.\n" +
                        "  </ul>" +
                        "'",
                "1.0.0",
                "To be defined",
                new Contact("Ledion Spaho", "https://www.linkedin.com/in/ledionspaho/", "ledion.spaho@yahoo.it"),
                "The Unlicense", "https://api.github.com/licenses/unlicense", Collections.emptyList());
    }
}
