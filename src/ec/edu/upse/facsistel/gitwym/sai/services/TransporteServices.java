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

import ec.edu.upse.facsistel.gitwym.sai.models.Transporte;
import ec.edu.upse.facsistel.gitwym.sai.repositories.TransporteRepository;

@Service
@RestController
@RequestMapping("/transporte")
public class TransporteServices {

	@Autowired private TransporteRepository repository;
	
	@PostMapping("/saveOrUpdate")
	public Transporte saveOrUpdate(@RequestBody Transporte c) {
		return repository.save(c);
	}
		
	@DeleteMapping("/deletePhysical/{c}")
	public void deletePhysical(@PathVariable String c) {
			repository.deleteById(c);
	}
	
	@DeleteMapping("/delete/{c}")
	public void deleteLogical(@PathVariable("c") String c) {	
		Optional<Transporte> o = repository.findById(c);
		if (o.isPresent()) {
			Transporte r = o.get();
			r.setEstado(false);
			repository.save(r);
		}
	}
	
	@GetMapping("/getAll")
	public List<Transporte> getAll() {
		return repository.findByEstadoIsTrue();
	}
}
