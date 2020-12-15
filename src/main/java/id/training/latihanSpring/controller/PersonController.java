package id.training.latihanSpring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import id.training.latihanSpring.dto.DetailBiodataDto;
import id.training.latihanSpring.dto.PersonDto;
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
}
