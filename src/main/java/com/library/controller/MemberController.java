package com.library.controller;

import com.library.model.Member;
import com.library.service.MemberService;


public class MemberController {
    private final MemberService memberService;

    public MemberController() {
        memberService = new MemberService();
    }

    public void createMember(Member member) {
        memberService.createMember(member);
    }
}
