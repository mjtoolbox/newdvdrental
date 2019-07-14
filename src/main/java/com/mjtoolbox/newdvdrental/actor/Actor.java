package com.mjtoolbox.newdvdrental.actor;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.mjtoolbox.newdvdrental.film.Film;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name="actor", schema ="public")
public class Actor {

    @Id
    @Column(name="actor_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long actorId;

    @Column(name="first_name")
    private String firstName;

    @Column(name="last_name")
    private String lastName;

    @CreationTimestamp
    @Column(name="last_update")
    private Date lastUpdated;

    // Films that Actor played (Actor is inverse side)
    @ManyToMany(fetch = FetchType.LAZY,
        cascade = {
                CascadeType.ALL
        },
            mappedBy = "actors"
    )
    @JsonIgnore
    private Set<Film> films = new HashSet<>();


    public long getActorId() {
        return actorId;
    }

    public void setActorId(long actorId) {
        this.actorId = actorId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Date getLastUpdated() {
        return lastUpdated;
    }

    public void setLastUpdated(Date lastUpdated) {
        this.lastUpdated = lastUpdated;
    }

    public Set<Film> getFilms() {
        return films;
    }

    public void setFilms(Set<Film> films) {
        this.films = films;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Actor actor = (Actor) o;
        return actorId == actor.actorId &&
                Objects.equals(firstName, actor.firstName) &&
                Objects.equals(lastName, actor.lastName) &&
                Objects.equals(lastUpdated, actor.lastUpdated);
    }

    @Override
    public int hashCode() {
        return Objects.hash(actorId, firstName, lastName, lastUpdated);
    }

    @Override
    public String toString() {
        return "Actor{" +
                "actorId=" + actorId +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", lastUpdated=" + lastUpdated +
                '}';
    }
}
