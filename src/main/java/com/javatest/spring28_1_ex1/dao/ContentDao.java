package com.javatest.spring28_1_ex1.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.PreparedStatementSetter;

import com.javatest.spring28_1_ex1.dto.ContentDto;

public class ContentDao implements IDao {

	JdbcTemplate template;

	@Autowired
	public void setTemplate(JdbcTemplate template) {
		this.template = template;
	}

	public ContentDao() {
		super();
		// TODO Auto-generated constructor stub
	}


	@Override
	public ArrayList<ContentDto> listDao() {
//		// TODO Auto-generated method stub
//		
//		String query = "select * from board order by mid desc";
//		ArrayList<ContentDto> dtos = (ArrayList<ContentDto>) template.query(query, new BeanPropertyRowMapper<ContentDto>(ContentDto.class));
//		
		return null;
	}

	@Override
	public void writeDao(final String mwriter, final String mcontent) {
		// TODO Auto-generated method stub
		this.template.update(new PreparedStatementCreator() {
			
			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				// TODO Auto-generated method stub
				String query="insert into board (mid, mwriter, mcontent) values (BOARD_SEQ.nextval,?,?)";
				
				PreparedStatement ps = con.prepareStatement(query);
				ps.setString(1, mwriter);
				ps.setString(2, mcontent);
				
				return ps;
			}
		});
	}

	@Override
	public ContentDto viewDao(String strId) {
		// TODO Auto-generated method stub
		
		String query = "select * from board where mid="+strId ;
		ContentDto dto = template.queryForObject(query, new BeanPropertyRowMapper(ContentDto.class));
		
		return dto;
	}

	@Override
	public void deleteDao(final String mid) {
		// TODO Auto-generated method stub
		
		String query="delete from board where mid=?";
		this.template.update(query, new PreparedStatementSetter() {
			
			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				// TODO Auto-generated method stub
				ps.setInt(1, Integer.parseInt(mid));
			}
		});
		
		
	}
	
}
