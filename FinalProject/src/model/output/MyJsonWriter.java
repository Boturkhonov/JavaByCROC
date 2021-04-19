package model.output;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.Map;

public class MyJsonWriter {

    private static final ObjectMapper mapper = new ObjectMapper();


    public static void writeCheapProducts(List<CheapProduct> cheapProducts, String path) throws IOException {

        try (FileOutputStream fos = new FileOutputStream(path)) {
            mapper.enable(SerializationFeature.INDENT_OUTPUT);
            mapper.writeValue(fos, cheapProducts);
        }

    }

    public static void writePopularDates(Map<String, Integer> popularDates, String path) throws IOException {

        try (FileOutputStream fos = new FileOutputStream(path)) {
            mapper.enable(SerializationFeature.INDENT_OUTPUT);
            mapper.writeValue(fos, popularDates);
        }

    }

}
