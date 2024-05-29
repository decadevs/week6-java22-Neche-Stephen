package org.assessment.service;

import org.assessment.model.Book;
import org.assessment.model.Library;
import org.assessment.model.Person;

import java.util.Queue;

public interface LibraryService {

    void addBookToLibrary(Library library, Book book);
    void lendBook(Book book, Queue<Person> borrowers );

}
