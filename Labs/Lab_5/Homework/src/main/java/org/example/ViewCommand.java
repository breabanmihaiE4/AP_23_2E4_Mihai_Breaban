package org.example;

import java.awt.*;
import java.io.File;

public class ViewCommand implements Command {
    @Override
    public void execute(Catalog catalog) throws InvalidCatalogException {
        try {
            File file = new File(catalog.getPath());
            if (!Desktop.isDesktopSupported()) {
                System.out.println("Desktop not supported");
                return;
            }
            Desktop desktop = Desktop.getDesktop();
            if (file.exists())
                desktop.open(file);
        } catch (Exception exception) {
            throw new InvalidCatalogException(exception);
        }
    }
}
