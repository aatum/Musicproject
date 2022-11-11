package hh.swd20.musicproject.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
public class Genre {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)

	// attributes
	private Long genreid;
	private String genreName;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "genre")
	@JsonIgnoreProperties("genre")
	private List<Song> songs;

	public Genre() {
	}

	// parameterized constructor
	public Genre(String genreName) {
		super();
		this.genreName = genreName;
	}

	// getters&setters

	public Long getGenreid() {
		return genreid;
	}

	public void setGenreid(Long genreid) {
		this.genreid = genreid;
	}

	public String getGenreName() {
		return genreName;
	}

	public void setGenreName(String genreName) {
		this.genreName = genreName;
	}

	public List<Song> getSongs() {
		return songs;
	}

	public void setSongs(List<Song> songs) {
		this.songs = songs;
	}

	@Override
	public String toString() {
		return "Genre [genreid=" + genreid + ", genreName=" + genreName + "]";
	}

}
