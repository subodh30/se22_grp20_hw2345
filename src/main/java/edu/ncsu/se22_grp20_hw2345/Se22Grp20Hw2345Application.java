package edu.ncsu.se22_grp20_hw2345;

import edu.ncsu.se22_grp20_hw2345.model.The;
import edu.ncsu.se22_grp20_hw2345.service.TheService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class Se22Grp20Hw2345Application implements CommandLineRunner {

	private final TheService theService;

	public Se22Grp20Hw2345Application(TheService theService) {
		this.theService = theService;
	}

	public static void main(String[] args) {
		SpringApplication.run(Se22Grp20Hw2345Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		theService.setThe(args);
	}
}
