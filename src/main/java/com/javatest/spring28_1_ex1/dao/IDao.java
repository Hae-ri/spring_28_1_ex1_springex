package com.javatest.spring28_1_ex1.dao;

import java.util.ArrayList;

import com.javatest.spring28_1_ex1.dto.ContentDto;

public interface IDao {

	public ArrayList<ContentDto> listDao();
	
	public void writeDao(String mwriter, String mcontent);
	
	public ContentDto viewDao(String mid);
	
	public void deleteDao(String mid);
		
}
