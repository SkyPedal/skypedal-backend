package com.skypedal.skypedal_backend.rest;

import com.skypedal.skypedal_backend.dto.ActivityDTO;
import com.skypedal.skypedal_backend.entities.Activity;
import com.skypedal.skypedal_backend.services.ActivityService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@CrossOrigin("http://localhost:5173")
@RestController
@RequestMapping("/activities")
public class ActivityController {
    private final ActivityService service;

    public ActivityController(ActivityService service) {
        this.service = service;
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/addActivity")
    public ActivityDTO add(@RequestBody ActivityDTO activityDTO, @RequestParam(required = true) Long userId) {
        return this.service.add(activityDTO, userId);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/getAll")
    public List<ActivityDTO> getAll(){
        return this.service.getAll();
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/getUserActivities")
    public List<Activity> getUserActivities(@RequestParam(required = true) Long userId){
        return this.service.getUsersActivities(userId);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/getById")
    public Activity getById(@RequestParam(required = true) Integer id){
        return this.service.getById(id);
    }

    @ResponseStatus(HttpStatus.OK)
    @PatchMapping("/updateActivity")
    public Activity updateActivity(@RequestBody ActivityDTO activityDTO, @RequestParam(required = true) Integer id) {
        return this.service.updateActivity(activityDTO, id);
    }

    @ResponseStatus(HttpStatus.OK)
    @DeleteMapping("/delete")
    public Activity removeActivity(@RequestParam(required = true) Integer id){
        return this.service.remove(id);
    }
}
