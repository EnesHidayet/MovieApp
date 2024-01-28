package org.enes.service;

import lombok.RequiredArgsConstructor;
import org.enes.entity.Movie;
import org.enes.repository.MovieRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import static org.enes.repository.MovieRepository.*;

@Service
@RequiredArgsConstructor
public class MovieService implements ICrudService<Movie, Long> {
    private final MovieRepository movieRepository;
    public Movie save(Movie movie) {
        return movieRepository.save(movie);
    }

    @Override
    public Movie update(Movie movie) {
        return null;
    }

    @Override
    public Optional<Movie> findById(Long aLong) {
        return Optional.empty();
    }

    @Override
    public Iterable<Movie> findAll() {
        return null;
    }

    @Override
    public Movie deleteById(Long aLong) {
        return null;
    }

    public List<Movie> findByRatingGreaterThan(String rating){
        return movieRepository.findByRatingGreaterThan(rating);
    }

    public List<Movie> findByPremieredLessThan(String premiered) {
        return movieRepository.findByPremieredLessThan(premiered);
    }

    public List<Movie> findByRatingBetween(){
        return movieRepository.findByRatingBetween("6.9", "9");
    }
}
