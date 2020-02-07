
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

public class ShippersController {

	@Autowired

	private ShippersRepository repository;
	
    @RequestMapping(value = "/Shippers" , method = RequestMethod.POST)

    public @ResponseBody Shippers create(@RequestBody Shippers item) {

    	return repository.save(item);

    }  

	

    @RequestMapping("/Shippers")

    public Iterable<Shippers> municipalities(@RequestParam(value="name", defaultValue="World") String name) {

        return repository.findAll();

    }    

    

    @RequestMapping("/Shippers/{id}")

    public Optional<Shippers> get(@PathVariable("id") int id) {
        return repository.findById(id);
    }    



    @RequestMapping(value = "/Shippers" , method = RequestMethod.PUT)

    public @ResponseBody Shippers update(@RequestBody Shippers item) {

    	return repository.save(item);

    } 

    

    @RequestMapping(value = "/Shippers" , method = RequestMethod.DELETE)

    public void delete(@RequestBody Shippers item) {

    	repository.delete(item);

        //do business logic

    } 

}
