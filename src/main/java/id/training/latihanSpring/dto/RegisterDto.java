package id.training.latihanSpring.dto;

import java.sql.Date;

import id.training.latihanSpring.entity.PersonEntity;

public class RegisterDto {
	private String firstname;
	private String lastname;
	private String domisili;
	private Integer umur;
	private Date ttl;
	private String hobby;
	private String jk;
	private Integer PersonId;
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getDomisili() {
		return domisili;
	}
	public void setDomisili(String domisili) {
		this.domisili = domisili;
	}
	public Integer getUmur() {
		return umur;
	}
	public void setUmur(Integer umur) {
		this.umur = umur;
	}
	public Date getTtl() {
		return ttl;
	}
	public void setTtl(Date ttl) {
		this.ttl = ttl;
	}
	public String getHobby() {
		return hobby;
	}
	public void setHobby(String hobby) {
		this.hobby = hobby;
	}
	public String getJk() {
		return jk;
	}
	public void setJk(String jk) {
		this.jk = jk;
	}
	

	public Integer getPersonId() {
		return PersonId;
	}
	public void setPersonId(Integer personId) {
		PersonId = personId;
	}
	public RegisterDto(String firstname, String lastname, String domisili, Integer umur, Date ttl, String hobby,
			String jk, Integer personId) {
		super();
		this.firstname = firstname;
		this.lastname = lastname;
		this.domisili = domisili;
		this.umur = umur;
		this.ttl = ttl;
		this.hobby = hobby;
		this.jk = jk;
		PersonId = personId;
	}
	public RegisterDto() {
		super();
	}
}
