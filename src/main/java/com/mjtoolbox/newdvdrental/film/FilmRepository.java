package com.mjtoolbox.newdvdrental.film;

import com.mjtoolbox.newdvdrental.language.Language;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FilmRepository extends JpaRepository<Film, Long> {
    Page<Film> findByLanguage(Language language, Pageable pageable);
}
