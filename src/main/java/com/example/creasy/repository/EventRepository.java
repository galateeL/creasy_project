package com.example.creasy.repository;

import com.example.creasy.repository.entity.Event;
import com.example.creasy.repository.entity.Note;
import com.example.creasy.repository.entity.Partner;
import com.example.creasy.repository.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface EventRepository extends CrudRepository<Event, Long> {
	
	/* Note these two methods do the same thing.  The @Repository annotation handles both*/
	
	
	/* This one uses a JPQL */
	public List<Event> findByStartGreaterThanEqualAndFinishLessThanEqual(LocalDateTime start, LocalDateTime end);
	@Query(value = "SELECT e FROM Event e WHERE e.userById = :user")
	List<Event> findAllEvenements(User user);



	/* This one uses an @Query */
	@Query("select b from Event b where b.start >= ?1 and b.finish <= ?2")
	public List<Event> findByDateBetween(LocalDateTime start, LocalDateTime end);
	
}