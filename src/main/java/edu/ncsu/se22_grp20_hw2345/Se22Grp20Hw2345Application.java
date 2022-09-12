package edu.ncsu.se22_grp20_hw2345;

import edu.ncsu.se22_grp20_hw2345.model.The;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class Se22Grp20Hw2345Application implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(Se22Grp20Hw2345Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		The.setThe(args);
	}
}
