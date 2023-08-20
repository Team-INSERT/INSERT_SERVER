package com.project.insert.repository;

import com.project.insert.domain.Generation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface GenerationRepository extends JpaRepository<Generation, String> {
    Optional<Generation> findById(String githubId);
}
