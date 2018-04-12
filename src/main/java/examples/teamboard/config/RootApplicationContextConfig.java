package examples.teamboard.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Import(DBConfig.class)
@Configuration
@ComponentScan(basePackages = {"examples.teamboard.dao", "examples.teamboard.service"})
public class RootApplicationContextConfig {

}
