package com.mjtoolbox.newdvdrental.film;

import com.mjtoolbox.newdvdrental.language.Language;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * [IMPORTANT]
 * findByxxx method where xxx must be a property of Film. In this case, language which defines @ManyToOne relationship.
 */

@Repository
public interface FilmRepository extends JpaRepository<Film, Long> {
    Page<Film> findByLanguage(Language language, Pageable pageable);
    Optional<Film> findByFilmIdAndLanguage(long film_id, Language language);
}
