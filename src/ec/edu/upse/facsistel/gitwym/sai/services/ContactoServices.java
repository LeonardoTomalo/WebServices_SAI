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

import ec.edu.upse.facsistel.gitwym.sai.models.Contacto;
import ec.edu.upse.facsistel.gitwym.sai.repositories.ContactoRepository;

@Service
@RestController
@RequestMapping("/contacto")
public class ContactoServices {

	@Autowired private ContactoRepository repository;
	
	@PostMapping("/saveOrUpdate")
	public Contacto saveOrUpdate(@RequestBody Contacto c) {
		return repository.save(c);
	}
		
	@DeleteMapping("/deletePhysical/{c}")
	public void deletePhysical(@PathVariable String c) {
			repository.deleteById(c);
	}
	
	@DeleteMapping("/delete/{c}")
	public void deleteLogical(@PathVariable("c") String c) {	
		Optional<Contacto> o = repository.findById(c);
		if (o.isPresent()) {
			Contacto r = o.get();
			r.setEstado(false);
			repository.save(r);
		}
	}
	
	@GetMapping("/getAll")
	public List<Contacto> getAll() {
		return repository.findByEstadoIsTrue();
	}
}
