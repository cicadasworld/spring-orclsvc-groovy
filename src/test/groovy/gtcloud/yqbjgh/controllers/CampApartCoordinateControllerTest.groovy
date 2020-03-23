package gtcloud.yqbjgh.controllers

import org.junit.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.http.HttpStatus
import org.springframework.test.web.servlet.MockMvc
import spock.lang.Specification

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get

@SpringBootTest
@AutoConfigureMockMvc
class CampApartCoordinateControllerTest extends Specification {

    @Autowired
    private MockMvc mockMvc

    @Test
    def "GetCampApartCoordinate"() {
        given: 'expected Result'
        def expected = new File('src/test/resources/CampApartCoordinateControllerTest/camp-apart-coordinate-FD012171.txt').getText()

        when: "REST Controller is called"
        def result = mockMvc.perform(get("/camp-apart-coordinate/{apartId}", "FD012171")).andReturn().response

        then: 'status is 200 OK'
        result.status == HttpStatus.OK.value()

        then: 'result is not empty'
        result.contentAsString != null

        and: 'contains expected json string'
        result.contentAsString == expected
    }
}
