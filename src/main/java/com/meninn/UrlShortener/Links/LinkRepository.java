package com.meninn.UrlShortener.Links;

import org.springframework.data.jpa.repository.JpaRepository;

public interface LinkRepository extends JpaRepository<Link, Long> {
    Link findByShortenedUrl(String shortenedUrl);
}
