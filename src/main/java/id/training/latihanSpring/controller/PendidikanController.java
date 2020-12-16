package id.training.latihanSpring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import id.training.latihanSpring.dto.PendidikanDto;
import id.training.latihanSpring.entity.PendidikanEntity;
import id.training.latihanSpring.entity.PersonEntity;
import id.training.latihanSpring.repository.PendidikanRepository;
import id.training.latihanSpring.repository.PersonRepository;

@RestController
@RequestMapping("/pendidikan")
public class PendidikanController {
	@Autowired
	private PersonRepository repository;
	
	@Autowired
	PendidikanRepository pendidikanRepository;
	
	@GetMapping("/get-all")
	public ResponseEntity<?> getAll(){
		List<PendidikanEntity> pendidikanEntities=pendidikanRepository.findAll();
		return ResponseEntity.ok(pendidikanEntities);
	}
	
	@PostMapping("/insert-pendidikan")
	public ResponseEntity<?> InsertAll(@RequestBody PendidikanDto Dto){
		PendidikanEntity pendidikanEntity=converToPendidikanEntity(Dto);
		PersonEntity personEntity=repository.findById(Dto.getPersonid()).get();
		pendidikanEntity.setPersonEntities(personEntity);
		pendidikanRepository.save(pendidikanEntity);				
		return ResponseEntity.ok(pendidikanEntity);
	}	
	
	@PutMapping("/update-pendidikan/{id}")
	public ResponseEntity<?> update(@PathVariable Integer id,@RequestBody PendidikanDto Dto){
		PendidikanEntity pendidikanEntity=pendidikanRepository.findById(id).get();
		pendidikanEntity.setInstitusi(Dto.getInstitusi());
		pendidikanEntity.setLevel(Dto.getLevel());
		pendidikanEntity.setTahunMasuk(Dto.getMasuk());
		pendidikanEntity.setTahunLulus(Dto.getLulus());
		pendidikanRepository.save(pendidikanEntity);
		return ResponseEntity.ok(pendidikanEntity);		
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> delete(@PathVariable Integer id){
		PendidikanEntity pendidikanEntity=pendidikanRepository.findById(id).get();
		pendidikanRepository.delete(pendidikanEntity);
		return ResponseEntity.ok(pendidikanEntity);
	}
	
	public PendidikanEntity converToPendidikanEntity(PendidikanDto Dto) {
		PendidikanEntity pendidikanEntity=new PendidikanEntity();
		pendidikanEntity.setInstitusi(Dto.getInstitusi());
		pendidikanEntity.setLevel(Dto.getLevel());
		pendidikanEntity.setTahunMasuk(Dto.getMasuk());
		pendidikanEntity.setTahunLulus(Dto.getLulus());
		
		return pendidikanEntity;
	}
}
