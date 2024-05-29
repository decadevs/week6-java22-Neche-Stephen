package org.assessment.service.Impl;

import org.assessment.enums.Role;
import org.assessment.model.Book;
import org.assessment.model.Library;
import org.assessment.model.Person;
import org.junit.jupiter.api.Test;

import java.util.PriorityQueue;
import java.util.Queue;

import static org.junit.jupiter.api.Assertions.*;

class PersonServiceImplTest {

    @Test
    public void testValidBookRequest() {
        // Create Library and Borrower Queue
        Library library = new Library();
        Queue<Person> borrowers = new PriorityQueue<>();

        // Add a Book to the Library
        Book book = new Book("Test Book", 5);
        library.getBooks().add(book);

        // Create Student and Teacher objects
        Person student = new Person("Henry", 2, Role.SENIOR_STUDENT);
        Person teacher = new Person("Jane", 1, Role.TEACHER);

        // Create PersonService Implementation Object
        PersonServiceImpl personService = new PersonServiceImpl();

        // Call the methods with valid book title
        personService.studentRequest(student, book.getTitle(), library, borrowers, System.currentTimeMillis());
        personService.teacherRequest(teacher, book.getTitle(), library, borrowers, System.currentTimeMillis());

        // Assertions - Check if borrowers queue has both student and teacher
        assertEquals(2, borrowers.size()); // Assert there are 2 people in the queue
        assertTrue(borrowers.contains(student)); // Assert student is in the queue
        assertTrue(borrowers.contains(teacher)); // Assert teacher is in the queue
    }

    @Test
    public void testNonExistentBookRequest() {
        // Create Library and Borrower Queue
        Library library = new Library();
        Queue<Person> borrowers = new PriorityQueue<>();

        // Create Student and Teacher objects
        Person student = new Person("Henry", 2, Role.SENIOR_STUDENT);
        Person teacher = new Person("Jane", 1, Role.TEACHER);

        // Create PersonService Implementation Object
        PersonServiceImpl personService = new PersonServiceImpl();

        // Call the methods with a non-existent book title
        personService.studentRequest(student, "Non-Existent Book", library, borrowers, System.currentTimeMillis());
        personService.teacherRequest(teacher, "Non-Existent Book", library, borrowers, System.currentTimeMillis());

        // Assertion - Check if borrowers queue remains empty
        assertEquals(0, borrowers.size()); // Assert there's no one in the queue
    }

}