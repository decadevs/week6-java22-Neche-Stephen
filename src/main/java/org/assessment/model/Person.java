package org.assessment.model;

import org.assessment.enums.Role;

import java.util.ArrayList;
import java.util.List;

public class Person {
    String name;
    int priorityLevel;
    Role role;
    List<Book> booksBorrowed = new ArrayList<>();
    private long requestTime;

    public Person(String name, int priorityLevel, Role role) {
        this.name = name;
        this.priorityLevel = priorityLevel;
        this.role = role;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPriorityLevel() {
        return priorityLevel;
    }

    public void setPriorityLevel(int priorityLevel) {
        this.priorityLevel = priorityLevel;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public List<Book> getBooksBorrowed() {
        return booksBorrowed;
    }

    public void setBooksBorrowed(List<Book> booksBorrowed) {
        this.booksBorrowed = booksBorrowed;
    }

    public long getRequestTime() {
        return requestTime;
    }

    public void setRequestTime(long requestTime) {
        this.requestTime = requestTime;
    }

    // Override compareTo method to define ordering by using enum ordinal value
//    @Override
//    public int compareTo(Person other) {
//        return Integer.compare(this.role.ordinal(), other.role.ordinal());
//    }

    // Override compareTo method to define ordering
//    @Override
//    public int compareTo(Person other) {
////        return Integer.compare(this.priorityLevel, other.priorityLevel);
//        return 0;
//    }
}
