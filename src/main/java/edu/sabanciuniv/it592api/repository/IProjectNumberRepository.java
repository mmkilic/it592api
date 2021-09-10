package edu.sabanciuniv.it592api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import edu.sabanciuniv.it592api.entity.ProjectNumber;

@Repository
public interface IProjectNumberRepository extends JpaRepository<ProjectNumber, Integer> {
	
	@Query("SELECT pn from ProjectNumber pn where pn.mainProject.id=(:mainPrjId)")
	List<ProjectNumber> findByMainProject(@Param("mainPrjId") int mainPrjId);
	
}
