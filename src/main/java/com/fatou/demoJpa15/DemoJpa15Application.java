package com.fatou.demoJpa15;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.fatou.demoJpa15.dao.Person;
import com.fatou.demoJpa15.dao.PersonJdbcDao;
import com.fatou.demoJpa15.dao.PersonJpaRepository;

@SpringBootApplication
public class DemoJpa15Application implements CommandLineRunner {
	
	private Logger ba = LoggerFactory.getLogger(this.getClass());
	
@Autowired
PersonJpaRepository ora;	

	public static void main(String[] args) {
		SpringApplication.run(DemoJpa15Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

	//	ba.info("All users -> {}", bank.findAll());
		ba.info("User id 10001 -> {}", ora.findById(10001));
	//	ba.info("deleting 10002 -> no of Rows Deleted - {}",
			//	bank.deleteById(10002));
		
	
	//	ba.info("Inserting 10004 -> {}",
	//			bank.insert(new Person(10004, "ama", "Dakar", new Date())));
		//ba.info("Update 10003  -> {}",
		//		bank.update(new Person(10003, "niang", "Usa", new Date())));
		
	}
	}


