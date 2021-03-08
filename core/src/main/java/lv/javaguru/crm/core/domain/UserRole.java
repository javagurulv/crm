package lv.javaguru.crm.core.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import java.util.Objects;

@Entity
@Table(name = "system_user_roles")
public class UserRole extends BaseEntity {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne
	@JoinColumn(name="system_user_id", nullable = false)
	private SystemUser systemUser;

	@Enumerated(EnumType.STRING)
	@Column(name = "system_module", nullable = false)
	private SystemModule systemModule;

	@Enumerated(EnumType.STRING)
	@Column(name = "system_role", nullable = false)
	private SystemRole systemRole;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public SystemUser getSystemUser() {
		return systemUser;
	}

	public void setSystemUser(SystemUser systemUser) {
		this.systemUser = systemUser;
	}

	public SystemModule getSystemModule() {
		return systemModule;
	}

	public void setSystemModule(SystemModule systemModule) {
		this.systemModule = systemModule;
	}

	public SystemRole getSystemRole() {
		return systemRole;
	}

	public void setSystemRole(SystemRole systemRole) {
		this.systemRole = systemRole;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		UserRole userRole = (UserRole) o;
		return Objects.equals(id, userRole.id) && Objects.equals(systemUser, userRole.systemUser)
				&& systemModule == userRole.systemModule && systemRole == userRole.systemRole;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, systemUser, systemModule, systemRole);
	}
}
