package com.javainuse.springbootsecurity.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Data
@Entity
@Table
public class Beneficiary  implements Serializable {
    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private long id;
    @Column
    private int childNumber;
    @Column
    private String work;
    @Column
    private int salary;
    @Column
    @Enumerated(EnumType.ORDINAL)
    private HousingMode housingMode;
    @OneToOne
    @JoinColumn(name = "id")
    @MapsId
    private User user;

//    @JsonIgnore
    @OneToMany(mappedBy = "beneficiary", cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private List<Need> needs;

    @OneToMany(mappedBy = "beneficiary", cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private List<Beneficiary_Event> beneficiary_events;

    public Beneficiary() {
    }
}
