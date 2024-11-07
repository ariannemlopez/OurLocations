package com.datacom.model;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;


@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(Include.NON_EMPTY)
public class OurLocations {
    @JsonProperty("New Zealand")
    private List<LocationDetails> New_Zealand;
    @JsonProperty("Australia")
    private List<LocationDetails> Australia;
    @JsonProperty("Asia")
    private List<LocationDetails> Asia;

    public List<LocationDetails> getNew_Zealand() {
        return New_Zealand;
    }

    public void setNew_Zealand(List<LocationDetails> new_Zealand) {
        New_Zealand = new_Zealand;
    }

    public List<LocationDetails> getAustralia() {
        return Australia;
    }

    public void setAustralia(List<LocationDetails> australia) {
        Australia = australia;
    }

    public List<LocationDetails> getAsia() {
        return Asia;
    }

    public void setAsia(List<LocationDetails> asia) {
        Asia = asia;
    }
}