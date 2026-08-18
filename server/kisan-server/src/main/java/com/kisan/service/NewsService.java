package com.kisan.service;

import com.kisan.dto.NewsResponseDTO;
import com.kisan.mapper.NewsMapper;
import com.kisan.model.News;
import com.rometools.rome.feed.synd.SyndEntry;
import com.rometools.rome.feed.synd.SyndFeed;
import com.rometools.rome.io.SyndFeedInput;
import com.rometools.rome.io.XmlReader;
import org.springframework.stereotype.Service;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;

@Service
public class NewsService {

    private final NewsMapper newsMapper;

    public NewsService(NewsMapper newsMapper) {
        this.newsMapper = newsMapper;
    }

    public List<NewsResponseDTO> getLiveNews() {

        List<News> newsList = new ArrayList<>();

        try {
            URL feedUrl = new URL("https://krishijagran.com/feeds/rss");

            SyndFeedInput input = new SyndFeedInput();
            SyndFeed feed = input.build(new XmlReader(feedUrl));

            for (SyndEntry entry : feed.getEntries()) {

                News news = new News();

                news.setTitle(entry.getTitle());
                news.setLink(entry.getLink());

                news.setDate(
                        entry.getPublishedDate() != null
                                ? entry.getPublishedDate().toString()
                                : ""
                );

                news.setSummary(
                        entry.getDescription() != null
                                ? entry.getDescription().getValue()
                                : ""
                );

                newsList.add(news);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return newsMapper.toDtoList(newsList);
    }
}