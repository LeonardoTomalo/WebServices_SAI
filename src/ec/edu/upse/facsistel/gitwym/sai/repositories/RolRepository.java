package ec.edu.upse.facsistel.gitwym.sai.repositories;

import java.util.List;

import org.springframework.data.couchbase.core.query.N1qlPrimaryIndexed;
import org.springframework.data.couchbase.core.query.ViewIndexed;
import org.springframework.data.couchbase.repository.CouchbaseRepository;

import ec.edu.upse.facsistel.gitwym.sai.models.Rol;

@N1qlPrimaryIndexed
@ViewIndexed(designDoc = "rol", viewName = "all")
public interface RolRepository extends CouchbaseRepository<Rol, String>{
	
	List<Rol> findByEstadoIsTrue();
}
