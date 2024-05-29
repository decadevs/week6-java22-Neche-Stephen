package org.assessment.model;

import java.util.Comparator;

public class RequestBookComparator implements Comparator<Person> {

    // Override compare method to define ordering by using enum ordinal value
//    @Override
//    public int compare(Person p1, Person p2) {
//        return Integer.compare(p1.role.ordinal(), p2.role.ordinal());
//    }

    @Override
    public int compare(Person p1, Person p2) {
        int priorityComparison = Integer.compare(p1.getPriorityLevel(), p2.getPriorityLevel());
        if (priorityComparison != 0) {
            return priorityComparison;
        }
        // Secondary comparison by request time to ensure FIFO order for equal priority levels
        return Long.compare(p1.getRequestTime(), p2.getRequestTime());
    }
}
