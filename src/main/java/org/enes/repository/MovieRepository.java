package org.enes.repository;

import org.enes.entity.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface MovieRepository extends JpaRepository<Movie, Long> {

    List<Movie> findByRatingGreaterThan(String rating);

    List<Movie> findByPremieredLessThan(String premiered);

    List<Movie> findByRatingBetween(String sRating, String eRating);
}
