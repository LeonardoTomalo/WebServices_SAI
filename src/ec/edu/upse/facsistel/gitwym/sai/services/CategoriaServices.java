package ec.edu.upse.facsistel.gitwym.sai.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import ec.edu.upse.facsistel.gitwym.sai.models.Categoria;
import ec.edu.upse.facsistel.gitwym.sai.repositories.CategoriaRepository;

@Service
@RestController
@RequestMapping("/categoria")
public class CategoriaServices {

	@Autowired private CategoriaRepository repository;
	
	@PostMapping("/saveOrUpdate")
	public Categoria saveOrUpdate(@RequestBody Categoria c) {
		return repository.save(c);
	}
		
	@DeleteMapping("/delete/{r}")
	public void deletePhysical(@PathVariable Categoria c) {		
		if (repository.existsById(c.getId())) {
			repository.delete(c);;
		}
	}
	
	@GetMapping("/getAll")
	public @ResponseBody List<Categoria> getAll() {
		return (List<Categoria>) repository.findAll();
	}
	
	@GetMapping("/get/{id}")
	public Optional<Categoria> getToId(@PathVariable String id) {
		return repository.findById(id);
	}
}
