package org.zerock.b01.service;

import org.zerock.b01.dto.MemberDTO;
import org.zerock.b01.dto.PageRequestDTO;

import java.util.List;

public interface MemberService {

//    String register(MemberDTO memberDTO);
    void register(MemberDTO memberDTO);

    MemberDTO readOne(String memberId);

    String remove(MemberDTO memberDTO);

    List<MemberDTO> list(PageRequestDTO pageRequestDTO);
}
