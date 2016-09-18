package pmp.testingremoting.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import pmp.testingremoting.model.Contact;

public interface ContactRepository extends CrudRepository<Contact, Long> {
    List<Contact> findByFirstName(String firstName);
}
