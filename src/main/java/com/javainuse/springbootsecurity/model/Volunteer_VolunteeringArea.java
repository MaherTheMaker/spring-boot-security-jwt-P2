package com.javainuse.springbootsecurity.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table
public class Volunteer_VolunteeringArea {
    @javax.persistence.Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "volunteer_id")
    private Volunteer volunteer;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "volunteerArea_id")
    private VolunteeringArea volunteerArea;

    public Volunteer_VolunteeringArea(Volunteer volunteer, VolunteeringArea volunteerArea) {
        this.volunteer = volunteer;
        this.volunteerArea = volunteerArea;
    }

    public Volunteer_VolunteeringArea() {
    }

    public Long getId() {
        return id;
    }


    public Volunteer getVolunteer() {
        return volunteer;
    }

    public void setVolunteer(Volunteer volunteer) {
        this.volunteer = volunteer;
    }

    public VolunteeringArea getVolunteerArea() {
        return volunteerArea;
    }

    public void setVolunteerArea(VolunteeringArea volunteerArea) {
        this.volunteerArea = volunteerArea;
    }
}
