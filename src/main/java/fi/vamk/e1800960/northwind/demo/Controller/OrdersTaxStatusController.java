
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

public class OrdersTaxStatusController {

	@Autowired

	private OrdersTaxStatusRepository repository;
	
    @RequestMapping(value = "/OrdersTaxStatus" , method = RequestMethod.POST)

    public @ResponseBody OrdersTaxStatus create(@RequestBody OrdersTaxStatus item) {

    	return repository.save(item);

    }  

	

    @RequestMapping("/OrdersTaxStatus")

    public Iterable<OrdersTaxStatus> municipalities(@RequestParam(value="name", defaultValue="World") String name) {

        return repository.findAll();

    }    

    

    @RequestMapping("/OrdersTaxStatus/{id}")

    public Optional<OrdersTaxStatus> get(@PathVariable("id") int id) {
        return repository.findById(id);
    }    



    @RequestMapping(value = "/OrdersTaxStatus" , method = RequestMethod.PUT)

    public @ResponseBody OrdersTaxStatus update(@RequestBody OrdersTaxStatus item) {

    	return repository.save(item);

    } 

    

    @RequestMapping(value = "/OrdersTaxStatus" , method = RequestMethod.DELETE)

    public void delete(@RequestBody OrdersTaxStatus item) {

    	repository.delete(item);

        //do business logic

    } 

}
