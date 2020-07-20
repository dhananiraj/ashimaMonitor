package com.ashimaFabMonitor.model;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class Post implements Serializable {

    private int userId;
    private int id;
    private String title;
    private String body;

    // getters and setters
}
