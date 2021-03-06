package dev.galasa.scheduler.jpa;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Version;

@Entity
@Table(name = "app")
public class AppEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "id", length = 10)
	private String id;
	
	@Lob
	@Column(name = "configuration")
	private String configuration;
	
	@OneToMany(mappedBy = "app", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<LevelEntity> levels;
	
	@Version
	private long version;
	
	public AppEntity() {
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getConfiguration() {
		return configuration;
	}

	public void setConfiguration(String configuration) {
		this.configuration = configuration;
	}
	
	public List<LevelEntity> getLevels() {
		return this.levels;
	}
	
	public void addLevel(LevelEntity level) {
		this.levels.add(level);
	}
}
