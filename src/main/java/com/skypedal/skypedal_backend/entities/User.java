package com.skypedal.skypedal_backend.entities;
import jakarta.persistence.*;
import com.skypedal.skypedal_backend.dto.UserDTO;


@Entity
@Table(name="users")
public class User {
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id;
    private String email;
    private String firstName;
    private String lastName;
    private int rewardPoints;
    private String officeLocation;

    public User(){
        super();
    }

    public User(String email, String password, String firstName, String lastName, Integer rewardPoints, String officeLocation){
        this.email = email;
        this.firstName = firstName;
        this.rewardPoints = rewardPoints;
        this.officeLocation = officeLocation;

    }

    public User (UserDTO userdto){
        this.firstName = userdto.getFirstName();
        this.lastName = userdto.getLastName();
        this.email = userdto.getEmail();
        this.rewardPoints = userdto.getRewardPoints();
        this.officeLocation = userdto.getOfficeLocation();
    }

    // Getters and Setters
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getRewardPoints() {
        return rewardPoints;
    }

    public void setRewardPoints(int rewardPoints) {
        this.rewardPoints = rewardPoints;
    }


    public String getOfficeLocation() {
        return officeLocation;
    }

    public void setOfficeLocation(String officeLocation) {
        this.officeLocation = officeLocation;
    }


}
