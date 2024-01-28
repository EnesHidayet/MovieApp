package org.enes.service;

import lombok.RequiredArgsConstructor;
import org.enes.entity.Genre;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class GenreService implements ICrudService<Genre,Long>{
    @Override
    public Genre save(Genre genre) {
        return null;
    }

    @Override
    public Genre update(Genre genre) {
        return null;
    }

    @Override
    public Optional<Genre> findById(Long aLong) {
        return Optional.empty();
    }

    @Override
    public Iterable<Genre> findAll() {
        return null;
    }

    @Override
    public Genre deleteById(Long aLong) {
        return null;
    }
}
