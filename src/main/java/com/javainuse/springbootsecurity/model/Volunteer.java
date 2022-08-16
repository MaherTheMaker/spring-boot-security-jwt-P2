package com.javainuse.springbootsecurity.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table
public class Volunteer {
    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private long id;

    @Column(name="facebook_Account")
    private String facebook;

    @Column(name="whats_up_number")
    private String whatsUp;

    @OneToOne
    //@JoinColumn(name = "User_id")
    @MapsId
    @JoinColumn(name = "id")
    private User user;

    @OneToMany(mappedBy = "volunteer", cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @Fetch(value = FetchMode.SUBSELECT)
    private List<Volunteer_VolunteerDay> volunteerDays;

    @OneToMany(mappedBy = "volunteer", cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @Fetch(value = FetchMode.SUBSELECT)
    private List<Volunteer_VolunteeringArea> volunteerAreas;

    @OneToMany(mappedBy = "volunteer", cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    private List<Volunteer_Skill> volunteerSkills;

    @OneToMany(mappedBy = "volunteer", cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private List<Volunteer_Association> volunteer_associations;

    @OneToMany(mappedBy = "volunteer", cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private List<Event_Task_Volunteer> event_task_volunteers;
    public Volunteer() {
    }

    public Long getId() {
        return id;
    }

    public Volunteer(String facebook, String whatsUp, User user, List<Volunteer_VolunteerDay> volunteerDays, List<Volunteer_VolunteeringArea> volunteerAreas, List<Volunteer_Skill> volunteerSkills) {
        this.facebook = facebook;
        this.whatsUp = whatsUp;
        this.user = user;
        this.volunteerDays = volunteerDays;
        this.volunteerAreas = volunteerAreas;
        this.volunteerSkills = volunteerSkills;
    }

    public String getFacebook() {
        return facebook;
    }

    public void setFacebook(String facebook) {
        this.facebook = facebook;
    }

    public String getWhatsUp() {
        return whatsUp;
    }

    public void setWhatsUp(String whatsUp) {
        this.whatsUp = whatsUp;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Volunteer_VolunteerDay> getVolunteerDays() {
        return volunteerDays;
    }

    public void setVolunteerDays(List<Volunteer_VolunteerDay> volunteerDays) {
        this.volunteerDays = volunteerDays;
    }

    public List<Volunteer_VolunteeringArea> getVolunteerAreas() {
        return volunteerAreas;
    }

    public void setVolunteerAreas(List<Volunteer_VolunteeringArea> volunteerAreas) {
        this.volunteerAreas = volunteerAreas;
    }

    public List<Volunteer_Skill> getVolunteerSkills() {
        return volunteerSkills;
    }

    public void setVolunteerSkills(List<Volunteer_Skill> volunteerSkills) {
        this.volunteerSkills = volunteerSkills;
    }
}
