package com.ketki.worklyProject.directory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CrudApplication implements CommandLineRunner {
	//ProdDB prodDB;
	@Autowired
	DB db;

	public static void main(String[] args) {
		SpringApplication.run(CrudApplication.class, args);
		//	prodDB = new ProdDB();
		//	System.out.println(prodDB.getData());
	}

	@Override
	public void run(String... args) throws Exception {
		//prodDB = new ProdDB();
		//db = new ProdDB(); - not recommended
		//System.out.println(prodDB.getData());
		System.out.println(db.getData());
	}
}
