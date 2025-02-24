package com.example.demo.member.controller

import com.example.demo.common.authority.TokenInfo
import com.example.demo.common.dto.BaseResponse
import com.example.demo.member.dto.LoginDto
import com.example.demo.member.dto.MemberDtoRequest
import com.example.demo.member.service.MemberService
import jakarta.validation.Valid
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RequestMapping("/api/member")
@RestController
class MemberController(
    private val memberService: MemberService
) {
    /**
     * 회원가입
     */
    @PostMapping("/signup")
    fun signUp(@RequestBody @Valid memberDtoRequest: MemberDtoRequest): BaseResponse<Unit> {
        val resultMessage: String = memberService.signUp(memberDtoRequest)
        return BaseResponse(message = resultMessage)
    }

    /**
     * 로그인
     */
    @PostMapping("/login")
    fun login(@RequestBody @Valid loginDto: LoginDto): BaseResponse<TokenInfo> {
        val tokenInfo = memberService.login(loginDto)

        return BaseResponse(data = tokenInfo)
    }
}