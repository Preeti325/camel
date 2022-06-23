package com.preeti.camel.resource;

import com.preeti.camel.dto.Time;
import com.preeti.camel.processor.TimeProcessor;
import com.preeti.camel.service.TimeService;
import org.apache.camel.BeanInject;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.rest.RestBindingMode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;

@Component
public class ApplicationResource extends RouteBuilder {

    @Autowired
    private TimeService service;

    @BeanInject
    private TimeProcessor processor;

    @Override
    public void configure() throws Exception {
        restConfiguration().component("servlet").port(9090).host("localhost").bindingMode(RestBindingMode.json);

        rest().get("/hello-world").produces(MediaType.APPLICATION_JSON_VALUE).route()
                .setBody(constant("Welcome")).endRest();

        rest().get("/getOrders").produces(MediaType.APPLICATION_JSON_VALUE).route().setBody(() -> service.getTimeStatus())
                .endRest();

        rest().post("/addOrder").consumes(MediaType.APPLICATION_JSON_VALUE).type(Time.class).outType(Time.class)
                .route().process(processor).endRest();
    }

}

