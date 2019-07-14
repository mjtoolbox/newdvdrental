package com.mjtoolbox.newdvdrental.film;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface FilmRepository extends PagingAndSortingRepository<Film, Long> {
//    Page<Film> findByLanguageId(long language_id, Pageable pageable);
//    Optional<Film> findByIdAndLanguageId(long film_id, long language_id);
}
