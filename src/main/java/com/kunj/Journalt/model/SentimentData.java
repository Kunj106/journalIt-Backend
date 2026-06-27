package com.kunj.Journalt.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;


@Builder
public class SentimentData
{
    private String email;
    private String sentiment;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSentiment() {
        return sentiment;
    }

    public void setSentiment(String sentiment) {
        this.sentiment = sentiment;
    }

    public SentimentData(String email, String sentiment) {
        this.email = email;
        this.sentiment = sentiment;
    }

    public SentimentData() {
    }
}
