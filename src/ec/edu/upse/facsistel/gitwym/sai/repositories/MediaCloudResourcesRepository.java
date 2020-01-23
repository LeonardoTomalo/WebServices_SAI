package ec.edu.upse.facsistel.gitwym.sai.repositories;

import java.util.List;

import org.springframework.data.couchbase.core.query.N1qlPrimaryIndexed;
import org.springframework.data.couchbase.core.query.ViewIndexed;
import org.springframework.data.couchbase.repository.CouchbaseRepository;

import ec.edu.upse.facsistel.gitwym.sai.models.MediaCloudResources;

@N1qlPrimaryIndexed
@ViewIndexed(designDoc = "mediaCloudResources", viewName = "all")
public interface MediaCloudResourcesRepository extends CouchbaseRepository<MediaCloudResources, String>{

	List<MediaCloudResources> findByEstadoIsTrue();
}
