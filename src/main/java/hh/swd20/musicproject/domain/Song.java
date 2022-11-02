package hh.swd20.musicproject.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
public class Song {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)

	// attribuutit

	private Long id;
	private String name;
	private String artist;
	private String album;
	@Column(name = "publishing_year")
	private int year;

	@ManyToOne
	@JsonIgnoreProperties("songs")
	@JoinColumn(name = "genreid")
	private Genre genre;

	public Song() {

	}

	// konstruktorit

	// parametrillinen

	public Song(String name, String artist, String album, int year, Genre genre) {
		super();
		this.name = name;
		this.artist = artist;
		this.album = album;
		this.year = year;
		this.genre = genre;
	}

	// getterit&setterit

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getArtist() {
		return artist;
	}

	public void setArtist(String artist) {
		this.artist = artist;
	}

	public String getAlbum() {
		return album;
	}

	public void setAlbum(String album) {
		this.album = album;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public Genre getGenre() {
		return genre;
	}

	public void setGenre(Genre genre) {
		this.genre = genre;
	}

	@Override
	public String toString() {
		if (this.genre != null)
			return "Song [id=" + id + ", name=" + name + ", artist=" + artist + ", album=" + album + ", year=" + year
					+ " genre =" + this.getGenre() + "]";
		else
			return "Song [id=" + id + ", name=" + name + ", artist=" + artist + ", album=" + album + ", year=" + year
					+ "]";

	}

}
