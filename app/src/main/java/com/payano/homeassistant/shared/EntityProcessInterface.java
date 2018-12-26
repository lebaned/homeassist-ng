package com.payano.homeassistant.shared;

import android.app.FragmentManager;
import android.content.Context;

import com.payano.homeassistant.model.HomeAssistantServer;
import com.payano.homeassistant.model.rest.CallServiceRequest;

public interface EntityProcessInterface {
    void callService(final String domain, final String service, CallServiceRequest serviceRequest);

    FragmentManager getFragmentManager();

    HomeAssistantServer getServer();

    Context getActivityContext();

    void showToast(String message);
}
