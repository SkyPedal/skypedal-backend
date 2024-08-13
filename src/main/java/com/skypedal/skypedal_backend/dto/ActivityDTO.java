package com.skypedal.skypedal_backend.dto;

import com.skypedal.skypedal_backend.entities.Activity;
import com.skypedal.skypedal_backend.entities.User;

import java.util.List;

public class ActivityDTO {
    private int id;

    private String date;
    //    private JSON gps; placeholder
    private String activity_time;
    private int distance;
    private String type;
    private List<Integer> joined_friends;
    private int co2_saving;
    private int cost_saving;
    private int points_earned;

    public ActivityDTO(String date, String activity_time, int distance, String type, List<Integer> joined_friends, int co2_saving, int cost_saving, int points_earned) {
        this.date = date;
        this.activity_time = activity_time;
        this.distance = distance;
        this.type = type;
        this.joined_friends = joined_friends;
        this.co2_saving = co2_saving;
        this.cost_saving = cost_saving;
        this.points_earned = points_earned;
    }

    public ActivityDTO(Activity activity) {
        this.id = activity.getId();
        this.date = activity.getDate();
        this.activity_time = activity.getActivity_time();
        this.distance = activity.getDistance();
        this.type = activity.getType();
        this.joined_friends = activity.getJoined_friends();
        this.co2_saving = activity.getCo2_saving();
        this.cost_saving = activity.getCost_saving();
        this.points_earned = activity.getPoints_earned();
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

    public List<Integer> getJoined_friends() {return joined_friends;}

    public void setJoined_friends(List<Integer> joined_friends) {this.joined_friends = joined_friends;}

    public int getCost_saving() {return cost_saving;}

    public void setCost_saving(int cost_saving) {this.cost_saving = cost_saving;}

    public int getCo2_saving() {return co2_saving;}

    public void setCo2_saving(int co2_saving) {this.co2_saving = co2_saving;}

    public int getPoints_earned() {return points_earned;}

    public void setPoints_earned(int points_earned) {this.points_earned = points_earned;}
}

