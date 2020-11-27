package cl.atromilen.jsontocsv;

import cl.atromilen.jsontocsv.service.EmployeeParserService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class HrEmployeesApplicationTests {
    @Autowired
    private EmployeeParserService parserService;

    @Test
    void contextLoads() {
        Assertions.assertNotNull(parserService);
    }

}
