
package fi.vamk.e1800960.northwind.demo.Controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestMethod;

import org.springframework.web.bind.annotation.RequestParam;

import org.springframework.web.bind.annotation.ResponseBody;

import org.springframework.web.bind.annotation.RestController;

import fi.vamk.e1800960.northwind.demo.Entity.*;
import fi.vamk.e1800960.northwind.demo.Repo.*;


@RestController

public class PrivilegesController {

	@Autowired

	private PrivilegesRepository repository;
	
    @RequestMapping(value = "/Privileges" , method = RequestMethod.POST)

    public @ResponseBody Privileges create(@RequestBody Privileges item) {

    	return repository.save(item);

    }  

	

    @RequestMapping("/Privileges")

    public Iterable<Privileges> municipalities(@RequestParam(value="name", defaultValue="World") String name) {

        return repository.findAll();

    }    

    

    @RequestMapping("/Privileges/{id}")

    public Optional<Privileges> get(@PathVariable("id") int id) {
        return repository.findById(id);
    }    



    @RequestMapping(value = "/Privileges" , method = RequestMethod.PUT)

    public @ResponseBody Privileges update(@RequestBody Privileges item) {

    	return repository.save(item);

    } 

    

    @RequestMapping(value = "/Privileges" , method = RequestMethod.DELETE)

    public void delete(@RequestBody Privileges item) {

    	repository.delete(item);

        //do business logic

    } 

}
