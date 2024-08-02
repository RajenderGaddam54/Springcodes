
package com.example.SpringJDBC.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.example.SpringJDBC.model.Alien;

@Repository
public class AlienRepository {
	
	private JdbcTemplate template;

	public JdbcTemplate getTemplate() {
		return template;
	}
    
	@Autowired
	public void setTemplate(JdbcTemplate template) {
		this.template = template;
	}
	
	public void add_alien(Alien alien) {
		
		String sql = "insert into aliens values(?,?,?)";
		int row = template.update(sql,alien.getId(),alien.getName(),alien.getTech());
		
		System.out.println("rows affected:"+ row);
	}
	
	public List<Alien> getall(){
		
		String q = "select * from aliens";
		
		RowMapper<Alien> mapper = new RowMapper<>() {

			@Override
			public Alien mapRow(ResultSet rs, int rowNum) throws SQLException {
				// TODO Auto-generated method stub
				Alien a = new Alien();
				a.setId(rs.getInt(1));
				a.setName(rs.getString(2));
				a.setTech(rs.getString(3));
				return a;
			}
		};	
		
		List<Alien> aliens = template.query(q,mapper);	
		return aliens;
	

}
}
