package com.voting.repository;

import com.voting.model.PlayPackage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlayPackageRepository extends JpaRepository<PlayPackage, Integer> {
}
