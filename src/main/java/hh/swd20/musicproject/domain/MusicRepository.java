package hh.swd20.musicproject.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface MusicRepository extends CrudRepository<Song, Long> {

	List<Song> findByName(String name);

}
