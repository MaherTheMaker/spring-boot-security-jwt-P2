package com.javainuse.springbootsecurity.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table
public class Skill {
    @javax.persistence.Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private short id;
    @Column
    private String skillName;
    @OneToMany(mappedBy = "skill", cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    private List<Volunteer_Skill> volunteerSkills;
}
