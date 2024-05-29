package org.assessment.service.Impl;

import org.assessment.enums.Role;
import org.assessment.model.Book;
import org.assessment.model.Library;
import org.assessment.model.Person;
import org.assessment.model.RequestBookComparator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.PriorityQueue;
import java.util.Queue;

import static org.junit.jupiter.api.Assertions.*;

class LibraryServiceImplTest {
    private LibraryServiceImpl libraryService;
    private Book book;
    private Queue<Person> borrowers;
    private Library library;

    @BeforeEach
    public void setUp() {
        library = new Library();
        libraryService = new LibraryServiceImpl();
        book = new Book("Half of a yellow sun", 3);
        borrowers = new PriorityQueue<>(new RequestBookComparator());
        libraryService.addBookToLibrary(library, book);
    }

    @Test
    public void testLendBookRemainingCopies() {

        // Create Student and Teacher objects
        Person student = new Person("Henry", 2, Role.SENIOR_STUDENT);
        Person teacher = new Person("Jane", 1, Role.TEACHER);

        // Create PersonService Implementation Object
        PersonServiceImpl personService = new PersonServiceImpl();

        // Call the methods with valid book title
        personService.studentRequest(student, book.getTitle(), library, borrowers, System.currentTimeMillis());
        personService.teacherRequest(teacher, book.getTitle(), library, borrowers, System.currentTimeMillis());

        libraryService.lendBook(book, borrowers);

        assertEquals(1, book.getCopy());
    }


}