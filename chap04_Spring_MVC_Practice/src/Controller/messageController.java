package Controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import Model.Dao;

@Controller
public class messageController {

	@Autowired
	Dao dao;
	@RequestMapping("/message/step01")
	public ModelAndView pathHandle01(HttpSession session){
		ModelAndView mav = new ModelAndView();
		
		String id = (String)session.getAttribute("id");
		HashMap param = new HashMap<>();
		
		param.put("receiver", id);
		List<HashMap> list = dao.readMessage(param);
		
		mav.setViewName("tile01");
		mav.addObject("title","메세지");
		mav.addObject("main","/message/main");
		mav.addObject("list", list);
		
		return mav;
	}
	
	@RequestMapping("/message/step02")
	public ModelAndView pathHandle02(){
		ModelAndView mav = new ModelAndView();
		
		mav.setViewName("tile01");
		
		mav.addObject("title", "메세지보내기");
		mav.addObject("main", "/message/write");
		
		return mav;
		
	}
	
	@RequestMapping("/message/step03")
	public ModelAndView pathHandle03(@RequestParam HashMap map,HttpSession session){
		
		ModelAndView mav = new ModelAndView();
		
		String id = (String)map.get("id");
		String content = (String)map.get("content");
		String receiver = (String)map.get("receiver");
		
		int n = dao.createMessage(id, content, receiver);
		
		if(n==1){
			String ID = (String)session.getAttribute("id");
			HashMap param = new HashMap<>();
			
			param.put("receiver", ID);
			List<HashMap> list = dao.readMessage(param);
			
			mav.setViewName("tile01");
			mav.addObject("title","메세지 전송 성공");
			mav.addObject("main","/message/main");
			mav.addObject("list", list);
			
			return mav;
		}else{
			String ID = (String)session.getAttribute("id");
			HashMap param = new HashMap<>();
			
			param.put("receiver", ID);
			List<HashMap> list = dao.readMessage(param);
			
			mav.setViewName("tile01");
			mav.addObject("title","메세지 전송 실패");
			mav.addObject("main","/message/main");
			mav.addObject("list", list);
			
			return mav;
		}
		
		
	}
}
