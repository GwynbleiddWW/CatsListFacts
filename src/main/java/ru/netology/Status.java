package ru.netology;

import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "verified",
        "sentCount",
        "feedback"
})
public class Status {

    @JsonProperty("verified")
    private Boolean verified;
    @JsonProperty("sentCount")
    private Integer sentCount;
    @JsonProperty("feedback")
    private String feedback;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     *
     */
    public Status() {
    }

    /**
     *
     * @param feedback
     * @param verified
     * @param sentCount
     */
    public Status(Boolean verified, Integer sentCount, String feedback) {
        super();
        this.verified = verified;
        this.sentCount = sentCount;
        this.feedback = feedback;
    }

    @JsonProperty("verified")
    public Boolean getVerified() {
        return verified;
    }

    @JsonProperty("verified")
    public void setVerified(Boolean verified) {
        this.verified = verified;
    }

    @JsonProperty("sentCount")
    public Integer getSentCount() {
        return sentCount;
    }

    @JsonProperty("sentCount")
    public void setSentCount(Integer sentCount) {
        this.sentCount = sentCount;
    }

    @JsonProperty("feedback")
    public String getFeedback() {
        return feedback;
    }

    @JsonProperty("feedback")
    public void setFeedback(String feedback) {
        this.feedback = feedback;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

    @Override
    public String toString() {
        return "Status{" +
                "verified=" + verified +
                ", sentCount=" + sentCount +
                ", feedback='" + feedback + '\'' +
                ", additionalProperties=" + additionalProperties +
                '}';
    }
}
