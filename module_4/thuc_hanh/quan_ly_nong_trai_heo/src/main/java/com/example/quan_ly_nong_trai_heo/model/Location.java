package com.example.quan_ly_nong_trai_heo.model;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "locations")
public class Location {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(unique = true, columnDefinition = "varchar(45)")
    private String name;
    @OneToMany(mappedBy = "location")
    private Set<Pig> pigSet;

    public Location() {
    }

    public Location(Integer id, String name, Set<Pig> pigSet) {
        this.id = id;
        this.name = name;
        this.pigSet = pigSet;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Pig> getPigSet() {
        return pigSet;
    }

    public void setPigSet(Set<Pig> pigSet) {
        this.pigSet = pigSet;
    }
}
