package com.geo.dto;


import com.fasterxml.jackson.annotation.*;

import java.util.HashMap;
import java.util.Map;


@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "amazon",
        "facebook",
        "google",
        "instagram",
        "netflix",
        "nike",
        "shopify",
        "stubhub",
        "supreme",
        "ticketmaster",
        "twitch",
        "twitter",
        "youtube"
})
public class Websites {

    @JsonProperty("amazon")
    private Boolean amazon;
    @JsonProperty("facebook")
    private Boolean facebook;
    @JsonProperty("google")
    private Boolean google;
    @JsonProperty("instagram")
    private Boolean instagram;
    @JsonProperty("netflix")
    private Boolean netflix;
    @JsonProperty("nike")
    private Boolean nike;
    @JsonProperty("shopify")
    private Boolean shopify;
    @JsonProperty("stubhub")
    private Boolean stubhub;
    @JsonProperty("supreme")
    private Boolean supreme;
    @JsonProperty("ticketmaster")
    private Boolean ticketmaster;
    @JsonProperty("twitch")
    private Boolean twitch;
    @JsonProperty("twitter")
    private Boolean twitter;
    @JsonProperty("youtube")
    private Boolean youtube;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("amazon")
    public Boolean getAmazon() {
        return amazon;
    }

    @JsonProperty("amazon")
    public void setAmazon(Boolean amazon) {
        this.amazon = amazon;
    }

    public Websites withAmazon(Boolean amazon) {
        this.amazon = amazon;
        return this;
    }

    @JsonProperty("facebook")
    public Boolean getFacebook() {
        return facebook;
    }

    @JsonProperty("facebook")
    public void setFacebook(Boolean facebook) {
        this.facebook = facebook;
    }

    public Websites withFacebook(Boolean facebook) {
        this.facebook = facebook;
        return this;
    }

    @JsonProperty("google")
    public Boolean getGoogle() {
        return google;
    }

    @JsonProperty("google")
    public void setGoogle(Boolean google) {
        this.google = google;
    }

    public Websites withGoogle(Boolean google) {
        this.google = google;
        return this;
    }

    @JsonProperty("instagram")
    public Boolean getInstagram() {
        return instagram;
    }

    @JsonProperty("instagram")
    public void setInstagram(Boolean instagram) {
        this.instagram = instagram;
    }

    public Websites withInstagram(Boolean instagram) {
        this.instagram = instagram;
        return this;
    }

    @JsonProperty("netflix")
    public Boolean getNetflix() {
        return netflix;
    }

    @JsonProperty("netflix")
    public void setNetflix(Boolean netflix) {
        this.netflix = netflix;
    }

    public Websites withNetflix(Boolean netflix) {
        this.netflix = netflix;
        return this;
    }

    @JsonProperty("nike")
    public Boolean getNike() {
        return nike;
    }

    @JsonProperty("nike")
    public void setNike(Boolean nike) {
        this.nike = nike;
    }

    public Websites withNike(Boolean nike) {
        this.nike = nike;
        return this;
    }

    @JsonProperty("shopify")
    public Boolean getShopify() {
        return shopify;
    }

    @JsonProperty("shopify")
    public void setShopify(Boolean shopify) {
        this.shopify = shopify;
    }

    public Websites withShopify(Boolean shopify) {
        this.shopify = shopify;
        return this;
    }

    @JsonProperty("stubhub")
    public Boolean getStubhub() {
        return stubhub;
    }

    @JsonProperty("stubhub")
    public void setStubhub(Boolean stubhub) {
        this.stubhub = stubhub;
    }

    public Websites withStubhub(Boolean stubhub) {
        this.stubhub = stubhub;
        return this;
    }

    @JsonProperty("supreme")
    public Boolean getSupreme() {
        return supreme;
    }

    @JsonProperty("supreme")
    public void setSupreme(Boolean supreme) {
        this.supreme = supreme;
    }

    public Websites withSupreme(Boolean supreme) {
        this.supreme = supreme;
        return this;
    }

    @JsonProperty("ticketmaster")
    public Boolean getTicketmaster() {
        return ticketmaster;
    }

    @JsonProperty("ticketmaster")
    public void setTicketmaster(Boolean ticketmaster) {
        this.ticketmaster = ticketmaster;
    }

    public Websites withTicketmaster(Boolean ticketmaster) {
        this.ticketmaster = ticketmaster;
        return this;
    }

    @JsonProperty("twitch")
    public Boolean getTwitch() {
        return twitch;
    }

    @JsonProperty("twitch")
    public void setTwitch(Boolean twitch) {
        this.twitch = twitch;
    }

    public Websites withTwitch(Boolean twitch) {
        this.twitch = twitch;
        return this;
    }

    @JsonProperty("twitter")
    public Boolean getTwitter() {
        return twitter;
    }

    @JsonProperty("twitter")
    public void setTwitter(Boolean twitter) {
        this.twitter = twitter;
    }

    public Websites withTwitter(Boolean twitter) {
        this.twitter = twitter;
        return this;
    }

    @JsonProperty("youtube")
    public Boolean getYoutube() {
        return youtube;
    }

    @JsonProperty("youtube")
    public void setYoutube(Boolean youtube) {
        this.youtube = youtube;
    }

    public Websites withYoutube(Boolean youtube) {
        this.youtube = youtube;
        return this;
    }



    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

    public Websites withAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
        return this;
    }





}
