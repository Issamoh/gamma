package com.issambenmessaoud.gamma.models.payloads;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDateTime;

public class TacheAdd {
    private String title;
    private String description;
    private int dureeSuffisante;

    //dd-MM-YYYY HH:mm:ss
    //private String DateCreation;

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public int getDureeSuffisante() {
        return dureeSuffisante;
    }

   /* public String getDateCreation() {
        return DateCreation;
    }*/
}
