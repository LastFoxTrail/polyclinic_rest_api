package com.lis.projects.exception.json_formatter;

public class IncorrectRequestData {
    private String responseMessage;

    public IncorrectRequestData(String responseMessage) {
        this.responseMessage = responseMessage;
    }

    public String getResponseMessage() {
        return responseMessage;
    }

    public void setResponseMessage(String responseMessage) {
        this.responseMessage = responseMessage;
    }
}