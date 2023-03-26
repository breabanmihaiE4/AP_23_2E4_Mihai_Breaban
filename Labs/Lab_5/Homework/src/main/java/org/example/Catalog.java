package org.example;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Catalog implements Serializable {
    private String name;
    private List<Document> documents = new ArrayList<>();

    private String path;

    public Catalog(String name) {
        this.name = name;
    }

    public Catalog(String name, List<Document> documents) {
        this.name = name;
        this.documents = documents;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Document> getDocuments() {
        return documents;
    }

    public void setDocuments(List<Document> documents) {
        this.documents = documents;
    }

    public void add(Document document) {
        documents.add(document);
    }

    public void setDocumentsPath(String location) {
        documents.forEach(document -> document.setPath(location));
    }

    public Document findById(String id) {
        documents.stream().filter(d -> d.getId().equals(id)).findFirst().orElse(null);
        return null;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }
}
