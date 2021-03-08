package lv.javaguru.crm.domain;

import javax.persistence.Entity;


@Entity
public class SystemUser extends BaseEntity {

	private Long id;

	private String login;

	private String password;



}
