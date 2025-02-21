package com.example.demo.member.service

import com.example.demo.common.status.Gender
import com.example.demo.member.dto.MemberDtoRequest
import com.example.demo.member.repository.MemberRepository
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import java.time.LocalDate
import java.util.*

@SpringBootTest
class MemberServiceTest @Autowired constructor(
    private val memberRepository: MemberRepository,
    private val memberService: MemberService
) {
    @Test
    fun signUp() {
        memberService.signUp(
            MemberDtoRequest(
                null,
                "testId",
                "testPassword",
                "홍길동",
                LocalDate.now(),
                Gender.MAN,
                "hello@world.com"
            )
        )

     assertTrue(Optional.ofNullable(memberRepository.findByLoginId("testId")).isPresent)
    }
}