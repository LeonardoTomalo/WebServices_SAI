package ec.edu.upse.facsistel.gitwym.sai.models;

import java.util.ArrayList;
import java.util.Date;

import org.springframework.data.couchbase.core.mapping.Document;
import org.springframework.data.couchbase.core.mapping.id.GeneratedValue;
import org.springframework.data.couchbase.core.mapping.id.GenerationStrategy;

import com.couchbase.client.java.repository.annotation.Field;
import com.couchbase.client.java.repository.annotation.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Leonardo Tomalo.
 **/

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document
public class MediaCloudResources {
	@Id @GeneratedValue(strategy = GenerationStrategy.UNIQUE) private String id;
	@Field private String nombre;
	@Field private String descripcion;
	@Field private String autor;
	@Field private Usuario usuarioIngresa;
	@Field private Date fecha;
	@Field private Boolean isPrincipal;
	@Field private Boolean isReportado;
	@Field private String coordenadas;
	@Field private String extensionFile;
	@Field private String urlAlmacenamiento;
	@Field private Boolean estado;
	@Field private ArrayList<String> idsEtiqueta;
	@Field private Ranking ranking;
	@Field private TipoMedia tipoMedia;
}
