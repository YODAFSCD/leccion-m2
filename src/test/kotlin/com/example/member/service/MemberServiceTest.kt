package com.example.member.service


import com.example.member.model.Member
import com.example.member.repository.MemberRepository
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito
import org.springframework.boot.test.context.SpringBootTest

    @SpringBootTest
    class MemberServiceTest {

        @InjectMocks
        lateinit var memberService: MemberService

        @Mock
        lateinit var memberRepository: MemberRepository

            val memberMock = Member().apply {
            id=1
            fullname="Alison Otavalo"
            email= "Cuenca"
                age= 19
        }

        @Test
        fun saveClientCorrect(){
            Mockito.`when`(memberRepository.save(Mockito.any(Member::class.java))).thenReturn(memberMock)
            val response = memberService.save(memberMock)
            Assertions.assertEquals(response.id, memberMock.id)
        }



            @Test
            fun saveClientWhenFullnessIsBlank(){
                Assertions.assertThrows(Exception::class.java) {
                    memberMock.apply { fullname=" "}
                    Mockito.`when`(memberRepository.save(Mockito.any(Member::class.java))).thenReturn(memberMock)
                    memberService.save(memberMock)
                }
            }
        }


