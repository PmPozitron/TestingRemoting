package pmp.testingremoting.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import pmp.testingremoting.service.ContactService;

import javax.annotation.Resource;

/**
 * Created by Pozitron on 18.09.2016.
 */
@RestController(ContactController.QUALIFIER)
@RequestMapping(ContactController.MAPPING)
public class ContactController {

    public static final String QUALIFIER = "contactController";
    public static final String MAPPING = "/contact";

    @Autowired
    private ContactService serviceInvoker;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<String> findAll() {
        return new ResponseEntity<String>(serviceInvoker.findAll().toString(), HttpStatus.OK);
    }
}
