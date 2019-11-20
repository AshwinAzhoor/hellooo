package com.ust.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.ust.beans.Sales;

public class productDao {
	
	JdbcTemplate template;

	public void setTemplate(JdbcTemplate template) {
		this.template = template;
	}
	
	public List<Sales> viewSalesList(){
		return template.query("select pid,pname,pcost,createddate,pdid from tableproduct1 join tableproductDesc1 using (pid)", new RowMapper<Sales>(){

			@Override
			public Sales mapRow(ResultSet rs, int row) throws SQLException {
				// TODO Auto-generated method stub
				Sales s=new Sales();
				s.setpId(rs.getInt(1));
				s.setpName(rs.getString(2));
				s.setpCost(rs.getString(3));
				s.setScreatedDate(rs.getDate(4));
				s.setpDId(rs.getInt(5));
				
				return s;
			}
			
		});
	}
	
	public Sales getSalesById(int pId) {
		String sql = "select pid,pname,pcost,createddate from tableproduct1 join tableproductDesc1 using (pid) where pId=?";
		return template.queryForObject(sql, new Object[] { pId },
				new BeanPropertyRowMapper<Sales>(Sales.class));
	}
	
	public List<Sales> searchList(String search){
		return template.query("select pid,pname,pcost,createddate from tableproduct1 join tableproductDesc1 using (pid) where pId like '"+search+"' or pName like '"+search+"'", new RowMapper<Sales>(){

			@Override
			public Sales mapRow(ResultSet rs, int row) throws SQLException {
				// TODO Auto-generated method stub
				Sales s=new Sales();
				s.setpId(rs.getInt(1));
				s.setpName(rs.getString(2));
				s.setpCost(rs.getString(3));
				s.setScreatedDate(rs.getDate(4));
				
				return s;
			}
			
		});
	}
	
	public int insertSales(Sales s) {

		String sql = "insert into tableproduct1 (pname) values (?)";
		template.update(sql,new Object[] { s.getpName() });
		
		String sql2="select max(pid) from tableproduct1 ";
		int pid= template.queryForObject(sql2,Integer.class);
		
		String sql3 = "insert into tableproductDesc1 (pid,pcost,createddate) values (?,?,TO_DATE('"+java.time.LocalDate.now()+"','yyyy/MM/dd'))";
		return template.update(sql3,new Object[] {pid,s.getpCost()});
		

	}
	
	public int updateSales(Sales s){
		String sql="update tableproduct1 set pname=? where pid=?";
		template.update(sql,new Object[]{s.getpName(),s.getpId()});
		
		String sql2="update tableproductDesc1 set pcost=? where pid=?";
		return template.update(sql2,new Object[]{s.getpCost(),s.getpId()});
	}
	
	public int deleteSales(int pId){
		String sql="delete from tableproduct1 where pid=?";
		return template.update(sql,new Object[]{pId});
		
	}
	

	
	
	
	 

	

}
