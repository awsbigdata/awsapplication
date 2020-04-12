package software.awssupport.webapp;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class SimpleServiceApplication {
    private static Log LOG = LogFactory.getLog(SimpleServiceApplication.class);


    public static void main(String[] args) {
        SpringApplication.run(SimpleServiceApplication.class, args);
    }
}
