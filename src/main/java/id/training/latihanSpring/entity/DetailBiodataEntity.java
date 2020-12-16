package id.training.latihanSpring.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="biodata_detail")
public class DetailBiodataEntity {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private Integer id;
	
	@Column(name = "domisili", length = 50, nullable = false)
	private String domisili;
	
	@Column(name = "usia", length = 50, nullable = false)
	private Integer usia;
	
    @Column(name = "tanggal_lahir", length = 50, nullable = false)
	private Date ttl;
    
    @Column(name = "hoby", length = 50, nullable = false)
	private String hoby;
    
    @Column(name = "jenis_kelamin", length = 50, nullable = false)
	private String jk;

    @OneToOne
    @JoinColumn(name="person_id")
    private PersonEntity personEntity;	
    
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

	

	public PersonEntity getPersonEntity() {
		return personEntity;
	}

	public void setPersonEntity(PersonEntity personEntity) {
		this.personEntity = personEntity;
	}

	public DetailBiodataEntity(Integer id, String domisili, Integer usia, Date ttl, String hoby, String jk,
			PersonEntity personEntity) {
		super();
		this.id = id;
		this.domisili = domisili;
		this.usia = usia;
		this.ttl = ttl;
		this.hoby = hoby;
		this.jk = jk;
		this.personEntity = personEntity;
	}

	public DetailBiodataEntity() {
		super();
	}
}
