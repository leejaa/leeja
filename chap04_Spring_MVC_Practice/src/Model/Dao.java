package Model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class Dao {
	@Autowired
	SqlSessionFactory factory;
	public int createOne(String writer, String content, String ip) {
		int rst = 0;
		SqlSession sql = factory.openSession();
		try {
			HashMap param = new HashMap<>();
				param.put("WRITER", writer);
				param.put("CONTENT", content);
				param.put("IP", ip);
			rst = sql.insert("review.createOne", param);
			if (rst == 1)
				sql.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			sql.close();
		}
		return rst;
	}

	public List<HashMap> readAll() {
		List<HashMap> list = new ArrayList<>();
		SqlSession sql = factory.openSession();
		try {
			list = sql.selectList("review.readAll");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sql.close();
		}
		return list;
	}
	
	public List<HashMap> readFreeboard(int start, int end){
		List<HashMap> list = new ArrayList<>();
		
		HashMap param = new HashMap<>();
		
		param.put("start", start);
		param.put("end", end);
		
		SqlSession sql = factory.openSession();
		try{
			list = sql.selectList("review.readFreeboard", param);
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			sql.close();
		}
		return list;
	}
	
	public int cntFreeboard(){
		SqlSession sql = factory.openSession();
		
		int cnt = sql.selectOne("review.cntFreeboard");
		
		return cnt;
	}
	
	
	public int writeFreeboard(HashMap param){
		int rst = 0;
		SqlSession sql = factory.openSession();
		try{
			sql.selectOne("review.writeFreeboard",param);
		}catch(Exception e){
			e.printStackTrace();
		}finally {
			sql.close();
		}
		return rst;
	}
	
	public HashMap readOne(HashMap param){
		SqlSession sql = factory.openSession();
		
		HashMap map = sql.selectOne("review.readOne",param);
		
		return map;
	}
	
	public int like(){
		SqlSession sql = factory.openSession();
		
		HashMap param = new HashMap<>();
		
		param.put("like", 1);
	
		int n = sql.selectOne("review.like",param);
		
		return n;
	}
	
	
	public List<HashMap> readMessage(HashMap param) {
		List<HashMap> list = new ArrayList<>();
		SqlSession sql = factory.openSession();
		try {
			list = sql.selectList("review.readMessage",param);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sql.close();
		}
		return list;
	}
	
	public int createMessage(String id, String content, String receiver) {
		int rst = 0;
		SqlSession sql = factory.openSession();
		try {
			HashMap param = new HashMap<>();
				param.put("id", id);
				param.put("content", content);
				param.put("receiver", receiver);
			rst = sql.insert("review.createMessage", param);
			if (rst == 1)
				sql.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			sql.close();
		}
		return rst;
	}
	
	public int updateFreeboard(HashMap map){
		int rst = 0;
		SqlSession sql = factory.openSession();
		try {
			HashMap param = new HashMap<>();
				param.put("num", map.get("num"));
				param.put("category", map.get("category"));
				param.put("title", map.get("title"));
				param.put("content", map.get("content"));
			rst = sql.insert("review.updateFreeboard", param);
			if (rst == 1)
				sql.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			sql.close();
		}
		return rst;
	}
	
	
	
}
