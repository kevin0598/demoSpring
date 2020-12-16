package id.training.latihanSpring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import id.training.latihanSpring.entity.PendidikanEntity;

@Repository
public interface PendidikanRepository extends JpaRepository<PendidikanEntity, Integer> {

}
