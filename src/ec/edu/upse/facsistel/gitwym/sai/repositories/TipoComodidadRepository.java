package ec.edu.upse.facsistel.gitwym.sai.repositories;

import org.springframework.data.couchbase.core.query.N1qlPrimaryIndexed;
import org.springframework.data.couchbase.core.query.ViewIndexed;
import org.springframework.data.couchbase.repository.CouchbaseRepository;

import ec.edu.upse.facsistel.gitwym.sai.models.TipoComodidad;

@N1qlPrimaryIndexed
@ViewIndexed(designDoc = "tipoComodidad", viewName = "all")
public interface TipoComodidadRepository extends CouchbaseRepository<TipoComodidad, String>{

}
