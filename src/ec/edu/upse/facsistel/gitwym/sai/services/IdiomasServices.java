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

import ec.edu.upse.facsistel.gitwym.sai.models.Idiomas;
import ec.edu.upse.facsistel.gitwym.sai.repositories.IdiomasRepository;

@Service
@RestController
@RequestMapping("/idiomas")
public class IdiomasServices {

	@Autowired private IdiomasRepository repository;
	
	@PostMapping("/saveOrUpdate")
	public Idiomas saveOrUpdate(@RequestBody Idiomas c) {
		return repository.save(c);
	}
		
	@DeleteMapping("/deletePhysical/{c}")
	public void deletePhysical(@PathVariable String c) {	
		repository.deleteById(c);
	}
		
	@GetMapping("/getAll")
	public List<Idiomas> getAll() {
		return (List<Idiomas>) repository.findAll();
	}
}
