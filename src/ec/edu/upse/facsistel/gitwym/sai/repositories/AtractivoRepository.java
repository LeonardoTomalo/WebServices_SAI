package ec.edu.upse.facsistel.gitwym.sai.repositories;

import java.util.List;

import org.springframework.data.couchbase.core.query.N1qlPrimaryIndexed;
import org.springframework.data.couchbase.core.query.ViewIndexed;
import org.springframework.data.couchbase.repository.CouchbaseRepository;

import ec.edu.upse.facsistel.gitwym.sai.models.Atractivo;

@N1qlPrimaryIndexed
@ViewIndexed(designDoc = "atractivo", viewName = "all")
public interface AtractivoRepository extends CouchbaseRepository<Atractivo, String>{

	List<Atractivo> findByEstadoIsTrue();
}
