package org.example;

import java.util.ArrayList;
import java.util.List;
import static sun.util.locale.LocaleMatcher.filter;

public class Catalog {

    private String name;
    private List<Document> docs = new ArrayList<>();

    public Catalog(String name, String docs) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Document> getDocs() {
        return docs;
    }

    public void setDocs(List<Document> docs) {
        this.docs = docs;
    }

    public void add(Document doc) {
        docs.add(doc);
    }

    public Document findById(String id) {
        docs.stream().filter(d -> d.getId().equals(id)).findFirst().orElse(null);
        return null;
    }
}
