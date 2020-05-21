package com.yube.xml.processors;

import com.yube.dto.Notification;
import com.yube.xml.transformers.NotificationTransformer;
import org.dom4j.Document;
import org.dom4j.Element;

import java.util.ArrayList;
import java.util.List;

public class NotificationsProcessor extends AbstractProcessor {

    public NotificationsProcessor(Document document) {
        super(document);
    }

    public List<Notification> getLastNotifications(int n) {
        List lastNotifications = document.selectNodes("//descendant::Notification[position()>last()-" + n + "]");
        if (lastNotifications == null) throw new IllegalArgumentException("Can't get last Notifications");
        return mapNotifications(lastNotifications);
    }

    public List<Notification> getAllNotifications() {
        List notifications = document.selectNodes("//Notification");
        if (notifications == null) throw new IllegalArgumentException("Can't get last Notifications");
        return mapNotifications(notifications);
    }

    public int getNotificationsCount() {
        return document.numberValueOf("count(//Notification)").intValue();
    }

    public Notification getNotificationByPosition(int position) {
        Element notification = (Element) document.selectSingleNode("//descendant::Notification[position()=last()-" + position + "]");
        if (notification == null) throw new IllegalArgumentException("Can't get such Notification");
        return mapNotification(notification);
    }

    private List<Notification> mapNotifications(List notificationNodes) {
        List<Notification> notifications = new ArrayList<>();
        notificationNodes.forEach(o -> notifications.add(mapNotification(o)));
        return notifications;
    }

    private Notification mapNotification(Object notificationNode) {
        return NotificationTransformer.createNotification((Element) notificationNode);
    }
}
