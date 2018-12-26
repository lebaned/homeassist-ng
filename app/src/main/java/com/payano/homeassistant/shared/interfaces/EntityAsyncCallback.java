package com.payano.homeassistant.shared.interfaces;

import com.payano.homeassistant.model.Entity;

import java.util.ArrayList;

public interface EntityAsyncCallback {
    void onFinished(ArrayList<Entity> entities);
}
