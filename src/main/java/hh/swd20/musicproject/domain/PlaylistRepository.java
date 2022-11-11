package hh.swd20.musicproject.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface PlaylistRepository extends CrudRepository<Playlist, Long> {

	List<Playlist> findByplaylistName(String playlistName);

}
