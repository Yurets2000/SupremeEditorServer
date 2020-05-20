package com.yube.xml.documents;

import com.yube.utils.XmlHelper;
import lombok.Getter;
import org.dom4j.Document;
import org.dom4j.DocumentException;

import java.util.HashMap;
import java.util.Map;

public final class XmlDocument {

    private final static Map<String, XmlDocument> instances = new HashMap<>();
    @Getter private String path;
    @Getter private Document document;

    private XmlDocument(String path) throws DocumentException {
        ClassLoader classLoader = getClass().getClassLoader();
        this.path = classLoader.getResource(path).toExternalForm();
        this.document = XmlHelper.read(this.path);
    }

    public static XmlDocument getInstance(String path) throws DocumentException {
        if(instances.get(path) == null) {
            instances.put(path, new XmlDocument(path));
        }
        return instances.get(path);
    }
}