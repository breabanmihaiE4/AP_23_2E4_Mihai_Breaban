package org.example;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

public class CatalogUtil {
    public static void save(Catalog catalog, String path) throws IOException {
        catalog.setDocumentsPath(path);
        catalog.setPath(path);
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.writeValue(new File(path), catalog);
    }
    public static Catalog load(String path) throws InvalidCatalogException, IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            InputStream is = Catalog.class.getResourceAsStream(path);
            Catalog catalog = objectMapper.readValue(is, Catalog.class);
            return catalog;
        } catch (IOException exception) {
            throw new IOException(exception);
        }
    }
}


