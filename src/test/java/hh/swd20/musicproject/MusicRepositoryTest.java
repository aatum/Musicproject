package hh.swd20.musicproject;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import hh.swd20.musicproject.domain.MusicRepository;
import hh.swd20.musicproject.domain.Song;

@ExtendWith(SpringExtension.class)
@DataJpaTest

public class MusicRepositoryTest {

	@Autowired
	private MusicRepository repository;

	@Test // testataan BookRepositoryn findByName()-metodia
	public void findByNameShouldReturnArtistName() {
		List<Song> songs = repository.findByName("Archangel");

		assertThat(songs).hasSize(1);
		assertThat(songs.get(0).getArtist()).isEqualTo("Burial");
	}

}
