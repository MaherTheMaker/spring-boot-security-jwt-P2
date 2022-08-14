package com.javainuse.springbootsecurity.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table
public class VolunteerDay {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private short id;
    @Column
    Days days;

//    @OneToMany(mappedBy = "volunteerDay", cascade = CascadeType.ALL,fetch = FetchType.LAZY)
//    private List<Volunteer_VolunteerDay> volunteerDay;

    public VolunteerDay() {
    }

    public short getId() {
        return id;
    }

    public VolunteerDay(Days day) {
        days = day;
    }

    public Days getDays() {
        return days;
    }

    public void setDays(Days days) {
        this.days = days;
    }
}
