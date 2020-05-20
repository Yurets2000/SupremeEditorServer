package com.yube.services;

import com.yube.dto.Notification;
import com.yube.xml.documents.XmlDocument;
import com.yube.xml.processors.NotificationsProcessor;
import org.dom4j.DocumentException;

import java.util.List;

public class NotificationsService {

    private NotificationsProcessor notificationsProcessor;

    public NotificationsService() {
        try {
            this.notificationsProcessor = new NotificationsProcessor(XmlDocument.getInstance("notifications.xml").getDocument());
        } catch (DocumentException e) {
            e.printStackTrace();
        }
    }

    public List<Notification> getLastNotifications(int n) {
        return notificationsProcessor.getLastNotifications(n);
    }

    public List<Notification> getAllNotifications() {
        return notificationsProcessor.getAllNotifications();
    }
}
