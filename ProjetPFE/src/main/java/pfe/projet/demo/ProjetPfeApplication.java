package pfe.projet.demo;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import pfe.projet.demo.dao.UserRepository;
import pfe.projet.demo.entities.User;

@SpringBootApplication
@EnableJpaRepositories(basePackageClasses = UserRepository.class)
public class ProjetPfeApplication implements CommandLineRunner {
	@Autowired
	private UserRepository userRepository;

	public static void main(String[] args) {
		SpringApplication.run(ProjetPfeApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		DateFormat df=new SimpleDateFormat("dd/MM/yyyy");
		userRepository.save(new User("fer","fer","direc",df.parse("08/04/2018")));
		userRepository.findAll().forEach(c->{
			System.out.println(c.getLogin());
		});
		
	}
}
