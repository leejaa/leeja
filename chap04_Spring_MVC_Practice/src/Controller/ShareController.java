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
		mav.addObject("title","파일업로드화면");
		mav.addObject("main", "/share/form");
		
		return mav;
	}
	
	@RequestMapping("/share/proc")
	public ModelAndView pathHandle02(@RequestParam(name="info")String info, 
			@RequestParam(name="item")MultipartFile file)throws Exception{
		
		// 컨트롤러쪽에서 해당 파람을 MultipartFile 객체로 받아내면 된다
		// 만약, 아니라면 MultipartFile로 요구한 파람이 type="file"이 아니면 에러가 발생
		// Map 으로 받을시, 파일 제외한 나머지 파람이 Map에 설정됨.
		
		// 업로드 처리는 별개다.
		// 일단 분석해서 얻어낼수 있는 정보들은 다음과 같다.
		
		// 업로드를 하고 싶은 곳에 파일아웃을 시키면 된다.
		// 서버측 플젝 웹컨텐츠아래로 업로드 처리를 진행하게 되니까.
		
		
		
			
			// 옯겨둘 파일에 아웃을 만들고 read(), write() 작업
		
		// sysout.. 출력을 진행해보시고, 어떤건지.. 확인.
		// Thread.sleep(5000);
		//======================================파일을 SQL등록============================================================
		
		int n = fs.upload(file,info);
		
		if(n==1){
			System.out.println("업로드 성공!!");
		}else{
			System.out.println("업로드 실패!!");
		}
		
		List<HashMap> list = new ArrayList<>();
		
		list = fs.readFiles();
				
		ModelAndView mav = new ModelAndView();
		mav.setViewName("tile01");
		mav.addObject("list", list);
		mav.addObject("title", "다운로드목록");
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
				mav.addObject("title", "다운로드목록");
				mav.addObject("main", "/share/download");
				
				
				return mav;
	}
}
