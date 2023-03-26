package org.example;

import java.io.IOException;

public class Main {
    public static void main(String args[]) throws IOException, InvalidCatalogException {
        Main app = new Main();
        app.testCreateSave();
    }

    private void testCreateSave() throws IOException {
        Command listCommand = new ListCommand();
        Command viewCommand = new ViewCommand();
        Command reportCommand = new ReportCommand();
        Catalog catalog = new Catalog("MyDocuments");
        var book = new Document("article1", "Ion si Ana");
        var article = new Document("book1", "Osp");
        catalog.add(book);
        catalog.add(article);
        CatalogUtil.save(catalog, "C:\\Users\\mihai\\Downloads\\AP_23_2E4_Mihai_Breaban\\Labs\\Lab_5\\Homework/catalog.json");

        try {
            listCommand.execute(catalog);
            viewCommand.execute(catalog);
            reportCommand.execute(catalog);
        } catch (InvalidCatalogException e) {
            e.printStackTrace();
        }
    }
}

