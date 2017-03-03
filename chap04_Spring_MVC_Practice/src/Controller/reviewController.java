package Controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.xml.ws.http.HTTPException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.HttpServletBean;
import org.springframework.web.servlet.ModelAndView;

import Model.Dao;

@Controller
public class reviewController {
	@Autowired
	Dao dao;

	@RequestMapping("/review/step01")
	public ModelAndView pathHandle(HttpServletRequest request, HttpServletResponse response, 
			HttpSession session){
		
		ModelAndView mav = new ModelAndView();	
		
		mav.setViewName("tile01");
		
		mav.addObject("title", "리뷰화면");
		
		mav.addObject("main", "review/main");
		
					
	return mav;
		
	}
	
	@RequestMapping(value="/review/step02", method=RequestMethod.GET)
	public ModelAndView pathHandle02(@RequestParam(name="writer",defaultValue="") String writer, 
			@RequestParam(name="content",defaultValue="")String content,HttpServletRequest request){
		
		ModelAndView mav = new ModelAndView();
		
		mav.setViewName("tile01");
		mav.addObject("main","review/main");
		
		String ip = request.getRemoteAddr();
		
		
		int n = dao.createOne(writer, content,ip);
		
		if(n==1){
			mav.addObject("title","등록성공!!");
			return mav;
		}else{
			mav.addObject("title","등록실패!!");
			return mav;
		}
		
		
		
	}
	
	@RequestMapping("/review/reviewAjax")
	@ResponseBody
	public List<HashMap> pathHandle03(){
		
		
		List<HashMap> list = dao.readAll();
		
		
		return list;
		
	}
	
	
	
}
