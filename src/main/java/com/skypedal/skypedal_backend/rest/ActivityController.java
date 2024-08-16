package com.skypedal.skypedal_backend.rest;

import com.skypedal.skypedal_backend.dto.ActivityDTO;
import com.skypedal.skypedal_backend.dto.NewActivityDTO;
import com.skypedal.skypedal_backend.entities.Activity;
import com.skypedal.skypedal_backend.entities.MyUserDetails;
import com.skypedal.skypedal_backend.services.ActivityService;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/activities")
public class ActivityController {
    private final ActivityService service;

    public ActivityController(ActivityService service) {
        this.service = service;
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("")
    public ActivityDTO add(@RequestBody NewActivityDTO activityDTO,
                           @AuthenticationPrincipal MyUserDetails userDetails) {
        return this.service.add(activityDTO, userDetails.id);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/getAll")
    public List<ActivityDTO> getAll(){
        return this.service.getAll();
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/getUserActivities")
    public List<ActivityDTO> getUserActivities(@RequestParam(required = true) Long userId){
        return this.service.getUsersActivities(userId);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/getById")
    public ActivityDTO getById(@RequestParam(required = true) Integer id){
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
