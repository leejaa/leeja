package Model;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.servlet.ServletContext;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class FileUploadService {

	@Autowired
	SqlSessionFactory factory;
	
	@Autowired
	ServletContext application;
	
	public int upload(MultipartFile file,String info) throws Exception{
		
		String path = application.getRealPath("/share");	// ���ε��ϰ���� �� ��θ� ���ϰ�,
		String filename = file.getOriginalFilename();
		
		File dir = new File(path);
		if(!dir.exists()){	// ��δ� ���ٸ� Exception �߻��ϴϱ�
			dir.mkdirs();	// ���丮 �����ϰ�,
		}
		// ���ܵ� ���Ͽ� �ƿ��� ����� read(), write() �۾�
		filename = filename.substring(0, filename.lastIndexOf(".")) + "_2" + filename.substring(filename.lastIndexOf("."));
		
		System.out.println(filename);
		
		File dest = new File(path,filename);	// �ִٸ� ��ħ..
		
		file.transferTo(dest);
		
		
		
		
		
		int rst = 0;
		SqlSession sql = factory.openSession();
		try {
			HashMap param = new HashMap<>();
				param.put("title", info);
				param.put("filename", file.getOriginalFilename());
				param.put("filesize", file.getSize());
				param.put("fileaddress", dest.getPath());
				param.put("filelink", "/share/"+filename);
				
			rst = sql.insert("review.fileUpload", param);
			
			if (rst == 1)
				sql.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			sql.close();
		}
		return rst;
		
		
	}
	
	
	
	public List<HashMap> readFiles() {
		List<HashMap> list = new ArrayList<>();
		SqlSession sql = factory.openSession();
		try {
			list = sql.selectList("review.readFiles");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sql.close();
		}
		return list;
	}
	
	public HashMap readOne(int num) {
		SqlSession session = factory.openSession();
		try {
			return session.selectOne("review.readFile", num);
		} finally {
			session.close();
		}
	}
	
	public int increaseCount(int num) {
		SqlSession session = factory.openSession();
		try {
			int rst = session.update("review.increaseCount", num);
			if(rst !=0)
				session.commit();
			return rst;
		} finally {
			session.close();
		}
	}
}
