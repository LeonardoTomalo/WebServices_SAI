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
import org.springframework.web.bind.annotation.RestController;

import ec.edu.upse.facsistel.gitwym.sai.models.Usuario;
import ec.edu.upse.facsistel.gitwym.sai.repositories.UsuarioRepository;

@Service
@RestController
@RequestMapping("/usuario")
public class UsuarioServices {

	@Autowired private UsuarioRepository repository;
	
	@PostMapping("/saveOrUpdate")
	public Usuario saveOrUpdate(@RequestBody Usuario c) {
		return repository.save(c);
	}
		
	@DeleteMapping("/deletePhysical/{c}")
	public void deletePhysical(@PathVariable String c) {	
			repository.deleteById(c);
	}
	
	@DeleteMapping("/delete/{c}")
	public void deleteLogical(@PathVariable("c") String c) {
		Optional<Usuario> opt = repository.findById(c);
		if (opt.isPresent()) {
			Usuario m = opt.get();
			m.setEstado(false);
			repository.save(m);
		}
	}
	
	@GetMapping("/getAll")
	public List<Usuario> getAll() {
		return repository.findByEstadoIsTrue();
	}
}
