package org.enes.repository;

import org.enes.entity.MovieComment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
public interface MovieCommentRepository extends JpaRepository<MovieComment, Long> {
    List<MovieComment> findByMovieId(Long movieId);

    List<MovieComment> findByMovieIdAndDateBetween(Long movieId, LocalDate startDate, LocalDate endDate);

//    List<MovieComment> existsByContentLengthGreaterThan(Integer length);
}
