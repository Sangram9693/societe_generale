package com.sg.societe_generale.swagger;

import io.swagger.annotations.Contact;
import io.swagger.annotations.ExternalDocs;
import io.swagger.annotations.Info;
import io.swagger.annotations.License;
import io.swagger.annotations.SwaggerDefinition;

@SwaggerDefinition(
        info = @Info(
                description = "Societe Generale Resources",
                version = "V12.0.12",
                title = "Societe Generale",
                contact = @Contact(
                   name = "Sangram Badi", 
                   email = "sangram9693@gmail.com", 
                   url = "https://profilehost-35a97.firebaseapp.com/"
                ),
                license = @License(
                   name = "", 
                   url = "http://localhost:8080/"
                )
        ),
        consumes = {"application/json", "application/xml"},
        produces = {"application/json", "application/xml"},
        schemes = {SwaggerDefinition.Scheme.HTTP, SwaggerDefinition.Scheme.HTTPS},
        externalDocs = @ExternalDocs(value = "Read This For Sure", url = "https://profilehost-35a97.firebaseapp.com/")
)
public interface ApiDocumentationConfig {

}
