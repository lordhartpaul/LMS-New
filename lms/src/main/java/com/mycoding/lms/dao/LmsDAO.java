package com.mycoding.lms.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;


import com.mycoding.lms.model.Lms;



@Service
public class LmsDAO {
	
	JdbcTemplate template;
	
	@Autowired
	public void setDataSource(DataSource datasource) {
		template = new JdbcTemplate(datasource);
	}
	
	public void save(Lms p)
	{
		String sql = "insert into lms(empId,empName,leaveType,fromDate,toDate,numberofDays,manager,reason,contact,email,ccTo) values ("+p.getEmpId()+",'"+p.getEmpName()+"','"+convertListToDeLimtedString(p.getLeaveType())+"','"+ConvertDate(p.getFromDate())+"','"+ConvertDate(p.getToDate())+"',"+p.getNumberofDays()+",'"+convertListToDeLimtedString(p.getManager())+"','"+p.getReason()+"',"+p.getContact()+",'"+p.getEmail()+"','"+convertListToDeLimtedString(p.getCcTo())+"')";
	
	    template.update(sql);
	
	}
	
public List<Lms> getAllLmss(){
		
		return template.query("select * from lms", new ResultSetExtractor<List<Lms>>() {
			
			public List<Lms> extractData(ResultSet rs) throws SQLException,DataAccessException
			{
				List<Lms> list = new ArrayList<Lms>();
				while(rs.next())
				{
					Lms e = new Lms();
					e.setId(rs.getInt(1));
					e.setEmpId(rs.getInt(2));
					e.setEmpName(rs.getString(3));
					e.setLeaveType(convertDelimitedStringToList(rs.getString(4)));
					e.setFromDate(rs.getDate(5));
					e.setToDate(rs.getDate(6));
					e.setNumberofDays(rs.getInt(7));
					e.setManager(convertDelimitedStringToList(rs.getString(8)));
					e.setReason(rs.getString(9));
					e.setContact(rs.getInt(10));
					e.setEmail(rs.getString(11));
					e.setCcTo(convertDelimitedStringToList(rs.getString(12)));
					
					list.add(e);
					
					}
				return list;
			}
			
		});
	}
	
public List<Lms> getLmssByPage(int pageid, int total){
	
	
	String sql = "select * from lms limit "+(pageid-1)+","+total;
	
	return template.query(sql, new ResultSetExtractor<List<Lms>>() {
			
			public List<Lms> extractData(ResultSet rs) throws SQLException,DataAccessException
			{
				List<Lms> list = new ArrayList<Lms>();
				while(rs.next())
				{
					Lms e = new Lms();
					e.setId(rs.getInt(1));
					e.setEmpId(rs.getInt(2));
					e.setEmpName(rs.getString(3));
					e.setLeaveType(convertDelimitedStringToList(rs.getString(4)));
					e.setFromDate(rs.getDate(5));
					e.setToDate(rs.getDate(6));
					e.setNumberofDays(rs.getInt(7));
					e.setManager(convertDelimitedStringToList(rs.getString(8)));
					e.setReason(rs.getString(9));
					e.setContact(rs.getInt(10));
					e.setEmail(rs.getString(11));
					e.setCcTo(convertDelimitedStringToList(rs.getString(12)));
					
					list.add(e);
					
					}
				return list;
			}
			
		});
	}
	
public Lms getLmsById(int id){
	   return template.query("select * from lms where ID="+id,new ResultSetExtractor<Lms>() {
			
			public Lms extractData(ResultSet rs) throws SQLException,DataAccessException
			{
				Lms e = new Lms();
				while(rs.next())
				{
					
					e.setId(rs.getInt(1));
					e.setEmpId(rs.getInt(2));
					e.setEmpName(rs.getString(3));
					e.setLeaveType(convertDelimitedStringToList(rs.getString(4)));
					e.setFromDate(rs.getDate(5));
					e.setToDate(rs.getDate(6));
					e.setNumberofDays(rs.getInt(7));
					e.setManager(convertDelimitedStringToList(rs.getString(8)));
					e.setReason(rs.getString(9));
					e.setContact(rs.getInt(10));
					e.setEmail(rs.getString(11));
					e.setCcTo(convertDelimitedStringToList(rs.getString(12)));
					
					
					}
				return e;
			}
			
		});
	
}

public void update(Lms p)
{
	String sql="update Lms set empId ="+p.getEmpId()+",empName='"+p.getEmpName()+"',leaveType='"+convertListToDeLimtedString(p.getLeaveType())+"',fromDate='"+ConvertDate(p.getFromDate())+"',toDate='"+ConvertDate(p.getToDate())+"',numberofDays="+p.getNumberofDays()+",manager='"+convertListToDeLimtedString(p.getManager())+"',reason='"+p.getReason()+"',contact="+p.getContact()+",email='"+p.getEmail()+"',ccTo='"+convertListToDeLimtedString(p.getCcTo())+"' where ID="+p.getId()+"";
    template.update(sql);

}
	
public void delete(int id) {
	
	String sql="delete from Lms where ID="+id+"";
	template.update(sql);
}

public void delete() {
	
	String sql = "delete from Lms where ID>0";
	template.update(sql);
}

	
	
	private String convertListToDeLimtedString(List<String> list)
	{
		
		String result = "";
		if(list != null) {
			
			result = StringUtils.arrayToCommaDelimitedString(list.toArray());
			
		}
		
		return result;
		
	}
	
private String ConvertDate(Date date) {
		
		String formatDate = "";
		
		try
		{
			DateFormat formatter = new SimpleDateFormat("EEE MMM dd HH:mm:ss Z yyyy");
			date = (Date)formatter.parse(date.toString());
			Calendar cal = Calendar.getInstance();
			cal.setTime(date);
			formatDate = cal.get(Calendar.YEAR)+"-"+cal.get(Calendar.MONTH)+"-"+cal.get(Calendar.DATE);
			
		}catch (Exception e) {
			
			e.printStackTrace();
		}
		
		return formatDate;
	}
	
	private List<String> convertDelimitedStringToList(String delimitedString){
		
		List<String> result = new ArrayList<String>();
		if(!StringUtils.isEmpty(delimitedString)) {
			result = Arrays.asList(StringUtils.delimitedListToStringArray(delimitedString, ","));
		}
		
		return result;
	}
	
	public int count() {
		String sql ="select count(*) from Lms";
		int count = template.queryForObject(sql, Integer.class);
		return count;
	}

}
