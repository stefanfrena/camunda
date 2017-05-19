package de.frena.helloworld.dto;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

public class HelloWorldDto implements Serializable {

  private static final long serialVersionUID = 1238625947667800582L;

  @JsonProperty("name")
  private String name;

  public String getName() {
    return name;
  }

  public static long getSerialversionuid() {
    return serialVersionUID;
  }

  public void setName(String name) {
    this.name = name;
  }

  @Override
  public String toString() {
    return "HelloWorldDto [name=" + name + "]";
  }
}
