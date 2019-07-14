package com.mjtoolbox.newdvdrental.film;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.mjtoolbox.newdvdrental.actor.Actor;
import com.mjtoolbox.newdvdrental.language.Language;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Objects;
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

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name="language_id", nullable = false)
    @OnDelete(action= OnDeleteAction.NO_ACTION)
    @JsonIgnore
    private Language language;

    @Column(name="language_id", insertable = false, updatable = false)
    private long language_id;

    // All actors for the Film (Film is the owner)
    @ManyToMany(fetch = FetchType.LAZY,
        cascade = { CascadeType.ALL
    })
    @JoinTable(name="film_actor",
        joinColumns = {@JoinColumn(name="film_id")},
        inverseJoinColumns = {@JoinColumn(name="actor_id")}
    )
    @JsonIgnore
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

    public long getLanguage_id() {
        return language_id;
    }

    public void setLanguage_id(long language_id) {
        this.language_id = language_id;
    }

    public Date getLast_update() {
        return last_update;
    }

    public void setLast_update(Date last_update) {
        this.last_update = last_update;
    }

    public Set<Actor> getActors() {
        return actors;
    }

    public void setActors(Set<Actor> actors) {
        this.actors = actors;
    }

    public Language getLanguage() {
        return language;
    }

    public void setLanguage(Language language) {
        this.language = language;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Film film = (Film) o;
        return film_id == film.film_id &&
                release_year == film.release_year &&
                rental_duration == film.rental_duration &&
                Double.compare(film.rental_rate, rental_rate) == 0 &&
                length == film.length &&
                Double.compare(film.replacement_cost, replacement_cost) == 0 &&
                language_id == film.language_id &&
                Objects.equals(title, film.title) &&
                Objects.equals(description, film.description) &&
                Objects.equals(last_update, film.last_update) &&
                Objects.equals(language, film.language) &&
                Objects.equals(actors, film.actors);
    }

    @Override
    public int hashCode() {
        return Objects.hash(film_id, title, description, release_year, rental_duration, rental_rate, length, replacement_cost, last_update, language, language_id, actors);
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
//                ", language=" + language +
//                ", actors=" + actors +
                '}';
    }
}
