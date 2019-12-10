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

import ec.edu.upse.facsistel.gitwym.sai.models.Recurso;
import ec.edu.upse.facsistel.gitwym.sai.repositories.RecursoRepository;


@Service
@RestController
@RequestMapping("/recurso")
public class RecursoServices {
	
	@Autowired private RecursoRepository recursoRepository;
	
	@PostMapping("/saveOrUpdate")
	public Recurso saveOrUpdate(@RequestBody Recurso r) {
		r.setEstado(true);
		return recursoRepository.save(r);
	}
		
	@DeleteMapping("/delete/{r}")
	public void deleteBusPhysical(@PathVariable Recurso r) {		
		if (recursoRepository.existsById(r.getId())) {
			r.setEstado(false);
			recursoRepository.save(r);
		}
	}
	
	@GetMapping("/getAll")
	public @ResponseBody List<Recurso> getAllRecursos() {
		return (List<Recurso>) recursoRepository.findAll();
	}
	
	@GetMapping("/get/{id}")
	public Optional<Recurso> getRecurdoId(@PathVariable String id) {
		return recursoRepository.findById(id);        
	}
}
