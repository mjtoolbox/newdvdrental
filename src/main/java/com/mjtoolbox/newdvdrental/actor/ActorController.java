package com.mjtoolbox.newdvdrental.actor;

import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@RestController
public class ActorController {

    @Resource
    ActorRespository actorRespository;

    @GetMapping("/actors")
    public List<Actor> retrieveAllActors(){
        return StreamSupport.stream(actorRespository.findAll().spliterator(), false)
                .collect(Collectors.toList());
    }

    @GetMapping("/actors/{id}")
    public Actor findById(@PathVariable long id){
        return actorRespository.findById( id)
                .orElseThrow(()-> new ResourceNotFoundException("Actor not found with ID: " + id));
    }

    @PostMapping("/actors")
    public Actor createActor(@Valid @RequestBody Actor actor){
        return actorRespository.save( actor);
    }

    @PutMapping("/actors/{id}")
    public Actor updateActor( @PathVariable long id, @Valid @RequestBody Actor actor){
        Actor actorFromDB = actorRespository.findById( id)
                .orElseThrow(()-> new ResourceNotFoundException("Actor not found with ID: " + id));
        actorFromDB.setFirstName( actor.getFirstName());
        actorFromDB.setLastName(actor.getLastName());
        return actorRespository.save(actorFromDB);
    }

    @DeleteMapping("/actors/{id}")
    public void delete(@PathVariable long id){
       actorRespository.findById( id)
                .orElseThrow(()-> new ResourceNotFoundException("Actor not found with ID: " + id));
        actorRespository.deleteById( id);
    }


}
