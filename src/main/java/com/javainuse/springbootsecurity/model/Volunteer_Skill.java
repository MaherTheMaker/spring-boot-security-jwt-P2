package com.javainuse.springbootsecurity.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table
public class Volunteer_Skill {
    @javax.persistence.Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private short id;

    private String description;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Volunteer_id")
    private Volunteer volunteer;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Skill_id")
    private Skill skill;


    public Volunteer_Skill(String description, Volunteer volunteer, Skill skill) {
        this.description = description;
        this.volunteer = volunteer;
        this.skill = skill;
    }

    public Volunteer_Skill() {
    }

    public short getId() {
        return id;
    }

    public void setId(short id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Volunteer getVolunteer() {
        return volunteer;
    }

    public void setVolunteer(Volunteer volunteer) {
        this.volunteer = volunteer;
    }

    public Skill getSkill() {
        return skill;
    }

    public void setSkill(Skill skill) {
        this.skill = skill;
    }
}
