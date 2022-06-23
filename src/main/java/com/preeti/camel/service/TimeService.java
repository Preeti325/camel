package com.preeti.camel.service;

import static com.preeti.camel.constants.Constant.Name;
import static com.preeti.camel.constants.Constant.Status1;
import static com.preeti.camel.constants.Constant.Status2;
import static com.preeti.camel.constants.Constant.Status3;
import static com.preeti.camel.constants.Constant.Status4;
import static com.preeti.camel.constants.Constant.list;

import com.preeti.camel.dto.Time;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.Calendar;
import java.util.List;

@Service
public class TimeService {

    @PostConstruct
    public void initDB() {
    }

    private void status() {
        Calendar c = Calendar.getInstance();
        int timeOfDay = c.get(Calendar.HOUR_OF_DAY);
        if (timeOfDay < 12) {
            list.add(new Time(Status1, Name));
        } else if (timeOfDay < 16) {
            list.add(new Time(Status2, Name));
        } else if (timeOfDay < 21) {
            list.add(new Time(Status3, Name));
        } else {
            list.add(new Time(Status4, Name));
        }

    }

    public void addTimeStatus(Time time) {
        list.add(time);
    }

    public List<Time> getTimeStatus() {
        status();
        return list;
    }

    @PreDestroy
    public void destroy() {
    }
}