package it.samu3l.ratings.repository;

import it.samu3l.ratings.model.Ratings;
import org.springframework.data.jpa.repository.JpaRepository;

import java.sql.Timestamp;
import java.util.List;

public interface IRatingsRepository extends JpaRepository<Ratings, Integer> {
    Iterable<Ratings> findAllByTotemOrderByIdDesc(String room);
    Iterable<Ratings> getAllByOrderByIdDesc();
    List<Ratings> findByTimestampBetweenOrderByIdDesc(Timestamp timestamp, Timestamp timestamp2);
    List<Ratings> findByTimestampBetweenAndTotemOrderByIdDesc(Timestamp timestamp, Timestamp timestamp2, String room);
}
