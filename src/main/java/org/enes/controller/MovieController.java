package org.enes.controller;

import lombok.RequiredArgsConstructor;
import org.enes.entity.Movie;
import org.enes.service.MovieService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import static org.enes.service.MovieService.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/movie")
public class MovieController {
    private final MovieService movieService;
    @GetMapping("/add")
    public ResponseEntity<Movie> save(Movie movie){
        return ResponseEntity.ok(movieService.save(movie));
    }

    @GetMapping("/find-by-rating")
    public ResponseEntity<List<Movie>> findByRatingGreaterThan(String rating){
        return ResponseEntity.ok(movieService.findByRatingGreaterThan(rating));
    }

    @GetMapping("/find-by-premiered")
    public ResponseEntity<List<Movie>> findByPremieredLessThan(String premiered) {
        return ResponseEntity.ok(movieService.findByPremieredLessThan(premiered));
    }

    @GetMapping("/find-by-rating-between")
    public ResponseEntity<List<Movie>> findByRatingBetween(){
        return ResponseEntity.ok(movieService.findByRatingBetween());
    }
}
