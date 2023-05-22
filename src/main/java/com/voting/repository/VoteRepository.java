package com.voting.repository;

import com.voting.model.Vote;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VoteRepository extends JpaRepository<Vote, Integer> {

    List<Vote> findByPersonId(int personId);
    List<Vote> findByPlayPackageId(int playPackageId);
}
