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

import ec.edu.upse.facsistel.gitwym.sai.models.Rol;
import ec.edu.upse.facsistel.gitwym.sai.repositories.RolRepository;

@Service
@RestController
@RequestMapping("/rol")
public class RolServices {

	@Autowired private RolRepository repository;
	
	@PostMapping("/saveOrUpdate")
	public Rol saveOrUpdate(@RequestBody Rol c) {
		return repository.save(c);
	}
		
	@DeleteMapping("/deletePhysical/{c}")
	public void deletePhysical(@PathVariable Rol c) {		
		if (repository.existsById(c.getId())) {
			repository.delete(c);
		}
	}
	
	@DeleteMapping("/delete/{c}")
	public void deleteLogical(@PathVariable("c") Rol c) {		
		if (repository.existsById(c.getId())) {
			c.setEstado(false);
			repository.save(c);
		}
	}
	
	@GetMapping("/getAll")
	public List<Rol> getAll() {
		return repository.findByEstadoIsTrue();
	}
	
//	@GetMapping("/toId/{id}")
//	public Optional<Rol> getToId(@PathVariable String id) {
//		return repository.findById(id);
//	}
}
