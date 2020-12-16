package id.training.latihanSpring.dto;

public class PendidikanDto {
	private String level;
	private String institusi;
	private Integer masuk;
	private Integer lulus;
	private Integer personid;
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
	public Integer getPersonid() {
		return personid;
	}
	public void setPersonid(Integer personid) {
		this.personid = personid;
	}

	public Integer getMasuk() {
		return masuk;
	}
	public void setMasuk(Integer masuk) {
		this.masuk = masuk;
	}
	public Integer getLulus() {
		return lulus;
	}
	public void setLulus(Integer lulus) {
		this.lulus = lulus;
	}
	public PendidikanDto(String level, String institusi, Integer masuk, Integer lulus, Integer personid) {
		super();
		this.level = level;
		this.institusi = institusi;
		this.masuk = masuk;
		this.lulus = lulus;
		this.personid = personid;
	}
	public PendidikanDto() {
		super();
	}
}
