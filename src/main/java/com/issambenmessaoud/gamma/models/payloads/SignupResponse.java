package com.issambenmessaoud.gamma.models.payloads;

public class SignupResponse {
    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
    }

    private String response;

    public SignupResponse(String response) {
        this.response = response;
    }
}
