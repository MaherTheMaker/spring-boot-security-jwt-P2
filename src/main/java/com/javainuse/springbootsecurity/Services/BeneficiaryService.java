package com.javainuse.springbootsecurity.Services;


import com.javainuse.springbootsecurity.model.*;
import com.javainuse.springbootsecurity.model.Exception.NotFoundException;
import com.javainuse.springbootsecurity.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BeneficiaryService {


    @Autowired
    private BeneficiaryRepo beneficiaryRepo;


    @Autowired
    private AssociationRepo associationRepo;

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private NeedRepo needRepo;


    public Beneficiary RegisterBeneficiary (Beneficiary beneficiary, long userid)
    {
      User  user= userRepo.findById(userid);
      if (user==null)
          throw new NotFoundException("no such user id");

        user.setType(Type.Beneficiary);
        userRepo.save(user);
        beneficiary.setUser(user);

        beneficiary=beneficiaryRepo.save(beneficiary);

        return beneficiary;
    }

    public Beneficiary AddNeeds (long benId,Need need,Long assId)
    {

        Beneficiary beneficiary=beneficiaryRepo.findById(benId);
        if (beneficiary==null)
            throw new NotFoundException("no such beneficiary");

        Association association=associationRepo.findById(assId);
        if (association==null)
            throw new NotFoundException("no such association");


        need.setBeneficiary(beneficiary);
        need.setAssociation(association);

        need=needRepo.save(need);

        beneficiary.getNeeds().add(need);
        beneficiary=beneficiaryRepo.save(beneficiary);

        association.getNeeds().add(need);
        association=associationRepo.save(association);



        return beneficiary;
    }


    public List<Beneficiary> GetAllBen() {
        return beneficiaryRepo.findAll();
    }
}