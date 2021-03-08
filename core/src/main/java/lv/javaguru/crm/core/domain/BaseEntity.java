package lv.javaguru.crm.core.domain;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Version;

import java.util.Date;

@MappedSuperclass
public abstract class BaseEntity {

	@Version
	@Column(name = "version")
	private Integer version;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "created_date")
	private Date created;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "updated_date")
	private Date updated;

	@PrePersist
	protected void onCreate() {
		created = new Date();
	}

	@PreUpdate
	protected void onUpdate() {
		updated = new Date();
	}
}