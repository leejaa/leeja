package Controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import Model.Dao;
import Model.FileUploadService;

@Controller
public class ShareController {

	@Autowired
	ServletContext application;
	@Autowired
	Dao dao;
	@Autowired
	FileUploadService fs;
	
	@RequestMapping("/share/form")
	public ModelAndView pathHandle01(){
		
		ModelAndView mav = new ModelAndView();
		
		mav.setViewName("tile01");
		mav.addObject("title","���Ͼ��ε�ȭ��");
		mav.addObject("main", "/share/form");
		
		return mav;
	}
	
	@RequestMapping("/share/proc")
	public ModelAndView pathHandle02(@RequestParam(name="info")String info, 
			@RequestParam(name="item")MultipartFile file)throws Exception{
		
		// ��Ʈ�ѷ��ʿ��� �ش� �Ķ��� MultipartFile ��ü�� �޾Ƴ��� �ȴ�
		// ����, �ƴ϶�� MultipartFile�� �䱸�� �Ķ��� type="file"�� �ƴϸ� ������ �߻�
		// Map ���� ������, ���� ������ ������ �Ķ��� Map�� ������.
		
		// ���ε� ó���� ������.
		// �ϴ� �м��ؼ� ���� �ִ� �������� ������ ����.
		
		// ���ε带 �ϰ� ���� ���� ���Ͼƿ��� ��Ű�� �ȴ�.
		// ������ ���� ���������Ʒ��� ���ε� ó���� �����ϰ� �Ǵϱ�.
		
		
		
			
			// ���ܵ� ���Ͽ� �ƿ��� ����� read(), write() �۾�
		
		// sysout.. ����� �����غ��ð�, �����.. Ȯ��.
		// Thread.sleep(5000);
		//======================================������ SQL���============================================================
		
		int n = fs.upload(file,info);
		
		if(n==1){
			System.out.println("���ε� ����!!");
		}else{
			System.out.println("���ε� ����!!");
		}
		
		List<HashMap> list = new ArrayList<>();
		
		list = fs.readFiles();
				
		ModelAndView mav = new ModelAndView();
		mav.setViewName("tile01");
		mav.addObject("list", list);
		mav.addObject("title", "�ٿ�ε���");
		mav.addObject("main", "/share/download");
		
		
		return mav;
	}
	
	@RequestMapping("/share/down")
		ModelAndView pathHandle03(@RequestParam(name="num")int num){
		
		ModelAndView mav = new ModelAndView("downView");
		
		HashMap map = new HashMap<>();
		
		fs.increaseCount(num);
		map = fs.readOne(num);
		
		mav.addObject("map", map);
		
		return mav;
		
	}
	
	@RequestMapping("/share/goList")
		ModelAndView pathHandle04(){
			List<HashMap> list = new ArrayList<>();
		
				list = fs.readFiles();
						
				ModelAndView mav = new ModelAndView();
				mav.setViewName("tile01");
				mav.addObject("list", list);
				mav.addObject("title", "�ٿ�ε���");
				mav.addObject("main", "/share/download");
				
				
				return mav;
	}
}
