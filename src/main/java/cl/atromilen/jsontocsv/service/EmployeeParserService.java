package cl.atromilen.jsontocsv.service;

import cl.atromilen.jsontocsv.domain.Employee;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;
import java.util.List;

@Component
public class EmployeeParserService implements CommandLineRunner {
    private static final Logger LOGGER = LoggerFactory.getLogger(EmployeeParserService.class);
    private static final String OUTPUT_FILE = "employees.csv";

    @Override
    public void run(String... args) throws Exception {
        LOGGER.info("Starting Employees Conversion process...");
        if (args.length == 0) {
            LOGGER.error("You must to provide the filepath where is located the Json file");
            return;
        }

        String filePath = args[0];
        try {
            ObjectMapper mapper = new ObjectMapper();
            LOGGER.info("Reading Json contents on file '" + filePath + "'...");
            JsonNode rootName = mapper.readValue(new File(filePath), JsonNode.class);
            JsonNode registros = rootName.get("registros");
            //Variable 'registrosList' used only to count records and report by console
            List<JsonNode> registrosList = registros.findParents("rut");
            LOGGER.info("Number of records 'registros' finded: " + registrosList.size());

            CsvMapper csvMapper = new CsvMapper();
            CsvSchema csvSchema = csvMapper.schemaFor(Employee.class).withHeader();

            LOGGER.info("Reading content of 'registros' as bytes, using the class Employee as mapper type...");
            Employee[] employees = new ObjectMapper().readValue(registros.toString().getBytes(), Employee[].class);

            LOGGER.info("Writing csv file located on " + OUTPUT_FILE + " with contents of employees...");
            csvMapper.writerFor(Employee[].class)
                    .with(csvSchema)
                    .writeValue(new File(OUTPUT_FILE), employees);

            LOGGER.info("Employees Conversion process terminated with success.");

        } catch (JsonParseException e) {
            LOGGER.error("Json parse error: ", e);
        } catch (JsonMappingException e) {
            LOGGER.error("Json mapping error: ", e);
        } catch (IOException e) {
            LOGGER.error("I/O error: ", e);
        }
    }
}
