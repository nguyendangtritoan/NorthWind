
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

public class OrdersController {

	@Autowired

	private OrdersRepository repository;
	
    @RequestMapping(value = "/Orders" , method = RequestMethod.POST)

    public @ResponseBody Orders create(@RequestBody Orders item) {

    	return repository.save(item);

    }  

	

    @RequestMapping("/Orders")

    public Iterable<Orders> municipalities(@RequestParam(value="name", defaultValue="World") String name) {

        return repository.findAll();

    }    

    

    @RequestMapping("/Orders/{id}")

    public Optional<Orders> get(@PathVariable("id") int id) {
        return repository.findById(id);
    }    



    @RequestMapping(value = "/Orders" , method = RequestMethod.PUT)

    public @ResponseBody Orders update(@RequestBody Orders item) {

    	return repository.save(item);

    } 

    

    @RequestMapping(value = "/Orders" , method = RequestMethod.DELETE)

    public void delete(@RequestBody Orders item) {

    	repository.delete(item);

        //do business logic

    } 

}
