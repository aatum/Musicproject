package hh.swd20.musicproject.web;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import hh.swd20.musicproject.domain.GenreRepository;
import hh.swd20.musicproject.domain.MusicRepository;
import hh.swd20.musicproject.domain.Song;

@CrossOrigin
@Controller
public class MusicController {

	@Autowired
	private MusicRepository repository;

	@Autowired
	private GenreRepository grepository;

	@RequestMapping(value = "/songlist", method = RequestMethod.GET)

	public String getSongs(Model model) {
		model.addAttribute("songs", repository.findAll());
		return "songlist";
	}

	// get all songs with REST
	@RequestMapping(value = "/songs", method = RequestMethod.GET)
	public @ResponseBody List<Song> songListRest() {
		return (List<Song>) repository.findAll();
	}

	// get id with REST
	@RequestMapping(value = "/songs/{id}", method = RequestMethod.GET)
	public @ResponseBody Optional<Song> findSongRest(@PathVariable("id") Long songId) {
		return repository.findById(songId);
	}

	// save new song
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.POST)
	public @ResponseBody Song saveSongRest(@PathVariable("id") Song song) {
		return repository.save(song);
	}

	// delete song
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	public String deleteSong(@PathVariable("id") Long songId, Model model) {
		repository.deleteById(songId);
		return "redirect:../songlist";
	}

	// add new song
	@RequestMapping(value = "/add")
	public String addSong(Model model) {
		model.addAttribute("song", new Song());
		model.addAttribute("genres", grepository.findAll());
		return "addsong";
	}

	// save song to database
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String save(Song song) {
		repository.save(song);
		return "redirect:songlist";
	}

	// edit songform

	@RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
	public String editSong(@PathVariable("id") Long songId, Model model) {
		model.addAttribute("book", repository.findById(songId));
		model.addAttribute("categories", grepository.findAll());
		return "editsong";
	}
}
