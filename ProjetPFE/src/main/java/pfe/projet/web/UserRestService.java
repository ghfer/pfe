package pfe.projet.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import pfe.projet.demo.dao.UserRepository;
import pfe.projet.demo.entities.User;

@RestController
public class UserRestService {
	@Autowired
	private UserRepository userRepository;
	@RequestMapping(value="/users",method=RequestMethod.GET)
	public List<User> getUsers(){
		return userRepository.findAll();
		
	}
	@RequestMapping(value="/chercheUsers",method=RequestMethod.GET)
	public Page<User> chercher(
			@RequestParam(name="mc", defaultValue="") String mc,
			@RequestParam(name="page", defaultValue="0") int page,
			@RequestParam(name="size", defaultValue="5") int size){
			return userRepository.chercher("%"+mc+"%", new PageRequest(page, size) );}
		
		
	
	@RequestMapping(value="/users",method=RequestMethod.POST)
	public User save(@RequestBody User u){
		return userRepository.save(u);
		
	}

	@RequestMapping(value="/users",method=RequestMethod.DELETE)
	public boolean supprimer(@PathVariable User u){
		 userRepository.delete(u);
		 return true;
		
	}

	@RequestMapping(value="/users{id}",method=RequestMethod.PUT)
	public User maj(@RequestBody User u){
		 return userRepository.saveAndFlush(u);
		
	}

}
