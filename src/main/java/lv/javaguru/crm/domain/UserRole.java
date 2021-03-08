package lv.javaguru.crm.domain;

import javax.persistence.Entity;

@Entity
public class UserRole extends BaseEntity {

	private Long id;

	private SystemUser systemUser;

	private SystemRole systemRole;

}
