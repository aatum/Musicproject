package hh.swd20.musicproject;

import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import ch.qos.logback.classic.Logger;
import hh.swd20.musicproject.domain.Genre;
import hh.swd20.musicproject.domain.GenreRepository;
import hh.swd20.musicproject.domain.MusicRepository;
import hh.swd20.musicproject.domain.Song;

@SpringBootApplication
public class MusicprojectApplication {
	private static final Logger log = (Logger) LoggerFactory.getLogger(MusicprojectApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(MusicprojectApplication.class, args);
	}

	@Bean
	public CommandLineRunner SongDemo(MusicRepository srepository, GenreRepository grepository) {
		return (args) -> {
			log.info("save new songs");
			log.info("save new genres");

			// tallennetaan genret repoon

			grepository.save(new Genre("Psychedelic rock"));
			grepository.save(new Genre("Alternative rock"));
			grepository.save(new Genre("Finnish music"));
			grepository.save(new Genre("Jungle"));
			grepository.save(new Genre("Drum and bass"));
			grepository.save(new Genre("Techno"));
			grepository.save(new Genre("Ambient"));
			grepository.save(new Genre("Electro"));
			grepository.save(new Genre("Breakbeat"));
			grepository.save(new Genre("House"));
			grepository.save(new Genre("Hip hop"));
			grepository.save(new Genre("Pop"));

			// tallenetaan laulut repoon

			srepository.save(new Song("Numb", "Linkin Park", "Meteora", 2003,
					grepository.findBygenreName("Alternative rock").get(0)));
			srepository.save(new Song("#3", "Aphex Twin", "Selected Ambient Works Volume II", 1994,
					grepository.findBygenreName("Ambient").get(0)));
			srepository.save(new Song("Archangel", "Burial", "Untrue", 2007,
					grepository.findBygenreName("Alternative rock").get(0)));
			log.info("fetch all songs");
			for (Song song : srepository.findAll()) {
				log.info(song.toString());
			}

		};
	}
}
