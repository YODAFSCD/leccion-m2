package com.example.event.service



import com.example.member.model.Event
import com.example.member.repository.EventRepository
import com.example.member.service.EventService
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito
import org.springframework.boot.test.context.SpringBootTest
import java.util.*

@SpringBootTest
    class EventServiceTest {

        @InjectMocks
        lateinit var eventService: EventService

        @Mock
        lateinit var eventRepository: EventRepository

            val eventMock = Event().apply {
            id=1
                description="Alison Otavalo"

                totalAttendees= 19

        }

        @Test
        fun saveClientCorrect(){
            Mockito.`when`(eventRepository.save(Mockito.any(Event::class.java))).thenReturn(eventMock)
            val response = eventService.save(eventMock)
            Assertions.assertEquals(response.id, eventMock.id)
        }



            @Test
            fun saveMemberWhenDescriptionIsBlank(){
                Assertions.assertThrows(Exception::class.java) {
                    eventMock.apply { description=" "}
                    Mockito.`when`(eventRepository.save(Mockito.any(Event::class.java))).thenReturn(eventMock)
                    eventService.save(eventMock)
                }
            }
        }


