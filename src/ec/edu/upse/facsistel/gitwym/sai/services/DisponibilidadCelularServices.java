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

import ec.edu.upse.facsistel.gitwym.sai.models.DisponibilidadCelular;
import ec.edu.upse.facsistel.gitwym.sai.repositories.DisponibilidadCelularRepository;

@Service
@RestController
@RequestMapping("/disponibilidadCelular")
public class DisponibilidadCelularServices {

	@Autowired private DisponibilidadCelularRepository repository;
	
	@PostMapping("/saveOrUpdate")
	public DisponibilidadCelular saveOrUpdate(@RequestBody DisponibilidadCelular c) {
		return repository.save(c);
	}
		
	@DeleteMapping("/deletePhysical/{c}")
	public void deletePhysical(@PathVariable String c) {
			repository.deleteById(c);
	}
	
	@GetMapping("/getAll")
	public List<DisponibilidadCelular> getAll() {
		return (List<DisponibilidadCelular>) repository.findAll();
	}
}
