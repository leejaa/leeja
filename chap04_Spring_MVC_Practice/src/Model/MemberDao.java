package Model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberDao {
	@Autowired
	DataSource ds;
	@Autowired
	SqlSessionFactory factory;

	public int addMember(HashMap map) {
		SqlSession sql = factory.openSession();
		int rst = 0;
		
		String id = (String) map.get("id");
		String pass = (String)map.get("pass");
		String name = (String)map.get("name");
		int age = (int) map.get("age");
		String gender = (String) map.get("gender");
		String email = (String) map.get("email");
		
		try {
			HashMap param = new HashMap<>();
			param.put("id", id);
			param.put("pass", pass);
			param.put("name", name);
			param.put("age", age);
			param.put("gender", gender);
			param.put("email", email);
			
			
		rst = sql.insert("member.join", param);
		if (rst == 1)
			sql.commit();
		} catch (Exception e) {
			sql.rollback();
		} finally {
			sql.close();
		}
		return rst;
	}
	
	public int checkMember(HashMap map){
		SqlSession sql = factory.openSession();
		int rst = 0;
		String id = (String) map.get("id");
		String pass = (String)map.get("pass");
		
		try{
			HashMap param = new HashMap<>();
			param.put("id", id);
			param.put("pass", pass);
			rst = sql.selectOne("member.check",param);
		}catch(Exception e){
			sql.rollback();
		}finally{
			sql.close();
		}
		return rst;
	}
	
	public List<HashMap> getGenderList(){
		List<HashMap> list = new ArrayList<>();
		SqlSession sql = factory.openSession();
		try {
			list = sql.selectList("member.gender");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sql.close();
		}
		return list;
	}
	
	public List<HashMap> getAgeList(){
		List<HashMap> list = new ArrayList<>();
		SqlSession sql = factory.openSession();
		try {
			list = sql.selectList("member.age");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sql.close();
		}
		return list;
	}
	
	public int login(HashMap map){
		SqlSession sql = factory.openSession();
		int rst = 0;
		
		String id = (String) map.get("id");
		
		
		try {
			HashMap param = new HashMap<>();
			param.put("id", id);
						
			
		rst = sql.insert("member.login", param);
		if (rst == 1)
			sql.commit();
		} catch (Exception e) {
			sql.rollback();
		} finally {
			sql.close();
		}
		return rst;
	}
	
	public List<HashMap> getAgeLogin(){
		List<HashMap> list = new ArrayList<>();
		SqlSession sql = factory.openSession();
		try {
			list = sql.selectList("member.ageLogin");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sql.close();
		}
		return list;
	}
	
	
	public List<HashMap> getGenderLogin(){
		List<HashMap> list = new ArrayList<>();
		SqlSession sql = factory.openSession();
		try {
			list = sql.selectList("member.genderLogin");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sql.close();
		}
		return list;
	}
	
}
