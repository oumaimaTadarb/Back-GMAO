package org.gmaoback.gmaomondi_backend;
import jakarta.transaction.Transactional;
import org.gmaoback.gmaomondi_backend.dao.entities.Famille;
import org.gmaoback.gmaomondi_backend.dao.repositories.FamilleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
@SpringBootApplication

public class GmaoMondiBackendApplication {
	@Autowired
	private FamilleRepository familleRepository;

	public static void main(String[] args) {
		SpringApplication.run(GmaoMondiBackendApplication.class, args);}
	@Bean
	public CommandLineRunner setupFamilleRacine() {
		return args -> {setupRacine();};
	}
	@Transactional
	public void setupRacine() {
		String racineName = "Famille Racine";
		Famille familleRacine = familleRepository.findByName(racineName);
		if (familleRacine == null) {
			Famille newFamilleRacine = Famille.builder()
					.name(racineName)
					.build();
			familleRepository.save(newFamilleRacine);
		}
	}

}