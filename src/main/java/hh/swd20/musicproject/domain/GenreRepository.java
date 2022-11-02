package hh.swd20.musicproject.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface GenreRepository extends CrudRepository<Genre, Long> {

	List<Genre> findBygenreName(String genreName);

}
