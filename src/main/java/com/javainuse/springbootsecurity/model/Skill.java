package com.javainuse.springbootsecurity.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table
public class Skill {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private short id;

    @Column
    private String name;


    @OneToMany(mappedBy = "skill", cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private List<Volunteer_Skill> volunteerSkills;

    public Skill() {
    }

    public Skill(String name, List<Volunteer_Skill> volunteerSkills) {
        this.name = name;
        this.volunteerSkills = volunteerSkills;
    }

    public short getId() {
        return id;
    }



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Volunteer_Skill> getVolunteerSkills() {
        return volunteerSkills;
    }

    public void setVolunteerSkills(List<Volunteer_Skill> volunteerSkills) {
        this.volunteerSkills = volunteerSkills;
    }
}
