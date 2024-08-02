package com.meninn.UrlShortener.Links;

import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.Map;

@RestController
public class LinkController {
    private final LinkService linkService;

    public LinkController(LinkService linkService) {
        this.linkService = linkService;
    }

    @PostMapping("/url-shortener")
    public ResponseEntity<LinkResponse> generateShortenedUrl(@RequestBody Map<String, String> request) {
        String url = request.get("url");

        Link link = linkService.shortenUrl(url);

        String userRedirectUrl = "http://localhost:8080/r/" + link.getShortenedUrl();

         LinkResponse response = new LinkResponse(
                 link.getId(),
                 link.getUrl(),
                 userRedirectUrl,
                 link.getUrlQrCode(),
                 link.getUrlCreatedAt()
         );

         return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping("/r/{shortenUrl}")
    public void redirectLink(@PathVariable String shortenUrl, HttpServletResponse response) throws IOException {
        Link link = linkService.getUrl(shortenUrl);

        System.out.println(link);

        if (link != null) {
            System.out.println(link.getUrl());
            response.sendRedirect(link.getUrl());
        } else {
            response.sendError(HttpServletResponse.SC_NOT_FOUND);
        }
    }
}
