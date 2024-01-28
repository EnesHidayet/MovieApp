package org.enes.controller;

import lombok.RequiredArgsConstructor;
import org.enes.entity.MovieComment;
import org.enes.service.MovieCommentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import static org.enes.service.MovieCommentService.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/movieComment")
public class MovieCommentController {
    private final MovieCommentService movieCommentService;

    @GetMapping("/find-by-movie-id")
    public ResponseEntity<List<MovieComment>> findByMovieId(Long movieId){
        return ResponseEntity.ok(movieCommentService.findByMovieId(movieId));
    }

    @GetMapping("/find-by-movie-id-and-between-date")
    public ResponseEntity<List<MovieComment>> findByMovieIdAndBetweenDate(Long movieId, LocalDate startDate, LocalDate endDate){
        return ResponseEntity.ok(movieCommentService.findByMovieIdAndDateBetween(movieId,startDate,endDate));
    }

//    @GetMapping("/find-by-content-length-greater-than")
//    public ResponseEntity<List<MovieComment>> findByContentLengthGreaterThan(Integer length){
//        return ResponseEntity.ok(movieCommentService.findByContentLengthGreaterThan(length));
//    }
}
