package com.library.service;

import com.quhaodian.adminstore.data.dao.MemberDao;
import com.library.dao.MemberDAO; 
import com.library.model.Member;

public class MemberService {
    private MemberDAO memberDAO;

    public MemberService() {
        memberDAO = new MemberDAO();
    }

    public void createMember(Member member) {
        MemberDao.save(member);
    }
}
