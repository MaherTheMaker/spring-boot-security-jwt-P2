package com.javainuse.springbootsecurity.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table
public class Volunteer_Association {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "volunteer_id")
    @JsonIgnore
    private Volunteer volunteer;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "association_id")
    private Association association;

    @Column
    private Status status;

    public Volunteer_Association() {

    }

    public Volunteer_Association(Volunteer volunteer, Association association, Status status) {
        this.volunteer = volunteer;
        this.association = association;
        this.status = status;
    }

    public void setVolunteer(Volunteer volunteer) {
        this.volunteer = volunteer;
    }

    public void setAssociation(Association association) {
        this.association = association;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public Volunteer getVolunteer() {
        return volunteer;
    }

    public Association getAssociation() {
        return association;
    }

    public Status getStatus() {
        return status;
    }
}
