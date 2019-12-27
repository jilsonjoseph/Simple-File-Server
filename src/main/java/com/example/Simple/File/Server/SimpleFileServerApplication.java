package com.example.Simple.File.Server;

import io.undertow.Undertow;
import io.undertow.server.handlers.resource.PathResourceManager;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import static io.undertow.Handlers.resource;

import java.nio.file.Paths;

@SpringBootApplication
public class SimpleFileServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(SimpleFileServerApplication.class, args);
		Undertow server = Undertow.builder().addHttpListener(8084, "localhost")
				.setHandler(resource(new PathResourceManager(Paths.get(System.getProperty("user.dir")), 100))
						.setDirectoryListingEnabled(true))
				.build();
		server.start();
	}

}
