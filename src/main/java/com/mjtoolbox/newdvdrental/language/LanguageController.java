package com.mjtoolbox.newdvdrental.language;

import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class LanguageController {

    @Resource
    LanguageRepository languageRepository;

    @GetMapping("/languages")
    public List<Language> retrieveAllFilms(){
        return StreamSupport.stream(languageRepository.findAll().spliterator(),false)
                .collect(Collectors.toList());
    }

    @GetMapping("/languages/{id}")
    public Language findById(@PathVariable long id){
        return languageRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Language not found with ID: " + id));
    }

    @PostMapping("/languages")
    public Language createFilm(@Valid @RequestBody Language language){
        return languageRepository.save(language);
    }

    @DeleteMapping("/languages/{id}")
    public void delete(@PathVariable long id){
        languageRepository.findById( id)
                .orElseThrow(()-> new ResourceNotFoundException("Language not found with ID: " + id));
        languageRepository.deleteById( id);
    }
}
