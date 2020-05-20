package com.yube.controllers;

import com.yube.dto.Notification;
import com.yube.services.NotificationsService;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/notifications")
public class NotificationsController {

    private final NotificationsService notificationsService;

    public NotificationsController() {
        this.notificationsService = new NotificationsService();
    }

    @GET
    @Path("/all")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Notification> getNotifications() {
        return notificationsService.getAllNotifications();
    }

    @GET
    @Path("/last/{count}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Notification> getLastNotifications(@PathParam("count") int count) {
        return notificationsService.getLastNotifications(count);
    }
}
