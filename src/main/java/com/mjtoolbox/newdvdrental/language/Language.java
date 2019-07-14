package com.mjtoolbox.newdvdrental.language;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.mjtoolbox.newdvdrental.film.Film;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;


@Entity
@Table(name="Language", schema = "public")
public class Language {

    @Id
    @Column(name="language_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long language_id;

    @Column(name="name")
    private String name;

    @CreationTimestamp
    @Column(name="last_update")
    private Date last_update;

    @OneToMany(mappedBy = "language", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnore
    private Set<Film> films = new HashSet<>();

    public long getLanguage_id() {
        return language_id;
    }

    public void setLanguage_id(long language_id) {
        this.language_id = language_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getLast_update() {
        return last_update;
    }

    public void setLast_update(Date last_update) {
        this.last_update = last_update;
    }

    public Set<Film> getFilms() {
        return films;
    }

    public void setFilms(Set<Film> films) {
        this.films = films;
    }

    @Override
    public String toString() {
        return "Language{" +
                "language_id=" + language_id +
                ", name='" + name + '\'' +
                ", last_update=" + last_update +
                '}';
    }
}
