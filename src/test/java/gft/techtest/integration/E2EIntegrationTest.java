package gft.techtest.integration;

import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.stream.Stream;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@SpringBootTest
@AutoConfigureMockMvc
public class E2EIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @ParameterizedTest
    @MethodSource("getTestParams")
    @Sql(value = {"/create_prices_test_table.sql"}, executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
    @Sql(value = {"/delete_prices_test_table.sql"}, executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD)
    public void testFindAllEndpointInvokesControllerMethod(ExpectedParam testParams) throws Exception {

        mockMvc.perform(MockMvcRequestBuilders.get("/prices")
                .param("applicationDate", testParams.getApplicationDate().toString())
                .param("productId", testParams.getProductId().toString())
                .param("brandId", testParams.getBrandId().toString())
                ).andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.productId").value(testParams.getProductId()))
                .andExpect(MockMvcResultMatchers.jsonPath("$.brandId").value(testParams.getBrandId()))
                .andExpect(MockMvcResultMatchers.jsonPath("$.price").value(testParams.getExpectedPrice()))
                .andExpect(MockMvcResultMatchers.jsonPath("$.startDate").value(testParams.getExpectedStartDate()))
                .andExpect(MockMvcResultMatchers.jsonPath("$.endDate").value(testParams.getExpectedEndDate()));

    }
    public Stream<ExpectedParam> getTestParams() {
        return Stream.of(firstTestParam(), secondTestParam(), thirdTestParam(), fourthTestParam(), fifthTestParam());
    }

    //Test 1: petición a las 10:00 del día 14 del producto 35455   para la brand 1 (ZARA)
    public ExpectedParam firstTestParam(){
        LocalDateTime testApplicationDate = LocalDateTime.of(2020, 6, 14, 10, 0);
        LocalDateTime testStartDate = LocalDateTime.of(2020, 6, 14, 0, 0);
        LocalDateTime testEndDate = LocalDateTime.of(2020, 12, 31, 23, 59, 59);
        ExpectedParam testParam = new ExpectedParam(testApplicationDate, 35455L, 1L);
        testParam.setExpectations(35.50, testStartDate, testEndDate);

        return testParam;
    }

    //Test 2: petición a las 16:00 del día 14 del producto 35455   para la brand 1 (ZARA)
    public ExpectedParam secondTestParam(){
        LocalDateTime testApplicationDate = LocalDateTime.of(2020, 6, 14, 16, 0);
        LocalDateTime testStartDate = LocalDateTime.of(2020, 6, 14, 15, 0);
        LocalDateTime testEndDate = LocalDateTime.of(2020, 6, 14, 18, 30);
        ExpectedParam testParam = new ExpectedParam(testApplicationDate, 35455L, 1L);
        testParam.setExpectations(25.45, testStartDate, testEndDate);

        return testParam;
    }

    //Test 3: petición a las 21:00 del día 14 del producto 35455   para la brand 1 (ZARA)
    public ExpectedParam thirdTestParam(){
        LocalDateTime testApplicationDate = LocalDateTime.of(2020, 6, 14, 21, 0);
        LocalDateTime testStartDate = LocalDateTime.of(2020, 6, 14, 0, 0);
        LocalDateTime testEndDate = LocalDateTime.of(2020, 12, 31, 23, 59,59);
        ExpectedParam testParam = new ExpectedParam(testApplicationDate, 35455L, 1L);
        testParam.setExpectations(35.50, testStartDate, testEndDate);


        return testParam;
    }

    //Test 4: petición a las 10:00 del día 15 del producto 35455   para la brand 1 (ZARA)
    public ExpectedParam fourthTestParam(){
        LocalDateTime testApplicationDate = LocalDateTime.of(2020, 6, 15, 10, 0);
        LocalDateTime testStartDate = LocalDateTime.of(2020, 6, 15, 0, 0);
        LocalDateTime testEndDate = LocalDateTime.of(2020, 6, 15, 11, 0);
        ExpectedParam testParam = new ExpectedParam(testApplicationDate, 35455L, 1L);
        testParam.setExpectations(30.50, testStartDate, testEndDate);

        return testParam;
    }

    //Test 5: petición a las 21:00 del día 16 del producto 35455   para la brand 1 (ZARA)
    public ExpectedParam fifthTestParam(){
        LocalDateTime testApplicationDate = LocalDateTime.of(2020, 6, 16, 21, 0);
        LocalDateTime testStartDate = LocalDateTime.of(2020, 6, 15, 16, 0);
        LocalDateTime testEndDate = LocalDateTime.of(2020, 12, 31, 23, 59, 59);
        ExpectedParam testParam = new ExpectedParam(testApplicationDate, 35455L, 1L);
        testParam.setExpectations(38.95, testStartDate, testEndDate);

        return testParam;
    }
    
}
