package org.example;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.*;

/**
 * A book that contains the info of some buddies
 * @author Ibrahim Said
 * @version 1.0
 */

/**
 * Class constructors
 */
@Entity
public class AddressBook implements Serializable {
    private long id;

    private List<BuddyInfo> buddies = new ArrayList<BuddyInfo>();
    private String nameOfBook;
    public AddressBook(){};

    public AddressBook(String bookName){
        this.nameOfBook = bookName;
    }

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    /**
     * gets the list of buddies in the current book
     * @return buddies
     */

    @OneToMany(cascade = CascadeType.ALL)
    public List<BuddyInfo> getBuddies() {
        return buddies;
    }

    public void setBuddies(List<BuddyInfo> buddies) {
        this.buddies = buddies;
    }

    /**
     * adds the info of a buddy to the book
     * @param info
     */
    public void addBuddyInfo(BuddyInfo info){
        buddies.add(info);
    }

    public void setNameOfBook(String nameOfBook) {
        this.nameOfBook = nameOfBook;
    }

    public String getNameOfBook() {
        return nameOfBook;
    }

    @Override
    public String toString() {
        String s = "[AddressBook: ";
        for (BuddyInfo b: buddies){
            s = s.concat(b.toString());
            s += "\n";
        }
        s += " ]";
        return s;
    }

    /**
     * removes the implied buddy from the book
     * @param info
     */
    public void removeBuddyInfo(BuddyInfo info){
        buddies.remove(info);
    }

    /**
     * displays all buddies currently in the book
     */
    public void display(){
        for (BuddyInfo info  : buddies){
            info.display();
        }
    }
}
