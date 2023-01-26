package com.example.member.service


import com.example.member.model.Conferences
import com.example.member.model.Register
import com.example.member.repository.ConferencesRepository
import com.example.member.repository.RegisterRepository
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito
import org.springframework.boot.test.context.SpringBootTest
import javax.persistence.Column

@SpringBootTest
    class RegisterServiceTest {
    @InjectMocks
    lateinit var registerService: RegisterService

        @InjectMocks
        lateinit var conferencesService: ConferencesService
    @InjectMocks
    lateinit var memberService: MemberService
        @Mock
        lateinit var registerRepository: RegisterRepository

            val registerMock = Register().apply {
            id=1
                memberId=1
                conferencesId=1
                registedAt="q"
                assisted="si"
                code="1234567"



        }


    @Column(name="member_id")
    var memberId:Long? = null

    @Column(name="conferences_id")
    var conferencesId:Long? = null

    @Column(name="registed_at")
    var registedAt:String? = null
    var assisted:String? = null
    var code: String? = null

    @Test
    fun saveClientCorrect(){
        Mockito.`when`(registerRepository.save(Mockito.any(Register::class.java))).thenReturn(registerMock)
        val response = registerService.save(registerMock)
        Assertions.assertEquals(response.id, registerMock.id)
    }
            @Test
            fun saveConferencesWhenTitleIsBlank(){
                Assertions.assertThrows(Exception::class.java) {
                    registerMock.apply { assisted=" "}
                    Mockito.`when`(registerRepository.save(Mockito.any(Register::class.java))).thenReturn(registerMock)
                    registerService.save(registerMock)
                }
            }
        }


