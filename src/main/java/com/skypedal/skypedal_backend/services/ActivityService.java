package com.skypedal.skypedal_backend.services;

import com.skypedal.skypedal_backend.dto.ActivityDTO;
import com.skypedal.skypedal_backend.dto.NewActivityDTO;
import com.skypedal.skypedal_backend.entities.Activity;
import com.skypedal.skypedal_backend.entities.User;
import com.skypedal.skypedal_backend.exceptions.ActivityNotFoundException;
import com.skypedal.skypedal_backend.exceptions.UserNotFoundException;
import com.skypedal.skypedal_backend.repo.ActivityRepo;
import com.skypedal.skypedal_backend.repo.UserRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ActivityService {
    private final ActivityRepo repo;
    private final UserRepo userRepo;

    public ActivityService(ActivityRepo repo, UserRepo userRepo) {
        this.repo = repo;
        this.userRepo = userRepo;
    }

    public ActivityDTO add(NewActivityDTO activityDTO, Long userId) {
        User user = userRepo.findById(userId).orElseThrow(UserNotFoundException::new);
        Activity activity = this.repo.save(new Activity(activityDTO, user));
        return new ActivityDTO(activity);
    }

    public List<ActivityDTO> getAll() {
        return this.repo.findAll().stream().map(ActivityDTO::new).toList();
    }

    public List<ActivityDTO> getUsersActivities(Long userId) {
        User user = userRepo.findById(userId).orElseThrow(UserNotFoundException::new);
        return this.repo.findByUser(user).stream().map(ActivityDTO::new).toList();
    }

    public ActivityDTO getById(Integer id){
        return new ActivityDTO(this.repo.findById(id).orElseThrow(ActivityNotFoundException::new));
    }

    public Activity updateActivity(ActivityDTO activityDTO, Integer id){
        Activity toUpdate = this.repo.findById(id).orElseThrow(ActivityNotFoundException::new);
        List<Integer> emptyList = List.of();

        if(activityDTO.getActivity_time() != null) toUpdate.setActivity_time(activityDTO.getActivity_time());
        if(activityDTO.getDate() != null) toUpdate.setDate(activityDTO.getDate());
        if(activityDTO.getDistance() != 0) toUpdate.setDistance(activityDTO.getDistance());
        if(activityDTO.getType() != null) toUpdate.setType(activityDTO.getType());
        if(activityDTO.getJoined_friends() != emptyList) toUpdate.setJoined_friends(activityDTO.getJoined_friends());
        if(activityDTO.getCo2_saving() != 0) toUpdate.setCo2_saving(activityDTO.getCo2_saving());
        if(activityDTO.getCost_saving() != 0) toUpdate.setCost_saving(activityDTO.getCost_saving());
        if(activityDTO.getPoints_earned() != 0) toUpdate.setPoints_earned(activityDTO.getPoints_earned());

        return this.repo.save(toUpdate);
    }

    public Activity remove(int id) {
        Activity found = this.repo.findById(id).orElseThrow(ActivityNotFoundException::new);
        this.repo.deleteById(id);
        return found;
    }
}
