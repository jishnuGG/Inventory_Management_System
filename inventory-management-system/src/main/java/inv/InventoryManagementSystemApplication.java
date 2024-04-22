package inv;
import org.slf4j.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class InventoryManagementSystemApplication {
    private static final Logger log = LoggerFactory.getLogger(InventoryManagementSystemApplication.class);
	public static void main(String[] args) {

		SpringApplication.run(InventoryManagementSystemApplication.class, args);
	}

}
