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
public class Playlist {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)

	// attributes
	private Long playlistid;
	private String playlistName;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "playlist")
	@JsonIgnoreProperties("playlist")
	private List<Song> songs;

	public Playlist() {
	}

	// parameterized constructor
	public Playlist(String playlistName) {
		super();
		this.playlistName = playlistName;
	}

	// getters&setters

	public Long getPlaylistid() {
		return playlistid;
	}

	public void setPlaylistid(Long playlistid) {
		this.playlistid = playlistid;
	}

	public String getPlaylistName() {
		return playlistName;
	}

	public void setPlaylistName(String playlistName) {
		this.playlistName = playlistName;
	}

	public List<Song> getSongs() {
		return songs;
	}

	public void setSongs(List<Song> songs) {
		this.songs = songs;
	}

	@Override
	public String toString() {
		return "Playlist [playlistid=" + playlistid + ", playlistName=" + playlistName + "]";
	}

}
