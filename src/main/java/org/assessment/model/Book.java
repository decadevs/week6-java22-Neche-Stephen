package org.assessment.model;

public class Book {

    String title;
    int copy;

    public Book(String title, int copy) {
        this.title = title;
        this.copy = copy;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getCopy() {
        return copy;
    }

    public void setCopy(int copy) {
        this.copy = copy;
    }


}
