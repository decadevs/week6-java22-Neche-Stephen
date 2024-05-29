package org.assessment.service.Impl;

import org.assessment.model.Book;
import org.assessment.model.Library;
import org.assessment.model.Person;
import org.assessment.service.PersonService;

import java.util.Queue;

public class PersonServiceImpl implements PersonService {


    @Override
    public void studentRequest(Person student, String bookTitle, Library library, Queue<Person> borrowers, long requestTime) {
        // Search for the Book with the title
//        boolean foundBook = false;
//        for (Book libraryBook : library.getBooks()) {
//            if (libraryBook.getTitle().equals(bookTitle)) {
//                foundBook = true;
//                break; // Exit the loop once the Book is found
//            }
//        }
        boolean foundBook = library.getBooks().stream()
                .anyMatch(book -> book.getTitle().equals(bookTitle));
        if (foundBook) {
            student.setRequestTime(requestTime);
            borrowers.add(student);
            System.out.println(student.getName() +" - " + student.getRole() + " added to the list of borrowers");
        }
        else{
            System.out.println("Book with title \"" + bookTitle + "\" not found.");
        }

    }

    @Override
    public void teacherRequest(Person teacher, String bookTitle, Library library, Queue<Person> borrowers, long requestTime) {
        // Search for the Book with the title
//        boolean foundBook = false;
//        for (Book libraryBook : library.getBooks()) {
//            if (libraryBook.getTitle().equals(bookTitle)) {
//                foundBook = true;
//                break; // Exit the loop once the Book is found
//            }
//        }
        boolean foundBook = library.getBooks().stream()
                .anyMatch(book -> book.getTitle().equals(bookTitle));
        if (foundBook) {
            teacher.setRequestTime(requestTime);
            borrowers.add(teacher);
            System.out.println(teacher.getName() +" - " + teacher.getRole() + " added to the list of borrowers");
        }
        else{
            System.out.println("Book with title \"" + bookTitle + "\" not found.");
        }
        }
}
