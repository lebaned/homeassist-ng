package com.payano.homeassistant.service;

import com.payano.homeassistant.model.HomeAssistantServer;

// Singleton object
public class WebSocketHandler {
    // Data members
    private static WebSocketHandler instance;
    private HomeAssistantServer settings;
    // Private constructor
    private WebSocketHandler(){

    }
    public static WebSocketHandler getInstance(){
        if(instance == null){
            instance = new WebSocketHandler();
        }
        return instance;
    }
}
