package com.eduted.webservices.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.eduted.webservices.model.User;
import com.eduted.webservices.services.UserService;


@RestController
//@RequestMapping("/eduted/users")
public class UserResources
{
	@Autowired
	private UserService userServices = new UserService();
	
/*******************************************************************************************/
	
	@PostMapping("user")
	@ResponseBody
	public ResponseEntity<String> createNewUser(@RequestBody User user)
	{
		System.out.println(user);
		
		if(user == null)
			return new ResponseEntity<String> ("No Data Found...[ERROR]", HttpStatus.NOT_FOUND);
		
		return new ResponseEntity<String> (userServices.addNewUser(user), HttpStatus.OK);
	}
	

	@GetMapping("user/{id}")
	public ResponseEntity<String> searchUser(@PathVariable("id") String id)
	{
		if(id == null)
			return new ResponseEntity<String> ("No Data Found...[ERROR]", HttpStatus.NOT_FOUND);
		
		return new ResponseEntity<String> (userServices.getUserById(id), HttpStatus.OK);
	}

	@RequestMapping(value="/users", method = RequestMethod.GET)
	public ResponseEntity<List<User>> searchAllUser()
	{
		return new ResponseEntity<List<User>> (userServices.getAllUsers(), HttpStatus.OK);
	}
	
	@RequestMapping(value="/", method = RequestMethod.GET)
	public ResponseEntity<String> index()
	{
		return new ResponseEntity<String> ("<h1><center>Hello World!!!</h1></center>", HttpStatus.OK);
	}
}
