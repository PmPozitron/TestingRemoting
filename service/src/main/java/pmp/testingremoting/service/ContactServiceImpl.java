package pmp.testingremoting.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.google.common.collect.Lists;
import pmp.testingremoting.dao.ContactRepository;
import pmp.testingremoting.model.Contact;

import javax.annotation.PostConstruct;

@Repository(ContactService.QUALIFIER)
@Transactional
public class ContactServiceImpl implements ContactService {

    @Autowired
    private ApplicationContext context;

    @PostConstruct
    public void whatsGoingOn() {
        System.out.println(context.getApplicationName());
    }

    @Autowired
    private ContactRepository contactRepository;

    @Override
    @Transactional(readOnly=true)
    public List<Contact> findAll() {
        return Lists.newArrayList(contactRepository.findAll());
    }

    @Override
    @Transactional(readOnly=true)
    public List<Contact> findByFirstName(String firstName) {
        return contactRepository.findByFirstName(firstName);
    }

    @Override
    @Transactional(readOnly=true)
    public Contact findById(Long id) {
        return contactRepository.findOne(id);
    }

    @Override
    public Contact save(Contact contact) {
        return contactRepository.save(contact);
    }

    @Override
    public void delete(Contact contact) {
        contactRepository.delete(contact);
    }
}
