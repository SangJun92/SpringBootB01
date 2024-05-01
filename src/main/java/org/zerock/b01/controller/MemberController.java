package org.zerock.b01.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.zerock.b01.domain.Member;
import org.zerock.b01.dto.MemberDTO;
import org.zerock.b01.repository.MemberRepository;
import org.zerock.b01.service.MemberService;

import java.util.Optional;

@Controller
@RequestMapping("/member")
@Log4j2
@RequiredArgsConstructor
public class MemberController {
    private final MemberService memberService;
    private final MemberRepository memberRepository;

    @GetMapping("/join")
    public String join(MemberDTO memberDTO) {
        return "/ex/join";
    }

    @PostMapping("/join")
    public String addJoin(MemberDTO memberDTO) {
        memberDTO.setEmail1(memberDTO.getMember_id());
        memberService.register(memberDTO);
        return "redirect:/ex/index";
    }

    @GetMapping("/login")
    public String login(MemberDTO memberDTO) {
        return "/ex/login";
    }

    @PostMapping("/login")
    public String addLogin(MemberDTO memberDTO) {
        Optional<Member> call = memberRepository.findById(memberDTO.getMember_id());

        if (call != null && call.get().getMember_pw().equals(memberDTO.getMember_pw())) {
            return "redirect:/ex/index";
        } else {
            return "redirect:/ex/login";
        }
    }
//    @GetMapping("/logout")
//    public String logout(MemberDTO memberDTO) {
//        return "/ex/index";
//    }
//    @PostMapping("/logout")
//    public String logoutPost(MemberDTO memberDTO) {
//
//    }
}