package com.skypedal.skypedal_backend.entities;

import com.skypedal.skypedal_backend.dto.ActivityDTO;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "activities")
public class Activity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String date;
//    private JSON gps; placeholder
    private String activity_time;
    private int distance;
    private String type;
    @ManyToOne
    private User user;
    private List<Integer> joined_friends;
    private int co2_saving;
    private int cost_saving;
    private int points_earned;


    public Activity(){}

    public Activity(ActivityDTO activityDTO, User user) {
        this.id = activityDTO.getId();
        this.user = user;
        this.date = activityDTO.getDate();
        this.activity_time = activityDTO.getActivity_time();
        this.distance = activityDTO.getDistance();
        this.type = activityDTO.getType();
        this.joined_friends = activityDTO.getJoined_friends();
        this.co2_saving = activityDTO.getCo2_saving();
        this.cost_saving = activityDTO.getCost_saving();
        this.points_earned = activityDTO.getPoints_earned();
    }

    public int getId() {return id;}

    public String getDate() {return date;}

    public void setDate(String date) {this.date = date;}

    public String getActivity_time() {return activity_time;}

    public void setActivity_time(String activity_time) {this.activity_time = activity_time;}

    public int getDistance() {return distance;}

    public void setDistance(int distance) {this.distance = distance;}

    public String getType() {return type;}

    public void setType(String type) {this.type = type;}

    public User getUser() {return user;}

    public void setUser(User user) {this.user = user;}

    public List<Integer> getJoined_friends() {return joined_friends;}

    public void setJoined_friends(List<Integer> joined_friends) {this.joined_friends = joined_friends;}

    public int getCo2_saving() {return co2_saving;}

    public void setCo2_saving(int co2_saving) {this.co2_saving = co2_saving;}

    public int getCost_saving() {return cost_saving;}

    public void setCost_saving(int cost_saving) {this.cost_saving = cost_saving;}

    public int getPoints_earned() {return points_earned;}

    public void setPoints_earned(int points_earned) {this.points_earned = points_earned;}
}
