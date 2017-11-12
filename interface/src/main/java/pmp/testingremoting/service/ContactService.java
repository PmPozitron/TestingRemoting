package pmp.testingremoting.service;

import java.util.List;

public interface ContactService {

    public static final String QUALIFIER = "contactService";

    List<String> getContacts();
}