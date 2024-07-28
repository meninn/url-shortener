package com.meninn.UrlShortener.Links;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

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

}
