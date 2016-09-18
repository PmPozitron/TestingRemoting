package pmp.testingremoting.service;
import pmp.testingremoting.model.Contact;

import java.util.List;

public interface ContactService {
    List<Contact> findAll();
    List<Contact> findByFirstName(String firstName);
    Contact findById(Long id);
    Contact save(Contact contact);
    void delete(Contact contact);
}