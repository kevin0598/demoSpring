package id.training.latihanSpring.dto;

import java.sql.Date;

public class DetailBiodataDto {
	private Integer id;
	private String domisili;
	private Integer usia;
	private Date ttl;
	private String hoby;
	private String jk;
	private Integer personId;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getDomisili() {
		return domisili;
	}
	public void setDomisili(String domisili) {
		this.domisili = domisili;
	}
	public Integer getUsia() {
		return usia;
	}
	public void setUsia(Integer usia) {
		this.usia = usia;
	}
	public Date getTtl() {
		return ttl;
	}
	public void setTtl(Date ttl) {
		this.ttl = ttl;
	}
	public String getHoby() {
		return hoby;
	}
	public void setHoby(String hoby) {
		this.hoby = hoby;
	}
	public String getJk() {
		return jk;
	}
	public void setJk(String jk) {
		this.jk = jk;
	}
	
	public Integer getPersonId() {
		return personId;
	}
	public void setPersonId(Integer personId) {
		this.personId = personId;
	}
	public DetailBiodataDto(Integer id, String domisili, Integer usia, Date ttl, String hoby, String jk,
			Integer personId) {
		super();
		this.id = id;
		this.domisili = domisili;
		this.usia = usia;
		this.ttl = ttl;
		this.hoby = hoby;
		this.jk = jk;
		this.personId = personId;
	}
	public DetailBiodataDto() {
		super();
	}

}
