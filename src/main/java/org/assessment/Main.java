package org.assessment;

import org.assessment.enums.Role;
import org.assessment.model.Book;
import org.assessment.model.Library;
import org.assessment.model.Person;
import org.assessment.model.RequestBookComparator;
import org.assessment.service.Impl.LibraryServiceImpl;
import org.assessment.service.Impl.PersonServiceImpl;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class Main {
    //    Define the priority levels
    static final int TEACHER_PRIORITY = 1;
    static final int SENIOR_STUDENT_PRIORITY = 2;
    static final int JUNIOR_STUDENT_PRIORITY = 3;

    public static void  main(String[] args) {

        // Create Teacher Object
        Person teacher = new Person("Mr Ojo", TEACHER_PRIORITY, Role.TEACHER);

        // Create Senior Student Object
        Person seniorStudent1 = new Person("Henry", SENIOR_STUDENT_PRIORITY, Role.SENIOR_STUDENT);

        // Create Senior Student Object
        Person seniorStudent2 = new Person("Harry", SENIOR_STUDENT_PRIORITY, Role.SENIOR_STUDENT);

        // Create Junior Student Object
        Person juniorStudent1 = new Person("Patrick", JUNIOR_STUDENT_PRIORITY, Role.JUNIOR_STUDENT);

        // Create Junior Student Object
        Person juniorStudent2 = new Person("Bright", JUNIOR_STUDENT_PRIORITY, Role.JUNIOR_STUDENT);

        // Create book objects
        Book yellow_sun = new Book("Half of a yellow sun", 2);
        Book things_fall_apart = new Book("Things fall apart", 1);

        // Create Library Object
        Library library = new Library();

        // Create libraryService Implementation Object
        LibraryServiceImpl libraryService = new LibraryServiceImpl();

        // Create PersonService Implementation Object
        PersonServiceImpl personService = new PersonServiceImpl();

        // Add book to library
        libraryService.addBookToLibrary(library, yellow_sun);
        libraryService.addBookToLibrary(library, things_fall_apart );

        System.out.println("***********************");
        System.out.println();

        System.out.println("BORROWING BOOK WITH PRIORITY");

         // Create Priority Queue with comparator to determine priority
//        Queue<Person> yellow_sun_borrowers = new PriorityQueue<>(new RequestBookComparator());
        Queue<Person> yellow_sun_borrowers = new PriorityQueue<>(
                Comparator.comparingInt(Person::getPriorityLevel)
                        .thenComparingLong(Person::getRequestTime)
        );

        // Implement Request for Book by the student and teacher
        personService.studentRequest(juniorStudent1, "Half of a yellow sun", library,  yellow_sun_borrowers, System.currentTimeMillis());
        personService.studentRequest(seniorStudent1, "Half of a yellow sun", library,  yellow_sun_borrowers, System.currentTimeMillis());
        personService.teacherRequest(teacher, "Half of a yellow sun", library,  yellow_sun_borrowers, System.currentTimeMillis());
        // Add more students to the queue
       // personService.studentRequest(juniorStudent2, "Half of a yellow sun", library,  yellow_sun_borrowers, System.currentTimeMillis());
       // personService.studentRequest(seniorStudent2, "Half of a yellow sun", library,  yellow_sun_borrowers, System.currentTimeMillis());
        System.out.println(); // Create new line for console

        // Implement Borrow book by the library
        libraryService.lendBookNew(yellow_sun, yellow_sun_borrowers);
        System.out.println("***********************");
        System.out.println();// Create new line for console

        System.out.println("BORROWING BOOK WITHOUT PRIORITY");
        // Create a LinkedList-based Queue to give books based on First In First Out - FIFO
        Queue<Person> thing_fall_apart_borrowers = new LinkedList<>();

       // Implement Request for Book by the student and teacher
        personService.studentRequest(juniorStudent1, "Things fall apart", library,  thing_fall_apart_borrowers, System.currentTimeMillis());
        personService.studentRequest(seniorStudent1, "Things fall apart", library,  thing_fall_apart_borrowers, System.currentTimeMillis());
        personService.teacherRequest(teacher, "Things fall apart", library,  thing_fall_apart_borrowers, System.currentTimeMillis());

        // Add more students to the queue
        personService.studentRequest(juniorStudent2, "Things fall apart", library,  thing_fall_apart_borrowers, System.currentTimeMillis());
        personService.studentRequest(seniorStudent2, "Things fall apart", library,  thing_fall_apart_borrowers, System.currentTimeMillis());
        System.out.println();

       // Implement Borrow book by the library
        libraryService.lendBookNew(things_fall_apart, thing_fall_apart_borrowers);









    }
}