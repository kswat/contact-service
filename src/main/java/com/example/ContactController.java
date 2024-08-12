package com.example;

import java.util.Random;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ContactController {
    private static final Logger log = LoggerFactory.getLogger(ContactController.class);

    private final ContactService contactService;
    public ContactController(ContactService contactService) {
        this.contactService = contactService;
    }

    @RequestMapping(value="/customer/{cid}/contactdetails", method=RequestMethod.GET)
	public ContactDetails getCustomerContactDetails(@PathVariable String cid) throws InterruptedException {
        log.info("Received a ContactDetails request");
        //add arbitrary latency
		return contactService.getDetails(cid);
    }
    
}
