package com.meninn.UrlShortener.Links;

import java.time.LocalDateTime;

public class LinkResponse {
    private long Id;
    private String url;
    private String shortenedUrl;
    private String urlQrCode;
    private LocalDateTime urlCreatedAt;

    public LinkResponse(long id, String url, String shortenedUrl, String urlQrCode, LocalDateTime urlCreatedAt) {
        Id = id;
        this.url = url;
        this.shortenedUrl = shortenedUrl;
        this.urlQrCode = urlQrCode;
        this.urlCreatedAt = urlCreatedAt;
    }

    public long getId() {
        return Id;
    }

    public void setId(long id) {
        Id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getShortenedUrl() {
        return shortenedUrl;
    }

    public void setShortenedUrl(String shortenedUrl) {
        this.shortenedUrl = shortenedUrl;
    }

    public String getUrlQrCode() {
        return urlQrCode;
    }

    public void setUrlQrCode(String urlQrCode) {
        this.urlQrCode = urlQrCode;
    }

    public LocalDateTime getUrlCreatedAt() {
        return urlCreatedAt;
    }

    public void setUrlCreatedAt(LocalDateTime urlCreatedAt) {
        this.urlCreatedAt = urlCreatedAt;
    }
}
