package org.example;

import java.io.IOException;
public class Main {
    public static void main(String args[]) throws IOException, InvalidCatalogException {
        Main app = new Main();
        app.testCreateSave();
        app.testLoadView();
    }
    private void testCreateSave() throws IOException {
        Catalog catalog =
                new Catalog("MyDocuments", "article1");
        var book = new Document("article1", "Ion si Ana", "str. 1");
        var article = new Document("book1","Osp", "Str. 2");
        catalog.add(book);
        catalog.add(article);

        CatalogUtil.save(catalog, "C:\\Users\\mihai\\IdeaProjects/catalog.json");
    }
    private void testLoadView() throws InvalidCatalogException, IOException {
        Catalog catalog = CatalogUtil.load("C:\\Users\\mihai\\IdeaProjects/catalog.json");
        CatalogUtil.view(catalog.findById("article1"));
    }
}

