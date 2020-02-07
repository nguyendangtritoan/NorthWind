
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

public class OrderDetailsStatusController {

	@Autowired

	private OrderDetailsStatusRepository repository;
	
    @RequestMapping(value = "/OrderDetailsStatus" , method = RequestMethod.POST)

    public @ResponseBody OrderDetailsStatus create(@RequestBody OrderDetailsStatus item) {

    	return repository.save(item);

    }  

	

    @RequestMapping("/OrderDetailsStatus")

    public Iterable<OrderDetailsStatus> municipalities(@RequestParam(value="name", defaultValue="World") String name) {

        return repository.findAll();

    }    

    

    @RequestMapping("/OrderDetailsStatus/{id}")

    public Optional<OrderDetailsStatus> get(@PathVariable("id") int id) {
        return repository.findById(id);
    }    



    @RequestMapping(value = "/OrderDetailsStatus" , method = RequestMethod.PUT)

    public @ResponseBody OrderDetailsStatus update(@RequestBody OrderDetailsStatus item) {

    	return repository.save(item);

    } 

    

    @RequestMapping(value = "/OrderDetailsStatus" , method = RequestMethod.DELETE)

    public void delete(@RequestBody OrderDetailsStatus item) {

    	repository.delete(item);

        //do business logic

    } 

}
