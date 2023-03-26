package org.example;

public interface Command {
    void execute(Catalog catalog) throws InvalidCatalogException;
}
