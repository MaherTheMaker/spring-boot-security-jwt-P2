package com.javainuse.springbootsecurity.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table
public class VolunteeringArea {
//    EducationalServices,
//    AdministrativeAndOfficeServices,
//    OrganizingActivitiesAndEvents,
//    GivingLecturesAndWorkshops,
//    HomeVisitsToTheBeneficiaryFamilies,
//    MedicalAndHealthServices

    @javax.persistence.Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private short id;
    @Column
    private String volunteeringArea;

//    @OneToMany(mappedBy = "volunteerArea", cascade = CascadeType.ALL,fetch = FetchType.LAZY)
//    private List<Volunteer_VolunteeringArea> VolunteerAreas;

    public VolunteeringArea() {
    }

    public VolunteeringArea(String volunteeringArea) {
        this.volunteeringArea = volunteeringArea;
    }

    public short getId() {
        return id;
    }


    public String getVolunteeringArea() {
        return volunteeringArea;
    }

    public void setVolunteeringArea(String volunteeringArea) {
        this.volunteeringArea = volunteeringArea;
    }
}

