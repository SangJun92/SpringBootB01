package org.zerock.b01.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.zerock.b01.domain.Member;
import org.zerock.b01.dto.MemberDTO;
import org.zerock.b01.dto.PageRequestDTO;
import org.zerock.b01.repository.MemberRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Log4j2
@RequiredArgsConstructor
@Transactional
public class MemberServiceImpl implements MemberService {
    private final ModelMapper modelMapper;
    private final MemberRepository memberRepository;

//    @Override
//    public String register(MemberDTO memberDTO) {
//        Member member = modelMapper.map(memberDTO, Member.class);
//        Member no = memberRepository.save(member);
//        return no.getMember_id();
//    }


    @Override
    public void register(MemberDTO memberDTO) {
        memberRepository.save(modelMapper.map(memberDTO, Member.class));
    }

    @Override
    public MemberDTO readOne(String memberId) {
        return modelMapper.map(memberRepository.findById(memberId), MemberDTO.class);

    }

    @Override
    public String remove(MemberDTO memberDTO) {
        return "";
    }

    @Override
    public List<MemberDTO> list(PageRequestDTO pageRequestDTO) {
        List<MemberDTO> result = memberRepository.findAll().stream().map(member -> modelMapper.map(member, MemberDTO.class)).collect(Collectors.toList());

        return result;
    }
}
