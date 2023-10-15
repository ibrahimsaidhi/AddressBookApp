package org.example;

import jakarta.persistence.*;

import java.io.Serial;
import java.io.Serializable;

/**
 * Displays the information about my buddies
 * @author Ibrahim Said
 * @version 1.0
 */
@Entity
public class BuddyInfo implements Serializable {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    private String buddyName;
    private String buddyNumber;

    @ManyToOne
    private AddressBook book;

    private String completeBuddyInfo;
    public BuddyInfo(){}

    public BuddyInfo(String buddyName, String buddyNumber){
        this.buddyName = buddyName;
        this.buddyNumber = buddyNumber;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public String getCompleteBuddyInfo() {
        return completeBuddyInfo;
    }
    /**
     * gets the name of this buddy
     * @return buddyName
     */
    public String getBuddyName() {
        return buddyName;
    }

    /**
     * gets the number of this buddy
     * @return buddyNumber
     */
    public String getBuddyNumber() {
        return buddyNumber;
    }

    /**
     * sets this buddy's name to the one given in the parameter
     * @param buddyName
     */
    public void setBuddyName(String buddyName) {
        this.buddyName = buddyName;
    }

    /**
     * sets this buddy's number to the one given in the parameter
     * @param buddyNumber
     */
    public void setBuddyNumber(String buddyNumber) {
        this.buddyNumber = buddyNumber;
    }

    @Override
    public String toString() {
        return "Buddy Name: " + buddyName + ", Buddy Number: " + buddyNumber;
    }

    /**
     * displays this buddy's information on the console
     */
    public void display(){
        completeBuddyInfo = "id: "+ id + " Buddy Name: " + buddyName + ", Buddy Number: " + buddyNumber;
        System.out.println(completeBuddyInfo);
    }


    public void setBook(AddressBook book) {
        this.book = book;
    }
}
