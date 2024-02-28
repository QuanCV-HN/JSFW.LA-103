package com.spring.service;

import com.spring.model.ContentDTO;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ContentService {
    ContentDTO save(ContentDTO contentDTO);

   List<ContentDTO> readAll(Pageable pageable);
}
