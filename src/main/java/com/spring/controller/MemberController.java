package com.spring.controller;


import com.spring.entities.Member;
import com.spring.model.MemberDTO;
import com.spring.repository.MemberDAO;
import com.spring.service.MemberService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class MemberController {
    @Autowired
    MemberService memberService;

    @Autowired
    MemberDAO memberDAO;

    @GetMapping("/login")
    public String loginPage(ModelMap modelMap,HttpSession session){
        session.invalidate();
        modelMap.addAttribute("memberDTO",new MemberDTO());
        return "login";
    }

    @PostMapping("/login")
    public String login(@ModelAttribute("memberDTO") MemberDTO memberDTO, Model model , RedirectAttributes redirectAttributes, HttpSession session){

        if (memberDTO ==null){
            return "login";
        }

        MemberDTO memberDTODB = memberService.readOne( memberDTO.getEmail(),memberDTO.getPassword());
        if(memberDTODB == null){
            model.addAttribute("message","Tài khoản không tồn tại");
            return "login";
        }

        session.setAttribute("memberDTO", memberDTODB);
        redirectAttributes.addFlashAttribute("memberDTO", memberDTODB);
        return "redirect:/edit";

    }

    @GetMapping("/register")
    public String registerPage(ModelMap modelMap){

        modelMap.addAttribute("memberDTO",new MemberDTO());
        return "register";
    }

    @PostMapping("/register")
    public String register(@ModelAttribute("memberDTO") MemberDTO memberDTO, Model model ){

        if (memberDTO == null){
            return "register";
        }

       List<Member> list = memberDAO.readOneRe(memberDTO.getUsername(),memberDTO.getEmail());
        if(list.size() > 0){
            model.addAttribute("message","User hoặc email đã tồn tại");
            return "register";
        }

        memberService.save(memberDTO);
        return "redirect:/login";
    }
    @GetMapping("/edit")
    public String editPage( ModelMap modelMap, HttpSession session){

        MemberDTO memberDTO = (MemberDTO) session.getAttribute("memberDTO");
        if(memberDTO == null){
            return "redirect:/login";
        }

        modelMap.addAttribute("memberDTO",memberDTO);
        System.out.println(memberDTO);

        return "edit";
    }


    @PostMapping("/edit")
    public String edit(@ModelAttribute("memberDTO") MemberDTO memberDTO,ModelMap modelMap, HttpSession session){

        memberService.update(memberDTO);

        //post xuống không có email nên phải set lại
        MemberDTO memberDTOSS = (MemberDTO) session.getAttribute("memberDTO");
        String email = memberDTOSS.getEmail();
        memberDTO.setEmail(email);

        modelMap.addAttribute("memberDTO",memberDTO);
        return "edit";
    }


}
