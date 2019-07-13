package com.mjtoolbox.newdvdrental.film;

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
