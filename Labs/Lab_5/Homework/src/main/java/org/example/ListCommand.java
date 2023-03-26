package org.example;

public class ListCommand implements Command {
    @Override
    public void execute(Catalog catalog) {
        catalog.getDocuments().forEach(document -> System.out.println(document.toString()));
    }
}
