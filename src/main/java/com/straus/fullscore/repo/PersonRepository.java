package com.straus.fullscore.repo;

import com.straus.fullscore.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface PersonRepository extends JpaRepository<Person, Long> {
    @Query("select p from Person p where upper(p.firstName) = upper(?1) and upper(p.lastName) = upper(?2)")
    Optional<Person> findByFullName(String firstName, String lastName);
}
