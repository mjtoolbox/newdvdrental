package com.mjtoolbox.newdvdrental.film;

import com.mjtoolbox.newdvdrental.language.Language;
import com.mjtoolbox.newdvdrental.language.LanguageRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class FilmController {
    @Resource
    FilmRepository filmRepository;

    @Resource
    LanguageRepository languageRepository;

    @GetMapping("/films")
    public List<Film> retrieveAllFilms(){
        return StreamSupport.stream(filmRepository.findAll().spliterator(),false)
                .collect(Collectors.toList());
    }

    @GetMapping("/films/{id}")
    public Film findById(@PathVariable long id){
        return filmRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Film not found with ID: " + id));
    }

    @GetMapping("/languages/{language_id}/films")
    public Page<Film> getAllFilmsByLanguageId(@PathVariable (value="language_id") long language_id, Pageable pageable){
        Language language = languageRepository.findById(language_id).orElseThrow(()-> new ResourceNotFoundException("Language not found by ID: " + language_id));
        return filmRepository.findByLanguage(language, pageable);
    }

    @PostMapping("/films")
    public Film createFilm(@Valid @RequestBody Film film){
        return filmRepository.save( film);
    }

    @PutMapping("/films/{id}")
    public Film updateFilm( @PathVariable long id, @Valid @RequestBody Film film){
        Film filmFromDB = filmRepository.findById( id)
                .orElseThrow(()-> new ResourceNotFoundException("Film not found with ID: " + id));
        filmFromDB.setRental_duration(film.getRental_duration());
        filmFromDB.setRental_rate(film.getRental_rate());
        filmFromDB.setReplacement_cost(film.getReplacement_cost());
        return filmRepository.save(filmFromDB);
    }

    @DeleteMapping("/films/{id}")
    public void delete(@PathVariable long id){
        filmRepository.findById( id)
                .orElseThrow(()-> new ResourceNotFoundException("Film not found with ID: " + id));
        filmRepository.deleteById( id);
    }

}
