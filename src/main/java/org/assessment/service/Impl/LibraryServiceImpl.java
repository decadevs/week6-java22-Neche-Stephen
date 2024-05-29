package org.assessment.service.Impl;

import org.assessment.model.Book;
import org.assessment.model.Library;
import org.assessment.model.Person;
import org.assessment.service.LibraryService;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.stream.Collectors;

public class LibraryServiceImpl implements LibraryService {

    @Override
    public void addBookToLibrary(Library library, Book book) {
        List<Book> books = library.getBooks();
        books.add(book);
        if (book.getCopy() > 1){
            System.out.println(book.getCopy() + " copies of " + book.getTitle() + " Added to the library");
        }
        else if (book.getCopy() == 1){
            System.out.println(book.getCopy() + "copy of " + book.getTitle() + " Added to the library");
        }

    }


    @Override
    public void lendBook(Book book,  Queue<Person> borrowers ) {
        int copies = book.getCopy(); // Get copies of books available
        int copiesGiven = 0; // Get count of copies of books given
        int numOfBorrowers = borrowers.size();
        if (copies <= 0){
            System.out.println("Book Taken");
        }
        else {
            for (int i = 1; i <= copies && i <= numOfBorrowers ; i++){
                // Get person to lend book
                Person person = borrowers.poll();

                // Get list of books borrowed
                List<Book> booksBorrowed = person.getBooksBorrowed();

                // Add a new book to list of books borrowed
                booksBorrowed.add(book);

                copiesGiven++;

                System.out.println("Book lent to " + person.getRole() + " - " +  person.getName());
            }

            if (borrowers.size() > 0){
                borrowers.forEach((person -> {
                    System.out.println("Sorry " + person.getName() + " - " +  person.getRole() + ", Book Taken" );
                }));
//                for (Person person : borrowers){
//                    System.out.println("Sorry " + person.getName() + " - " +  person.getRole() + ", Book Taken" );
//                }
            }

            // Subtract books given from copy of books
            book.setCopy(book.getCopy() - copiesGiven );

            System.out.println("Copies of " + book.getTitle() + " remaining is : " + book.getCopy());

        }

    }


}
