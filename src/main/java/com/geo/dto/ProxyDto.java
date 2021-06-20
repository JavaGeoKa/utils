package com.geo.dto;


import com.fasterxml.jackson.annotation.*;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.util.HashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "anonymous",
        "cookies",
        "curl",
        "get",
        "ip",
        "isp",
        "lastChecked",
        "location",
        "port",
        "post",
        "protocol",
        "rtt",
        "ssl",
        "websites"
})
public class ProxyDto {

    @JsonProperty("anonymous")
    private Boolean anonymous;
    @JsonProperty("cookies")
    private Boolean cookies;
    @JsonProperty("curl")
    private String curl;
    @JsonProperty("get")
    private Boolean get;
    @JsonProperty("ip")
    private String ip;
    @JsonProperty("isp")
    private String isp;
    @JsonProperty("lastChecked")
    private Double lastChecked;
    @JsonProperty("location")
    private String location;
    @JsonProperty("port")
    private Integer port;
    @JsonProperty("post")
    private Boolean post;
    @JsonProperty("protocol")
    private String protocol;
    @JsonProperty("rtt")
    private Double rtt;
    @JsonProperty("ssl")
    private Boolean ssl;
    @JsonProperty("websites")
    private Websites websites;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("anonymous")
    public Boolean getAnonymous() {
        return anonymous;
    }

    @JsonProperty("anonymous")
    public void setAnonymous(Boolean anonymous) {
        this.anonymous = anonymous;
    }

    public ProxyDto withAnonymous(Boolean anonymous) {
        this.anonymous = anonymous;
        return this;
    }

    @JsonProperty("cookies")
    public Boolean getCookies() {
        return cookies;
    }

    @JsonProperty("cookies")
    public void setCookies(Boolean cookies) {
        this.cookies = cookies;
    }

    public ProxyDto withCookies(Boolean cookies) {
        this.cookies = cookies;
        return this;
    }

    @JsonProperty("curl")
    public String getCurl() {
        return curl;
    }

    @JsonProperty("curl")
    public void setCurl(String curl) {
        this.curl = curl;
    }

    public ProxyDto withCurl(String curl) {
        this.curl = curl;
        return this;
    }

    @JsonProperty("get")
    public Boolean getGet() {
        return get;
    }

    @JsonProperty("get")
    public void setGet(Boolean get) {
        this.get = get;
    }

    public ProxyDto withGet(Boolean get) {
        this.get = get;
        return this;
    }

    @JsonProperty("ip")
    public String getIp() {
        return ip;
    }

    @JsonProperty("ip")
    public void setIp(String ip) {
        this.ip = ip;
    }

    public ProxyDto withIp(String ip) {
        this.ip = ip;
        return this;
    }

    @JsonProperty("isp")
    public String getIsp() {
        return isp;
    }

    @JsonProperty("isp")
    public void setIsp(String isp) {
        this.isp = isp;
    }

    public ProxyDto withIsp(String isp) {
        this.isp = isp;
        return this;
    }

    @JsonProperty("lastChecked")
    public Double getLastChecked() {
        return lastChecked;
    }

    @JsonProperty("lastChecked")
    public void setLastChecked(Double lastChecked) {
        this.lastChecked = lastChecked;
    }

    public ProxyDto withLastChecked(Double lastChecked) {
        this.lastChecked = lastChecked;
        return this;
    }

    @JsonProperty("location")
    public String getLocation() {
        return location;
    }

    @JsonProperty("location")
    public void setLocation(String location) {
        this.location = location;
    }

    public ProxyDto withLocation(String location) {
        this.location = location;
        return this;
    }

    @JsonProperty("port")
    public Integer getPort() {
        return port;
    }

    @JsonProperty("port")
    public void setPort(Integer port) {
        this.port = port;
    }

    public ProxyDto withPort(Integer port) {
        this.port = port;
        return this;
    }

    @JsonProperty("post")
    public Boolean getPost() {
        return post;
    }

    @JsonProperty("post")
    public void setPost(Boolean post) {
        this.post = post;
    }

    public ProxyDto withPost(Boolean post) {
        this.post = post;
        return this;
    }

    @JsonProperty("protocol")
    public String getProtocol() {
        return protocol;
    }

    @JsonProperty("protocol")
    public void setProtocol(String protocol) {
        this.protocol = protocol;
    }

    public ProxyDto withProtocol(String protocol) {
        this.protocol = protocol;
        return this;
    }

    @JsonProperty("rtt")
    public Double getRtt() {
        return rtt;
    }

    @JsonProperty("rtt")
    public void setRtt(Double rtt) {
        this.rtt = rtt;
    }

    public ProxyDto withRtt(Double rtt) {
        this.rtt = rtt;
        return this;
    }

    @JsonProperty("ssl")
    public Boolean getSsl() {
        return ssl;
    }

    @JsonProperty("ssl")
    public void setSsl(Boolean ssl) {
        this.ssl = ssl;
    }

    public ProxyDto withSsl(Boolean ssl) {
        this.ssl = ssl;
        return this;
    }

    @JsonProperty("websites")
    public Websites getWebsites() {
        return websites;
    }

    @JsonProperty("websites")
    public void setWebsites(Websites websites) {
        this.websites = websites;
    }

    public ProxyDto withWebsites(Websites websites) {
        this.websites = websites;
        return this;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

    public ProxyDto withAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
        return this;
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(anonymous).append(cookies).append(curl).append(get).append(ip).append(isp).append(lastChecked).append(location).append(port).append(post).append(protocol).append(rtt).append(ssl).append(websites).append(additionalProperties).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof ProxyDto) == false) {
            return false;
        }
        ProxyDto rhs = ((ProxyDto) other);
        return new EqualsBuilder().append(anonymous, rhs.anonymous).append(cookies, rhs.cookies).append(curl, rhs.curl).append(get, rhs.get).append(ip, rhs.ip).append(isp, rhs.isp).append(lastChecked, rhs.lastChecked).append(location, rhs.location).append(port, rhs.port).append(post, rhs.post).append(protocol, rhs.protocol).append(rtt, rhs.rtt).append(ssl, rhs.ssl).append(websites, rhs.websites).append(additionalProperties, rhs.additionalProperties).isEquals();
    }

}

