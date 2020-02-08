
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

public class OrdersStatusController {

	@Autowired

	private OrdersStatusRepository repository;
	
    @RequestMapping(value = "/OrdersStatus" , method = RequestMethod.POST)

    public @ResponseBody OrdersStatus create(@RequestBody OrdersStatus item) {

    	return repository.save(item);

    }  

	

    @RequestMapping("/OrdersStatus")

    public Iterable<OrdersStatus> municipalities(@RequestParam(value="name", defaultValue="World") String name) {

        return repository.findAll();

    }    

    

    @RequestMapping("/OrdersStatus/{id}")

    public Optional<OrdersStatus> get(@PathVariable("id") int id) {
        return repository.findById(id);
    }    



    @RequestMapping(value = "/OrdersStatus" , method = RequestMethod.PUT)

    public @ResponseBody OrdersStatus update(@RequestBody OrdersStatus item) {

    	return repository.save(item);

    } 

    

    @RequestMapping(value = "/OrdersStatus" , method = RequestMethod.DELETE)

    public void delete(@RequestBody OrdersStatus item) {

    	repository.delete(item);

        //do business logic

    } 

}
