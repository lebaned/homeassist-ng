package com.payano;

import com.payano.homeassistant.AppController;

public class TestAppController extends AppController {
  private String baseUrl;

  public String getBaseUrl() {
    return baseUrl;
  }

  public void setBaseUrl(String url) {
    baseUrl = url;
  }
}