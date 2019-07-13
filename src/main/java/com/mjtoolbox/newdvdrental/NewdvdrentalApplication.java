package com.mjtoolbox.newdvdrental;

import com.mjtoolbox.newdvdrental.actor.Actor;
import com.mjtoolbox.newdvdrental.actor.ActorRespository;
import com.mjtoolbox.newdvdrental.film.Film;
import com.mjtoolbox.newdvdrental.film.FilmRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.Resource;

@SpringBootApplication
public class NewdvdrentalApplication {//implements CommandLineRunner {

	@Resource
	private ActorRespository actorRespository;
	@Resource
	private FilmRepository filmRepository;

	public static void main(String[] args) {
		SpringApplication.run(NewdvdrentalApplication.class, args);
	}

//	@Override
//	public void run(String... args) throws Exception {
//
//		// Create a film
//		Film film = new Film();
//		film.setTitle("Gone with the wind");
//		film.setDescription("A moview about love");
//		film.setRelease_year(1956);
//		film.setLanguage_id(1);
//		film.setRental_duration(7);
//		film.setRental_rate(5.99);
//		film.setReplacement_cost(100);
//
//		// Create an actor
//		Actor actor1 = new Actor();
//		actor1.setFirstName("Clark");
//		actor1.setLastName("Cable");
//
//		Actor actor2 = new Actor();
//		actor2.setFirstName("Vivien");
//		actor2.setLastName("Leigh");
//
//		// Add actor reference in the film
//		film.getActors().add(actor1);
//		film.getActors().add(actor2);
//
//		// Add film reference in the actor
//		actor1.getFilms().add(film);
//		actor2.getFilms().add(film);
//
//		filmRepository.save(film);
//
//	}

}
