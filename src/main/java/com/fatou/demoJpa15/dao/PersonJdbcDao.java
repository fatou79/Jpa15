package com.fatou.demoJpa15.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;



@Repository
public class PersonJdbcDao {
	
	@Autowired
	JdbcTemplate sow;
	
	class PersonRowMapper implements RowMapper<Person>{

		@Override
		public Person mapRow(ResultSet rs, int rowNum) throws SQLException {
			Person person = new Person();
			person.setId(rs.getInt("id"));
			person.setName(rs.getString("name"));
			person.setLocation(rs.getString("location"));
			person.setBirthday(rs.getTimestamp("birth_date"));
			
			return person;
		}
	}
	public List<Person> findAll(){
		return sow.query("select * from person",
				new BeanPropertyRowMapper(Person.class));
	}
	
	public Person findById(int id) {
		return sow.queryForObject
				("select * from person where id=?", new Object[] {id},
						new BeanPropertyRowMapper<Person>(Person.class));
	}
	public int deleteById(int id) {
		return sow.update
				("delete from person where id=?" , new  Object[] {id});

}
	public int insert(Person person) {
		return sow.update(
				"insert into person(id, name, location, birth_date)"
				+ "values(?,?,?,?)",
				new  Object[] {
						person.getId(), person.getName(),
						person.getLocation(), new Timestamp(person.getBirthday().getTime()) });
				}
	public int update(Person person) {
		return sow.update(
			" update person " 
          	+ " set name = ?, location = ?, birth_date = ? "
            	+ " where id = ?",
	new Object[] { person.getName() , person.getLocation(), new Timestamp(person.getBirthday().getTime()) ,
			person.getId() });
			
	}

	
	}

	
	
	
	
	
	
