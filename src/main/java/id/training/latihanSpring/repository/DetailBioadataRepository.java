package id.training.latihanSpring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import id.training.latihanSpring.entity.DetailBiodataEntity;

public interface DetailBioadataRepository extends JpaRepository<DetailBiodataEntity, Integer> {
	@Query(value="select domisili from biodata_detail where id =?",nativeQuery = true)
	String findDomisilibyId(Integer id);
}
