package com.crm.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import javax.validation.Valid;
import com.crm.model.Logement;
import com.crm.services.LogementServices;

@RestController
@CrossOrigin("*") //you can put the exact url instead of * (= all ursls)
public class Controller {
	
		@Autowired
	LogementServices logementServices;
		
// @RequestMapping(value="/logement" , method = RequestMethod.GET)
//	public String getLogement() {
//	 return "test";
// }
 
/*
 * http://localhost:8082/logement/1
 * 
 * {
    "intitule": "LogementTestupdate",
	"prix": 12.0,
}
 */
	
		@RequestMapping(value="/logements" ,method=RequestMethod.GET)
		public List<Logement> GetLogement(){
			return logementServices.getAllLogements();
		}
		
		@RequestMapping(value="/logement/{id}" ,method=RequestMethod.GET)
		public Optional<Logement> GetLogementById(@PathVariable("id") String id){
			return logementServices.findLogementById(Long.parseLong(id));
		}
		
		@RequestMapping(value="/logement" ,method=RequestMethod.POST)
		public Logement AddLogement(@Valid @RequestBody Logement logement){
			return logementServices.addLogements(logement);
		}
		
		@RequestMapping(value="/logement/{id}" ,method=RequestMethod.PUT)
		public Optional<Logement> updateLogement(@PathVariable("id") String id,@Valid @RequestBody Logement logement){
			return logementServices.updateLogementById(logement, Long.parseLong(id));
		}
		
		@RequestMapping(value="/logement/{id}" ,method=RequestMethod.DELETE)
		public ResponseEntity<?> deleteLogementById(@PathVariable("id") String id){
			 logementServices.deleteLogementById(Long.parseLong(id));
			 return ResponseEntity.ok().body("Logement "+ id + " supprime");	 
		}
		
		@RequestMapping(value="/logements/{ids}" ,method=RequestMethod.DELETE)
		public ResponseEntity<?> deleteLogementByIds(@PathVariable("ids") List<String> ids){
			
			ids.forEach(d ->{
				if(logementServices.existById(Long.parseLong(d))) {
					logementServices.deleteLogementById(Long.parseLong(d));
				}
			});
				 return ResponseEntity.ok().body("Logements supprimees");	 
		}
 
}
