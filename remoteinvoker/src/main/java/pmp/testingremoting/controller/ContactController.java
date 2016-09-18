package pmp.testingremoting.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Pozitron on 18.09.2016.
 */
@RestController(ContactController.QUALIFIER)
@RequestMapping(ContactController.MAPPING)
public class ContactController {

    public static final String QUALIFIER = "contactController";
    public static final String MAPPING = "/contact";
}
