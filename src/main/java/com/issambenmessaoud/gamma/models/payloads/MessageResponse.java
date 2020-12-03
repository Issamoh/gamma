package com.issambenmessaoud.gamma.models.payloads;

public class MessageResponse {
    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
    }

    private String response;

    public MessageResponse(String response) {
        this.response = response;
    }
}
