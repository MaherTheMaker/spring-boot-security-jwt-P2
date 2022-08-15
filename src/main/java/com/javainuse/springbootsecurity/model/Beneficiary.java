package com.javainuse.springbootsecurity.model;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Data
@Entity
@Table
public class Beneficiary  implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;
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
    @JoinColumn(name = "User_id")
    private User user;

    @OneToMany(mappedBy = "beneficiary", cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private List<Need> needs;

    @OneToMany(mappedBy = "beneficiary", cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private List<Beneficiary_Event> beneficiary_events;

    public Beneficiary() {
    }
}
