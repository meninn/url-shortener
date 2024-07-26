package com.meninn.UrlShortener.Links;

import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class LinkService {
    private LinkRepository linkRepository;

    public LinkService(LinkRepository linkRepository) {
        this.linkRepository = linkRepository;
    }

    public String generateRandomUrl() {
        return RandomStringUtils.randomAlphanumeric(5, 10);
    }

    public Link shortenUrl(String originalUrl) {
        Link link = new Link();

        link.setUrl(originalUrl);
        link.setShortenedUrl(generateRandomUrl());
        link.setUrlCreatedAt(LocalDateTime.now());
        link.setUrlQrCode("QR Code não disponível");

        return linkRepository.save(link);
    }

    public Link getOriginalUrl(String shortenedUrl) {
        try {
            return linkRepository.findByOriginalUrl(shortenedUrl);
        } catch (Exception error) {
            throw new RuntimeException("URL not exist", error);
        }
    }
}
