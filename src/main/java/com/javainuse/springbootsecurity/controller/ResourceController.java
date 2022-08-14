package com.javainuse.springbootsecurity.controller;

import com.javainuse.springbootsecurity.Services.UsersService;
import com.javainuse.springbootsecurity.model.Profile;
import com.javainuse.springbootsecurity.model.User;
import com.javainuse.springbootsecurity.model.Volunteer;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
public class ResourceController {


	@RequestMapping("/hellouser")
	public String getUser()
	{
		return "Hello User";
	}
	
	@RequestMapping("/helloadmin")
	public String getAdmin()
	{
		return "Hello Admin";
	}

	@RequestMapping(value = "/test",method = RequestMethod.POST)
	public ResponseEntity Test() throws Exception
	{
		return ResponseEntity.accepted().body("sdsd");
	}

}

