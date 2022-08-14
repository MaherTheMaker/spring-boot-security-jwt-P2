package com.javainuse.springbootsecurity.Services;


import com.javainuse.springbootsecurity.config.CustomUserDetailsService;
import com.javainuse.springbootsecurity.model.Exception.NotFoundException;
import com.javainuse.springbootsecurity.model.Profile;
import com.javainuse.springbootsecurity.model.ProfileDto;
import com.javainuse.springbootsecurity.model.User;
import com.javainuse.springbootsecurity.model.Volunteer;
import com.javainuse.springbootsecurity.repository.ProfileRepository;
import com.javainuse.springbootsecurity.repository.UserRepo;
import com.javainuse.springbootsecurity.repository.VolunteerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsersService {


    @Autowired
    private UserRepo userRepo;

    @Autowired
    private ProfileRepository profileRepository;

    @Autowired
    private CustomUserDetailsService customUserDetailsService;


    public User RegisterUser(User user, Profile profile) {

        Profile profile1 = customUserDetailsService.save(profile);
        user.setProfile(profile1);

        User user2 = userRepo.save(user);
        profile1.setUser(user);
        profileRepository.save(profile1);

        return user2;
    }


}