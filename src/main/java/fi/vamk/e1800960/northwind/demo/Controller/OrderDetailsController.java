
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

public class OrderDetailsController {

	@Autowired

	private OrderDetailsRepository repository;
	
    @RequestMapping(value = "/OrderDetails" , method = RequestMethod.POST)

    public @ResponseBody OrderDetails create(@RequestBody OrderDetails item) {

    	return repository.save(item);

    }  

	

    @RequestMapping("/OrderDetails")

    public Iterable<OrderDetails> municipalities(@RequestParam(value="name", defaultValue="World") String name) {

        return repository.findAll();

    }    

    

    @RequestMapping("/OrderDetails/{id}")

    public Optional<OrderDetails> get(@PathVariable("id") int id) {
        return repository.findById(id);
    }    



    @RequestMapping(value = "/OrderDetails" , method = RequestMethod.PUT)

    public @ResponseBody OrderDetails update(@RequestBody OrderDetails item) {

    	return repository.save(item);

    } 

    

    @RequestMapping(value = "/OrderDetails" , method = RequestMethod.DELETE)

    public void delete(@RequestBody OrderDetails item) {

    	repository.delete(item);

        //do business logic

    } 

}
