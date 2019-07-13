package com.mjtoolbox.newdvdrental.film;

import com.mjtoolbox.newdvdrental.actor.Actor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="film", schema = "public")
public class Film {


    @Id
    @Column(name="film_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long film_id;

    @Column(name="title")
    private String title;

    @Column(name="description")
    private String description;

    @Column(name="release_year")
    private int release_year;

    @Column(name="rental_duration")
    private int rental_duration;

    @Column(name="rental_rate")
    private double rental_rate;

    @Column(name="length")
    private int length;

    @Column(name="replacement_cost")
    private double replacement_cost;

    @CreationTimestamp
    @Column(name="last_update")
    private Date last_update;

    @Column(name="language_id")
    private long language_id;


    // All actors for the Film (Film is the owner)
    @ManyToMany(fetch = FetchType.LAZY,
        cascade = { CascadeType.PERSIST,
                    CascadeType.MERGE})
    @JoinTable(name="film_actor",
        joinColumns = {@JoinColumn(name="film_id")},
        inverseJoinColumns = {@JoinColumn(name="actor_id")}
    )
    private Set<Actor> actors = new HashSet<>();

    public long getFilm_id() {
        return film_id;
    }

    public void setFilm_id(long film_id) {
        this.film_id = film_id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getRelease_year() {
        return release_year;
    }

    public void setRelease_year(int release_year) {
        this.release_year = release_year;
    }

    public int getRental_duration() {
        return rental_duration;
    }

    public void setRental_duration(int rental_duration) {
        this.rental_duration = rental_duration;
    }

    public double getRental_rate() {
        return rental_rate;
    }

    public void setRental_rate(double rental_rate) {
        this.rental_rate = rental_rate;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public double getReplacement_cost() {
        return replacement_cost;
    }

    public void setReplacement_cost(double replacement_cost) {
        this.replacement_cost = replacement_cost;
    }



    public Date getLast_update() {
        return last_update;
    }

    public void setLast_update(Date last_update) {
        this.last_update = last_update;
    }

    public long getLanguage_id() {
        return language_id;
    }

    public void setLanguage_id(long language_id) {
        this.language_id = language_id;
    }

    public Set<Actor> getActors() {
        return actors;
    }

    public void setActors(Set<Actor> actors) {
        this.actors = actors;
    }

    @Override
    public String toString() {
        return "Film{" +
                "film_id=" + film_id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", release_year=" + release_year +
                ", rental_duration=" + rental_duration +
                ", rental_rate=" + rental_rate +
                ", length=" + length +
                ", replacement_cost=" + replacement_cost +
                ", last_update=" + last_update +
                ", language_id=" + language_id +
                '}';
    }
}
