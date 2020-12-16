package id.training.latihanSpring.controller;

import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import id.training.latihanSpring.dto.DetailBiodataDto;
import id.training.latihanSpring.dto.PersonDto;
import id.training.latihanSpring.dto.RegisterDto;
import id.training.latihanSpring.entity.DetailBiodataEntity;
import id.training.latihanSpring.entity.PersonEntity;
import id.training.latihanSpring.repository.DetailBioadataRepository;
import id.training.latihanSpring.repository.PersonRepository;

@RestController
@RequestMapping("/person")
public class PersonController {
	@Autowired
	private PersonRepository repository;
	
	@Autowired
	private DetailBioadataRepository repository2;
	
	@GetMapping("/get-all")
	public List<PersonEntity> getPerson(){
		List<PersonEntity> personEntity= repository.findAll();
//		repository.findByFirstName("");
		return personEntity;
	}
	
	@GetMapping("/respon-entity")
	public ResponseEntity<?> getAll(){
		List<PersonEntity> personEntities = repository.findAll();
		return ResponseEntity.ok(personEntities);
	}
	
	@PostMapping("/post-person")
	public ResponseEntity<?> post(@RequestBody PersonDto Dto) {
		PersonEntity personEntity = new PersonEntity();
		personEntity.setFirstname(Dto.getFirstname());
		personEntity.setLastname(Dto.getLastname());
		repository.save(personEntity);
		return ResponseEntity.ok(personEntity);
	}
	
	@PutMapping("/person-update/{id}")
	public ResponseEntity<?> update(@PathVariable Integer id,@RequestBody PersonDto Dto){
		PersonEntity personEntity = repository.findById(id).get();
		personEntity.setFirstname(Dto.getFirstname());
		personEntity.setLastname(Dto.getLastname());
		repository.save(personEntity);
		return ResponseEntity.ok(personEntity);
	}
	
	@DeleteMapping("/delete-person/{id}")
	public ResponseEntity<?> delete(@PathVariable Integer id){
		PersonEntity personEntity = repository.findById(id).get();	
		repository.delete(personEntity);		
		return ResponseEntity.ok(personEntity);
	}
	
	@GetMapping("/delete/{id}")
	public ResponseEntity<?> delete2(@PathVariable Integer id){
		PersonEntity personEntity = repository.findById(id).get();	
		repository.delete(personEntity);		
		return ResponseEntity.ok(personEntity);
	}
	
	@GetMapping("/firstname-by-id/{id}")
	public ResponseEntity<?> getFirst(@PathVariable Integer id){
		PersonEntity personEntity =new PersonEntity();
		personEntity.setFirstname(repository.findFirstnamebyId(id));
		return ResponseEntity.ok(personEntity.getFirstname());
	}
	
	@GetMapping("/detail-biodata")
	public ResponseEntity<?> getDetail(){
		List<DetailBiodataEntity> detailBiodataEntities=repository2.findAll();
		return ResponseEntity.ok(detailBiodataEntities);
	}
	
	@PostMapping("/post-detail")
	public ResponseEntity<?> post2(@RequestBody DetailBiodataDto Dto){
		DetailBiodataEntity detailBiodataEntity=new DetailBiodataEntity();
		detailBiodataEntity.setDomisili(Dto.getDomisili());
		detailBiodataEntity.setHoby(Dto.getHoby());
		detailBiodataEntity.setJk(Dto.getJk());
		detailBiodataEntity.setTtl(Dto.getTtl());
		detailBiodataEntity.setUsia(Dto.getUsia());
		repository2.save(detailBiodataEntity);
		return ResponseEntity.ok(detailBiodataEntity);
	}
	
	@GetMapping("/get-domisili/{id}")
	public ResponseEntity<?> getDomisili(@PathVariable Integer id){		
		DetailBiodataEntity detailBiodataEntity=new DetailBiodataEntity();
		detailBiodataEntity.setDomisili(repository2.findDomisilibyId(id));
		return ResponseEntity.ok(detailBiodataEntity.getDomisili());
	}
	
	@PostMapping("/post-detail-person")
	public ResponseEntity<?> post3(@RequestBody DetailBiodataDto Dto){
		DetailBiodataEntity detailBiodataEntity=new DetailBiodataEntity();
		PersonEntity personEntity=repository.findById(Dto.getPersonId()).get();
		detailBiodataEntity.setDomisili(Dto.getDomisili());
		detailBiodataEntity.setHoby(Dto.getHoby());
		detailBiodataEntity.setJk(Dto.getJk());
		detailBiodataEntity.setTtl(Dto.getTtl());
		detailBiodataEntity.setUsia(Dto.getUsia());
		detailBiodataEntity.setPersonEntity(personEntity);
		repository2.save(detailBiodataEntity);
		return ResponseEntity.ok(detailBiodataEntity);
	}
	
	@PostMapping("/insert-all")
	public ResponseEntity<?> insertall(@RequestBody RegisterDto Dto){
		PersonEntity personEntity=convertToPersonEntity(Dto);
		DetailBiodataEntity detailBiodataEntity=convertToBiodataEntity(Dto);
				
		repository.save(personEntity);
		
		detailBiodataEntity.setPersonEntity(personEntity);
		repository2.save(detailBiodataEntity);
		return ResponseEntity.ok(detailBiodataEntity);
	}
	
	public PersonEntity convertToPersonEntity(RegisterDto Dto) {
		PersonEntity personEntity=new PersonEntity();
		
		personEntity.setFirstname(Dto.getFirstname());
		personEntity.setLastname(Dto.getLastname());
		return personEntity;
	}
	
	public DetailBiodataEntity convertToBiodataEntity(RegisterDto Dto) {
		DetailBiodataEntity detailBiodataEntity=new DetailBiodataEntity();	
		
		detailBiodataEntity.setDomisili(Dto.getDomisili());
		detailBiodataEntity.setHoby(Dto.getHobby());
		detailBiodataEntity.setJk(Dto.getJk());
		detailBiodataEntity.setTtl(Dto.getTtl());		
		detailBiodataEntity.setUsia(Dto.getUmur());
		repository2.save(detailBiodataEntity);
		return detailBiodataEntity;
	}
}
