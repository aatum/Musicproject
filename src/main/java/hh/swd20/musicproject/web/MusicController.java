package hh.swd20.musicproject.web;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import hh.swd20.musicproject.domain.GenreRepository;
import hh.swd20.musicproject.domain.MusicRepository;
import hh.swd20.musicproject.domain.PlaylistRepository;
import hh.swd20.musicproject.domain.Song;

@CrossOrigin
@Controller
public class MusicController {

	@Autowired
	private MusicRepository repository;

	@Autowired
	private GenreRepository grepository;

	@Autowired
	private PlaylistRepository prepository;

	// get all songs as a table
	@RequestMapping(value = "/songlist", method = RequestMethod.GET)
	public String getSongs(Model model) {
		model.addAttribute("songs", repository.findAll());
		return "songlist";
	}

	// homepage
	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public String homepage(Model model) {
		return "homepage";

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
		model.addAttribute("song", repository.findById(songId));
		model.addAttribute("genres", grepository.findAll());
		return "editsong";
	}

	// go to playlist menu

	@RequestMapping(value = "/playlist")
	public String getplaylists(Model model) {
		model.addAttribute("songs", repository.findAll());
		return "playlist";
	}

	// add song to playlist
	@Secured("ADMIN")
	@RequestMapping("/addtoplaylist/{id}")
	public String addtoPlaylist(@PathVariable("id") Long songId, Model model) {
		model.addAttribute("song", repository.findById(songId));
		model.addAttribute("playlists", prepository.findAll());
		return "addsongtoplaylist";
	}

	// save to playlist
	@RequestMapping(value = "/savetoplaylist", method = RequestMethod.GET)
	public String saveToPlaylist(Song formSong) {
		Optional<Song> dbSong = repository.findById(formSong.getId());
//		System.out.print("jee");
		// eli pitää hakee idl se biisi ja päivittää sen soittolistatietoon mihi listaa
		// laitetaa?
		// atm redirectaa addtoplaylist/savetoplaylist
		// ennen savea hae tietokannasta lomakkeelta tulleen songIdn avulla laulun
		// nykyiset tiedot ja sitten
		// päivitä tietokannasta haetun laulu-olion playlist-tieto lomakkeelta tulleen
		// laulun playlist-tiedolla
		// repository.save(dbSong);
		return "redirect:../playlist";
	}

	// errorpage
	@GetMapping("/error")
	public String errorpage(Model model) {
		return "error";
	}

}
