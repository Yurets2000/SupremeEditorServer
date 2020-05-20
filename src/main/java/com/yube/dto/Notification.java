package com.yube.dto;

import lombok.Data;

import java.util.Date;

@Data
public class Notification {
    private Integer id;
    private Date publishingDate;
    private String description;
    private String htmlContent;
}
