package sk.bavaria.bavaria;


import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
@ComponentScan
@EnableWebMvc
public class MvcConfig extends WebMvcConfigurerAdapter {
    public MvcConfig() {
        super();
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
         registry.addResourceHandler("/resources/**").addResourceLocations("/", "/resources/", "classpath:/other-resources/");


    }
}
