package com.example.questionnaire.repository;

import java.time.LocalDate;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.questionnaire.entity.Questionnaire;

@Repository
public interface QuestionnaireDao extends JpaRepository<Questionnaire, Integer> {

	public List<Questionnaire> findByIdIn(List<Integer> idList);

	public List<Questionnaire> findByTitleContainingAndStartDateGreaterThanEqualAndEndDateLessThanEqual(String title,
			LocalDate start, LocalDate end);

	@Modifying
	@Transactional
	@Query(value = "insert into questionnaire(title,description," //
			+ "is_published,start_date,end_date) "//
			+ "values (:title, :desp, :isPublished, :startDate, :endDate)", nativeQuery = true) //
	public int insert(//
			@Param("title") String title, //
			@Param("desp") String description, //
			@Param("isPublished") boolean isPublished, //
			@Param("startDate") LocalDate startDate, //
			@Param("endDate") LocalDate endDate); //

	@Modifying
	@Transactional
	@Query(value = "insert into questionnaire(title,description," //
			+ "is_published,start_date,end_date) "//
			+ "values (?1, ?2, ?3, ?4, ?5)", nativeQuery = true) //
	public int insertData(//
			String title, // for ?1
			String description, // ?2
			boolean isPublished, // ?3
			LocalDate startDate, // ?4
			LocalDate endDate); // ?5
	
	@Query(value= " select id, ispublished from questionnaire ) " ,nativeQuery = true)
	public List<Questionnaire> findByIdAndTitle(int id,String title);
	
	
	

}
