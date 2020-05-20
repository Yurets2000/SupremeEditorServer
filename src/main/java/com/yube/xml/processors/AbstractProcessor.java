package com.yube.xml.processors;

import org.dom4j.Document;

public abstract class AbstractProcessor {
    protected Document document;

    public AbstractProcessor(Document document) {
        this.document = document;
    }
}
