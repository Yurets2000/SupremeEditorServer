package com.yube.xml.transformers;

import com.yube.dto.Notification;
import com.yube.xml.exceptions.TransformationException;
import org.dom4j.Element;
import org.dom4j.dom.DOMElement;

import java.text.SimpleDateFormat;

public class NotificationTransformer {

    private final static SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");

    private NotificationTransformer() {
    }

    public static Notification createNotification(Element element){
        if (!element.getName().equals("Notification"))
            throw new TransformationException("Element name doesn't match 'Notification'");
        try {
            Notification notification = new Notification();
            notification.setId(Integer.parseInt(element.attributeValue("id")));
            notification.setPublishingDate(DATE_FORMAT.parse(element.elementText("PublishingDate")));
            notification.setDescription(element.elementText("Description"));
            notification.setHtmlContent(element.elementText("HtmlContent").replace("\n", ""));
            return notification;
        } catch (Exception ex) {
            throw new TransformationException("Can't transform passed Element to Notification object", ex);
        }
    }

    public static Element createElement(Notification notification){
        try {
            DOMElement element = new DOMElement("Notification");
            element.addAttribute("id", notification.getId().toString());
            DOMElement publishingDate = new DOMElement("PublishingDate");
            publishingDate.setText(DATE_FORMAT.format(notification.getPublishingDate()));
            element.add(publishingDate);
            DOMElement description = new DOMElement("Description");
            description.setText(notification.getDescription());
            element.add(description);
            DOMElement htmlContent = new DOMElement("HtmlContent");
            htmlContent.setText(notification.getHtmlContent().replace("\n", ""));
            element.add(htmlContent);
            return element;
        } catch (Exception ex) {
            throw new TransformationException("Can't transform passed Notification to Element object", ex);
        }
    }
}
