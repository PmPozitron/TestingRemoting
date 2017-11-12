package pmp.testingremoting.service;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import static java.util.Arrays.asList;

@Service
public class ContactServiceImpl implements ContactService{

    public List<String> getContacts() {
        return new ArrayList<String>(asList("karl marx", " fridrih engels", " !!!"));
    }


}
