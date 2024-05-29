package org.assessment.service;

import org.assessment.model.Library;
import org.assessment.model.Person;

import java.util.Queue;

public interface PersonService {
    void studentRequest(Person student, String bookTitle, Library library, Queue<Person> borrowers, long requestTime);
    void teacherRequest(Person teacher, String bookTitle, Library library, Queue<Person> borrowers, long requestTime);
}
