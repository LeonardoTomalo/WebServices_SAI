package ec.edu.upse.facsistel.gitwym.sai.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ec.edu.upse.facsistel.gitwym.sai.models.Ranking;
import ec.edu.upse.facsistel.gitwym.sai.repositories.RankingRepository;

@Service
@RestController
@RequestMapping("/ranking")
public class RankingServices {

	@Autowired private RankingRepository repository;
	
	@PostMapping("/saveOrUpdate")
	public Ranking saveOrUpdate(@RequestBody Ranking c) {
		return repository.save(c);
	}
		
	@DeleteMapping("/deletePhysical/{c}")
	public void deletePhysical(@PathVariable String c) {	
		repository.deleteById(c);
	}
		
	@GetMapping("/getAll")
	public List<Ranking> getAll() {
		return (List<Ranking>) repository.findAll();
	}
}
