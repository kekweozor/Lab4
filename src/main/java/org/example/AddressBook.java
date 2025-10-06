package org.example;
import jakarta.persistence.*;


import java.util.ArrayList;
import java.util.List;

@Entity
public class AddressBook {
    @OneToMany(mappedBy = "addressBook", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<BuddyInfo> addressList;
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;


    public AddressBook() {
        addressList = new ArrayList<>();
    }


    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void addBuddy(BuddyInfo info) {
        if (info != null) {
            addressList.add(info);
        }
    }

    public void removeBuddy(BuddyInfo info) {
        addressList.remove(info);
    }


    public List<BuddyInfo> getAddressList()
    {
        return addressList;
    }

    public void setAddressList(List<BuddyInfo> addressList) {
        this.addressList = addressList;
    }

    public String toString() {
        String output = "";
        output += "ADDRESS LIST:\n";
        for (BuddyInfo info : addressList) {
            output += info.toString() + "\n";
            output += "-------------------------------------------------------------------------------------------" + "\n";
        }

        return output;
    }
//    public static void main (String[] args) {
//
//
//        AddressBook aBook = new AddressBook();
//
//        BuddyInfo info1 = new BuddyInfo("Ryan", "2232 Frenchie Street", "6136129941");
//        aBook.addBuddy(info1);
//    //instantiated an object of the class addressbook
//
//        System.out.print(aBook.toString());
//
//    }
}
