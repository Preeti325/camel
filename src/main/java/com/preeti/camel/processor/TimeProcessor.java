package com.preeti.camel.processor;

import com.preeti.camel.dto.Time;
import com.preeti.camel.service.TimeService;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TimeProcessor implements Processor {

    @Autowired
    private TimeService service;

    @Override
    public void process(Exchange exchange) throws Exception {
        service.addTimeStatus(exchange.getIn().getBody(Time.class));
    }

}
