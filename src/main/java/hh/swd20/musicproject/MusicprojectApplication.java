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
import hh.swd20.musicproject.domain.Playlist;
import hh.swd20.musicproject.domain.PlaylistRepository;
import hh.swd20.musicproject.domain.Song;

@SpringBootApplication
public class MusicprojectApplication {
	private static final Logger log = (Logger) LoggerFactory.getLogger(MusicprojectApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(MusicprojectApplication.class, args);
	}

	@Bean
	public CommandLineRunner SongDemo(MusicRepository srepository, GenreRepository grepository,
			PlaylistRepository prepository) {
		return (args) -> {
			log.info("save new songs");
			log.info("save new genres");
			log.info("save new playlists");

			// saving playlists to repo

			Playlist playlist1 = new Playlist("Electronic music");
			prepository.save(playlist1);
			Playlist playlist2 = new Playlist("Hip hop music");
			prepository.save(playlist2);
			Playlist playlist3 = new Playlist("Pop music");
			prepository.save(playlist3);
			Playlist playlist4 = new Playlist("Rock music");
			prepository.save(playlist4);

			// saving genres to repo

			Genre genre1 = new Genre("Alternative rock");
			grepository.save(genre1);
			Genre genre2 = new Genre("Ambient");
			grepository.save(genre2);
			Genre genre3 = new Genre("Breakbeat");
			grepository.save(genre3);
			Genre genre4 = new Genre("Drum and bass");
			grepository.save(genre4);
			Genre genre5 = new Genre("Electro");
			grepository.save(genre5);
			Genre genre6 = new Genre("Hiphop");
			grepository.save(genre6);
			Genre genre7 = new Genre("House");
			grepository.save(genre7);
			Genre genre8 = new Genre("Jungle");
			grepository.save(genre8);
			Genre genre9 = new Genre("Pop");
			grepository.save(genre9);
			Genre genre10 = new Genre("Psychedelic rock");
			grepository.save(genre10);
			Genre genre11 = new Genre("Techno");
			grepository.save(genre11);

			// saving songs with genres and playlists to repo

			srepository.save(new Song("Numb", "Linkin Park", "Meteora", 2003, genre1, playlist4));
			srepository.save(new Song("#3", "Aphex Twin", "Selected Ambient Works Volume II", 1994, genre2, playlist1));
			srepository.save(new Song("Old Wives Tale", "Kessler", "Ambivalent", 2021, genre3, playlist1));
			srepository.save(new Song("Archangel", "Burial", "Untrue", 2007, genre2, playlist1));
			srepository.save(new Song("Starman", "David Bowie", "Ziggy Stardust", 1972, genre9, playlist3));
			srepository.save(new Song("Let It Happen", "Tame Impala", "Currents", 2015, genre10, playlist4));
			srepository.save(new Song("SAD!", "XXXTentacion", "?", 2018, genre6, playlist2));
			srepository.save(new Song("California Love", "2Pac", "All Eyez On Me", 1995, genre6, playlist2));
			srepository.save(new Song("Who Started Jungle", "Denham Audio", "To The Core", 2018, genre8, playlist1));
			srepository
					.save(new Song("Lost & Not Found", "Chase & Status", "Brand New Machine", 2013, genre4, playlist1));
			srepository.save(new Song("Still D.R.E.", "Dr Dre", "2001", 1999, genre6, playlist2));
			srepository.save(new Song("Feel Good Inc.", "Gorillaz", "Demon Days", 2005, genre1, playlist4));
			srepository.save(new Song("Light My Fire", "The Doors", "The Doors", 1967, genre10, playlist3));

			log.info("fetch all songs");
			for (Song song : srepository.findAll()) {
				log.info(song.toString());
			}

		};
	}
}
