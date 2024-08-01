package com.library.test;

import com.library.dao.MemberDAO;
import com.library.model.Member;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class MemberTest {
    private MemberDAO memberDAO;

    @Before
    public void setUp() {
        memberDAO = new MemberDAO();
    }

    @After
    public void tearDown() {
    }

    @Test
    public void testSaveMember() {
        Member member = new Member();
        memberDAO.save(member);

        Member savedMember = memberDAO.get(member.getId());
        assertNotNull(savedMember);
        assertEquals(member.getName(), savedMember.getName());
        assertEquals(member.getEmail(), savedMember.getEmail());
    }

    @Test
    public void testUpdateMember() {
        Member member = new Member();
        memberDAO.save(member);

        member.setName();
        member.setEmail();
        memberDAO.update(member);

        Member updatedMember = memberDAO.get(member.getId());
        assertEquals("", updatedMember.getName());
        assertEquals("", updatedMember.getEmail());
    }

    @Test
    public void testDeleteMember() {
        Member member = new Member();
        memberDAO.save(member);

        memberDAO.delete(member.getId());
        Member deletedMember = memberDAO.get(member.getId());
        assertNull(deletedMember);
    }
}