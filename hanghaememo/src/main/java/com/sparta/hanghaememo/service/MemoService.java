package com.sparta.hanghaememo.service;


import com.sparta.hanghaememo.dto.MemoRequestDto;
import com.sparta.hanghaememo.dto.MemoResponseDto;
import com.sparta.hanghaememo.entity.Memo;
import com.sparta.hanghaememo.repository.MemoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class MemoService {

    private final MemoRepository memoRepository;

    @Transactional
    public Memo createMemo(MemoRequestDto requestDto) {
        Memo memo = new Memo(requestDto);
        memoRepository.save(memo);
        return memo;
    }

    @Transactional(readOnly = true)
    public List<MemoResponseDto> getMemos() {
        return memoRepository.findAllByOrderByModifiedAtDesc().stream().map(MemoResponseDto::new).collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public MemoResponseDto getMemos(long id) {
        Memo entity = memoRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("해당 게시글은 존재하지 않습니다")
        );
        return new MemoResponseDto(entity);
    }

    @Transactional
    public MemoResponseDto update(Long id, String password, MemoRequestDto requestDto) {
        Memo memo = memoRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("아이디가 존재하지 않습니다.")
        );
        memo.update(requestDto, password);
        return new MemoResponseDto(memo);
    }

    @Transactional
    public String deleteMemo(Long id, String password) {
        Memo memo = memoRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("아이디가 존재하지 않습니다.")
        );
        if(memo.delete(password)){
            memoRepository.deleteById(id);
            return "아이디 "+id +"의 내용을 모두 삭제했습니다";
        }else{
            return "아이디가 일치하지 않습니다";
        }
    }

}
