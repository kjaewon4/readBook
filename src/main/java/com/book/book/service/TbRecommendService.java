package com.book.book.service;

import com.book.book.repository.TbRecommendRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

//@RequiredArgsConstructor
@Service
public class TbRecommendService {
    private final TbRecommendRepository recommendRepository;

    public TbRecommendService(TbRecommendRepository recommendRepository) {
        this.recommendRepository = recommendRepository;
    }
}
