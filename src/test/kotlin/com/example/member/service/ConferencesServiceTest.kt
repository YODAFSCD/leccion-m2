package com.example.member.service


import com.example.member.model.Conferences
import com.example.member.repository.ConferencesRepository
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito
import org.springframework.boot.test.context.SpringBootTest
@SpringBootTest
    class ConferencesServiceTest {

        @InjectMocks
        lateinit var conferencesService: ConferencesService

        @Mock
        lateinit var conferencesRepository: ConferencesRepository

            val conferencesMock = Conferences().apply {
            id=1
                title= "Titulo"
                speaker="speak"
                eventId= 1
                totalAttendees= 9

        }

        @Test
        fun saveClientCorrect(){
            Mockito.`when`(conferencesRepository.save(Mockito.any(Conferences::class.java))).thenReturn(conferencesMock)
            val response = conferencesService.save(conferencesMock)
            Assertions.assertEquals(response.id, conferencesMock.id)
        }



            @Test
            fun saveConferencesWhenTitleIsBlank(){
                Assertions.assertThrows(Exception::class.java) {
                    conferencesMock.apply { title=" "}
                    Mockito.`when`(conferencesRepository.save(Mockito.any(Conferences::class.java))).thenReturn(conferencesMock)
                    conferencesService.save(conferencesMock)
                }
            }
        }


