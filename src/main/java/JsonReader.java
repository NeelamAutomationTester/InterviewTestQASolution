
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class JsonReader {

        private final ObjectMapper mapper = new ObjectMapper();

        Path jsonFile = Path.of(".\\data\\Cost Analysis.json");

        public List<CostAnalysis> load(Path path) throws IOException {

            try (InputStream in = Files.newInputStream(jsonFile)) {
            return mapper.readValue(in,new TypeReference<List<CostAnalysis>>() {});
}
}

public List<CostAnalysis> readRecords() throws IOException {
    Path path = Path.of("Cost Analysis.json");
    List<CostAnalysis> records = new JsonReader().load(path);
    return records;
}

}

            
         
      