package com.spring.service;

import com.spring.entities.Content;
import com.spring.model.ContentDTO;
import com.spring.repository.ContentRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class ContentServiceImpl implements ContentService{
    @Autowired
    ContentRepository contentRepository;

    @Override
    public ContentDTO save(ContentDTO contentDTO) {
        Content content =  new Content();

        content.setContent(contentDTO.getContent());
        content.setBrief(contentDTO.getBrief());
        content.setTitle(contentDTO.getTitle());
        content.setCreateDate(new Date());
        content.setAuthorId(contentDTO.getAuthorId());

        contentRepository.save(content);
        return contentDTO;
    }

    @Override
    public List<ContentDTO> readAll(Pageable pageable) {
        List<ContentDTO> contentDTOList = new ArrayList<>();
         List<Content> contentList = contentRepository.findAll(pageable).getContent();

        for(Content c : contentList){
            System.out.println(c);
             ContentDTO contentDTO = new ContentDTO();

             contentDTO.setId(c.getId());
             contentDTO.setTitle(c.getTitle());
             contentDTO.setBrief(c.getBrief());
             contentDTO.setContent(c.getContent());
             contentDTO.setAuthorId(c.getAuthorId());
             contentDTO.setCreateDate(c.getCreateDate());
             contentDTO.setUpdateTime(c.getUpdateTime());

             contentDTOList.add(contentDTO);
        }

        return contentDTOList;
    }
}
