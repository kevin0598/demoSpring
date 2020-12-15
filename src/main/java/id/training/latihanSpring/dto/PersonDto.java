package id.training.latihanSpring.dto;

public class PersonDto {
 private Integer id;
 private String firstname;
 private String lastname;
public Integer getId() {
	return id;
}
public void setId(Integer id) {
	this.id = id;
}
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
public PersonDto(Integer id, String firstname, String lastname) {
	super();
	this.id = id;
	this.firstname = firstname;
	this.lastname = lastname;
}
public PersonDto() {
	super();
}
}
