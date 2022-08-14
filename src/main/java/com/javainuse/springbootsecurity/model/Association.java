package com.javainuse.springbootsecurity.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;


@Data
//@AllArgsConstructor
//@NoArgsConstructor
@Entity
@Table
public class Association {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String name;
    @Column
    private String message;
    @Column
    private String vision;
    @Column
    private String ass_values;
    @Column
    private String goals;
    @Column
    private String phone;
    @Column
    private String mobile;
    @Column
    private String email;
    @Column
    private String bank;
    @OneToOne
    private Address address;

    @ManyToMany
    @JoinTable(name = "volunteer_Association", joinColumns = @JoinColumn(name = "association_id"), inverseJoinColumns =
    @JoinColumn(name = "volunteer_id"))
    List<Volunteer> volunteers;

}
