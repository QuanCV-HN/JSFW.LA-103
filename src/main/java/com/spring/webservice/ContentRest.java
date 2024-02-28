package com.spring.webservice;

import com.spring.model.ContentDTO;
import com.spring.service.ContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ContentRest {

    @Autowired
    ContentService contentService;

//    @GetMapping("/viewcontent-rest")
//    public List<ContentDTO> viewcontentPage(@RequestParam("pageNumber") Integer pageNumber, @RequestParam("pageSize") Integer pageSize){
//
//        Pageable pageable = PageRequest.of(pageNumber-1, pageSize);
//
//        List<ContentDTO> contentDTOList = contentService.readAll(pageable);
//
//        return contentDTOList;
//    }
}
