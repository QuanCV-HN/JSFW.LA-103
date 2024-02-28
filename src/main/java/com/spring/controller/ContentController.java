package com.spring.controller;

import com.spring.entities.Content;
import com.spring.model.ContentDTO;
import com.spring.model.MemberDTO;
import com.spring.repository.ContentRepository;
import com.spring.service.ContentService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.ArrayList;
import java.util.List;

@Controller
public class ContentController {
    @Autowired
    ContentService contentService;

    @Autowired
    ContentRepository contentRepository;


    @GetMapping("/viewcontent")
    public String viewcontentPage( HttpSession session,
                                   @RequestParam(value = "pageNumber", defaultValue = "1") Integer pageNumber,
                                   @RequestParam(value = "pageSize", defaultValue = "3")Integer pageSize,
                                   Model model
    ){
        MemberDTO memberDTO =(MemberDTO) session.getAttribute("memberDTO");
        if(memberDTO == null){
            return "redirect:/login";
        }

        Pageable pageable = PageRequest.of(pageNumber-1,pageSize,Sort.by("createDate").descending());
        Page<Content> contentPage = contentRepository.findAll(pageable);

        List<Integer> list = new ArrayList<>();
        for (int i = 1; i <= contentPage.getTotalPages(); i++) {
            list.add(i);
        }
        model.addAttribute("pageNumList",list);
        model.addAttribute("page",contentPage);

        return "viewcontent";
    }

    @GetMapping("/addcontent")
    public String addcontentPage(HttpSession session, ModelMap modelMap){

        MemberDTO memberDTO =(MemberDTO) session.getAttribute("memberDTO");
        if(memberDTO == null){
            return "redirect:/login";
        }

        ContentDTO contentDTO = new ContentDTO();

         contentDTO.setAuthorId(memberDTO.getId());

        System.out.println(contentDTO.getAuthorId());
        modelMap.addAttribute("contentDTO",contentDTO);
        return "addcontent";
    }

    @PostMapping("/addcontent")
    public String edit(@ModelAttribute("contentDTO") ContentDTO contentDTO){

        contentService.save(contentDTO);

        return "redirect:/viewcontent";
    }

}
