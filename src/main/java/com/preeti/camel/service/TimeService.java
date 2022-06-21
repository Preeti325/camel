package com.preeti.camel.service;

import com.preeti.camel.dto.Time;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

@Service
public class TimeService {

    private List<Time> list = new ArrayList<>();

    @PostConstruct
    public void initDB() {
        Calendar c = Calendar.getInstance();
        int timeOfDay = c.get(Calendar.HOUR_OF_DAY);
        if (timeOfDay < 12) {
            list.add(new Time("Good Morning","Nitu Gupta"));
        } else if (timeOfDay < 16) {
            list.add(new Time("Good Afternoon", "Nitu Gupta"));
        } else if (timeOfDay < 21) {
            list.add(new Time("Good Evening", "Nitu Gupta"));
        } else {
            list.add(new Time("Good Night", "Nitu Gupta"));
        }
    }

    public void addTimeStatus(Time time) {
        list.add(time);
    }

    public List<Time> getTimeStatus() {
        return list;
    }
}
