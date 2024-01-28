package org.enes.service;

import lombok.RequiredArgsConstructor;
import org.enes.entity.MovieComment;
import org.enes.repository.MovieCommentRepository;
import org.springframework.stereotype.Service;
import static org.enes.repository.MovieCommentRepository.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
@Service
@RequiredArgsConstructor
public class MovieCommentService implements ICrudService<MovieComment,Long> {
    private final MovieCommentRepository movieCommentRepository;


    @Override
    public MovieComment save(MovieComment movieComment) {
        return null;
    }

    @Override
    public MovieComment update(MovieComment movieComment) {
        return null;
    }

    @Override
    public Optional<MovieComment> findById(Long aLong) {
        return Optional.empty();
    }

    @Override
    public Iterable<MovieComment> findAll() {
        return null;
    }

    @Override
    public MovieComment deleteById(Long aLong) {
        return null;
    }

    public List<MovieComment> findByMovieId(Long movieId){
        return movieCommentRepository.findByMovieId(movieId);
    }

    public List<MovieComment> findByMovieIdAndDateBetween(Long movieId, LocalDate startDate, LocalDate endDate){
        return movieCommentRepository.findByMovieIdAndDateBetween(movieId,startDate,endDate);
    }

//    public List<MovieComment> findByContentLengthGreaterThan(Integer length){
//        return movieCommentRepository.existsByContentLengthGreaterThan(length);
//    }
}
