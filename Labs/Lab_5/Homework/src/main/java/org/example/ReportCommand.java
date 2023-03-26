package org.example;

import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.Velocity;

import java.io.File;
import java.io.FileWriter;
import java.io.StringWriter;
import java.io.Writer;

public class ReportCommand implements Command {
    @Override
    public void execute(Catalog catalog) throws InvalidCatalogException {
        try {
            Velocity.init();
            Template template = Velocity.getTemplate("./src/HTMLdocument.vm");

            VelocityContext context = new VelocityContext();
            context.put("name", catalog.getName());
            context.put("document", catalog.getDocuments().toString());

            Writer writer = new FileWriter("./src/HTMLdocument.html");
            template.merge(context, writer);
            writer.close();

        } catch (Exception e) {
            throw new InvalidCatalogException(e);
        }
    }
}

