package com.payano.homeassistant.model.rest;

import com.payano.homeassistant.model.Config;
import com.payano.homeassistant.model.Entity;
import com.payano.homeassistant.model.Service;
import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class BootstrapResponse {

    @SerializedName("config")
    public Config config;

//    @SerializedName("events")
//    public Event events;

    @SerializedName("services")
    public ArrayList<Service> services;

    @SerializedName("states")
    public ArrayList<Entity> states;


    public String toString()
    {
        return (new Gson()).toJson(this);
    }
}
