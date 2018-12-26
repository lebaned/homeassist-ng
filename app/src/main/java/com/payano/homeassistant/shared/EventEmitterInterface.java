package com.payano.homeassistant.shared;

import com.payano.homeassistant.model.rest.RxPayload;

import io.reactivex.subjects.Subject;

public interface EventEmitterInterface {
    Subject<RxPayload> getEventSubject();
}
