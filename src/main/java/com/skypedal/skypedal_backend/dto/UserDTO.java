package com.skypedal.skypedal_backend.dto;
import com.skypedal.skypedal_backend.entities.User;



public class UserDTO {
    private String firstName;
    private String lastName;
    private String email;
    private int rewardPoints;
    private String officeLocation;

    public UserDTO (){
        super();
    }

    public UserDTO (String firstName, String lastName, String email, Integer rewardPoints, String officeLocation){
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.rewardPoints = rewardPoints;
        this.officeLocation = officeLocation;
    }

    public UserDTO (User user){
        this.firstName = user.getFirstName();
        this.lastName = user.getLastName();
        this.email = user.getEmail();
        this.rewardPoints = user.getRewardPoints();
        this.officeLocation = user.getOfficeLocation();
    }

    // Getters and Setters
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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
