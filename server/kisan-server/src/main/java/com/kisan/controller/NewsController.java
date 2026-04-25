package com.kisan.controller;

import com.rometools.rome.feed.synd.*;
import com.rometools.rome.io.SyndFeedInput;
import com.rometools.rome.io.XmlReader;
import org.springframework.web.bind.annotation.*;
import java.net.URL;
import java.util.*;

@RestController
@RequestMapping("/api/news")
@CrossOrigin(origins = "http://localhost:3000")
public class NewsController {

    @GetMapping
    public List<Map<String, String>> getLiveNews() {
        List<Map<String, String>> newsList = new ArrayList<>();
        try {
            URL feedUrl = new URL("https://krishijagran.com/feeds/rss");
            SyndFeedInput input = new SyndFeedInput();
            SyndFeed feed = input.build(new XmlReader(feedUrl));

            for (SyndEntry entry : feed.getEntries()) {
                Map<String, String> item = new HashMap<>();
                item.put("title", entry.getTitle());
                item.put("link", entry.getLink());
                item.put("date", entry.getPublishedDate() != null ? entry.getPublishedDate().toString() : "");
                item.put("summary", entry.getDescription() != null ? entry.getDescription().getValue() : "");
                newsList.add(item);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return newsList;
    }
}