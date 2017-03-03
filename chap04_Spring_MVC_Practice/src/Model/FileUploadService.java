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
		
		String path = application.getRealPath("/share");	// 업로드하고싶은 실 경로를 구하고,
		String filename = file.getOriginalFilename();
		
		File dir = new File(path);
		if(!dir.exists()){	// 경로는 없다면 Exception 발생하니까
			dir.mkdirs();	// 디렉토리 생성하고,
		}
		// 옯겨둘 파일에 아웃을 만들고 read(), write() 작업
		filename = filename.substring(0, filename.lastIndexOf(".")) + "_2" + filename.substring(filename.lastIndexOf("."));
		
		System.out.println(filename);
		
		File dest = new File(path,filename);	// 있다면 겹침..
		
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
