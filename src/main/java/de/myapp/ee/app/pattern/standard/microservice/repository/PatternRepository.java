package de.myapp.ee.app.pattern.standard.microservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import de.myapp.ee.app.pattern.standard.microservice.model.Pattern;

import java.util.Optional;

@Repository
public interface PatternRepository extends JpaRepository<Pattern, Long> {
    Optional<Pattern> findByName(String patternName);
}
