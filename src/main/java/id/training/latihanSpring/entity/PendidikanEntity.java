package id.training.latihanSpring.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="pendidikan")
public class PendidikanEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private Integer id;
	
	@Column(name="level", length = 50,nullable = false)
	private String level;
	
	@Column(name="institusi", length = 50,nullable = false)
	private String institusi;
	
	@Column(name="Tahun_Masuk", length = 50,nullable = false)	
	private Integer TahunMasuk;
	
	@Column(name="Tahun_Lulus", length = 50,nullable = false)
	private Integer TahunLulus;
	
	@ManyToOne
	@JoinColumn(name="person_id")
	private PersonEntity personEntities;

	public PersonEntity getPersonEntities() {
		return personEntities;
	}

	public void setPersonEntities(PersonEntity personEntities) {
		this.personEntities = personEntities;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getLevel() {
		return level;
	}

	public void setLevel(String level) {
		this.level = level;
	}

	public String getInstitusi() {
		return institusi;
	}

	public void setInstitusi(String institusi) {
		this.institusi = institusi;
	}

	public Integer getTahunMasuk() {
		return TahunMasuk;
	}

	public void setTahunMasuk(Integer tahunMasuk) {
		TahunMasuk = tahunMasuk;
	}

	public Integer getTahunLulus() {
		return TahunLulus;
	}

	public void setTahunLulus(Integer tahunLulus) {
		TahunLulus = tahunLulus;
	}


	public PendidikanEntity(Integer id, String level, String institusi, Integer tahunMasuk, Integer tahunLulus,
			PersonEntity personEntities) {
		super();
		this.id = id;
		this.level = level;
		this.institusi = institusi;
		TahunMasuk = tahunMasuk;
		TahunLulus = tahunLulus;
		this.personEntities = personEntities;
	}

	public PendidikanEntity() {
		super();
	}
}
