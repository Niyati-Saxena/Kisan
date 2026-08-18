package com.kisan.mapper;

import com.kisan.dto.NewsResponseDTO;
import com.kisan.model.News;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class NewsMapper {
    public NewsResponseDTO toDto(News news) {
        return new NewsResponseDTO(news.getTitle(), news.getSummary(), news.getLink(), news.getDate());
    }

    public List<NewsResponseDTO> toDtoList(List<News> newsList) {
        return newsList.stream().map(this::toDto).toList();
    }
}
