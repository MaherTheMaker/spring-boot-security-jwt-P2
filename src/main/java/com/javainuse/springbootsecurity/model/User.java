package com.javainuse.springbootsecurity.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sun.istack.NotNull;
import lombok.Data;
import org.springframework.lang.NonNull;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "USERS")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@NonNull
	private String fullName;
	private String nationality;
	private String birthPlace;
	private String registrationPlace;
	private String birthDate;
	@NotNull
	private Gender gender;
	@NotNull
	private String phone;
	@NotNull
	private String nationalNumber;
	@NotNull
	private Type type;

	@OneToOne
//	@JoinColumn(name = "address_id")
	private Address address;

	@OneToOne(mappedBy = "user", cascade = CascadeType.ALL,fetch=FetchType.LAZY)
	private Beneficiary beneficiary;

//	@OneToOne(mappedBy = "user", cascade = CascadeType.ALL,fetch = FetchType.LAZY)
//	private Volunteer volunteer;
	@JsonIgnore
	@OneToOne
	private Profile profile;

	public int getId() {
		return id;
	}

	public User() {
	}

	public User(@NonNull String fullName, String nationality, String birthPlace, String registrationPlace, String birthDate, Gender gender, String phone, String nationalNumber, Type type, Address address, Beneficiary beneficiary, Profile profile) {
		this.fullName = fullName;
		this.nationality = nationality;
		this.birthPlace = birthPlace;
		this.registrationPlace = registrationPlace;
		this.birthDate = birthDate;
		this.gender = gender;
		this.phone = phone;
		this.nationalNumber = nationalNumber;
		this.type = type;
		this.address = address;
		this.beneficiary = beneficiary;
		this.profile = profile;
	}

	@NonNull
	public String getFullName() {
		return fullName;
	}

	public void setFullName(@NonNull String fullName) {
		this.fullName = fullName;
	}

	public String getNationality() {
		return nationality;
	}

	public void setNationality(String nationality) {
		this.nationality = nationality;
	}

	public String getBirthPlace() {
		return birthPlace;
	}

	public void setBirthPlace(String birthPlace) {
		this.birthPlace = birthPlace;
	}

	public String getRegistrationPlace() {
		return registrationPlace;
	}

	public void setRegistrationPlace(String registrationPlace) {
		this.registrationPlace = registrationPlace;
	}

	public String getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(String birthDate) {
		this.birthDate = birthDate;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getNationalNumber() {
		return nationalNumber;
	}

	public void setNationalNumber(String nationalNumber) {
		this.nationalNumber = nationalNumber;
	}

	public Type getType() {
		return type;
	}

	public void setType(Type type) {
		this.type = type;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public Beneficiary getBeneficiary() {
		return beneficiary;
	}

	public void setBeneficiary(Beneficiary beneficiary) {
		this.beneficiary = beneficiary;
	}

	public Profile getProfile() {
		return profile;
	}

	public void setProfile(Profile profile) {
		this.profile = profile;
	}

//
//	@OneToOne(mappedBy = "user",cascade = CascadeType.ALL)
//	@PrimaryKeyJoinColumn
//	Address address;
//
//	public User(String userName, String password , boolean active , String roles) {
//
//		this.userName = userName;
//		this.password = password;
//		this.active = active ;
//		this.roles = roles ;
//		this.created = new Date ();
//	}
//
//	public User() {
//
//	}
//
//	public long getId() {
//		return id;
//	}
//
//	public void setId(long id) {
//		this.id = id;
//	}
//
//	public String getUserName() {
//		return userName;
//	}
//
//	public void setUserName(String userName) {
//		this.userName = userName;
//	}
//
//	public String getPassword() {
//		return password;
//	}
//
//	public void setPassword(String password) {
//		this.password = password;
//	}
//
//	public boolean isActive() {
//		return active;
//	}
//
//	public void setActive(boolean active) {
//		this.active = active;
//	}
//
//	public String getRoles() {
//		return roles;
//	}
//
//	public void setRoles(String roles) {
//		this.roles = roles;
//	}
//
//	public Date getCreated() {
//		return created;
//	}
//
//	public void setCreated(Date created) {
//		this.created = created;
//	}



}
