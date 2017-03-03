package Controller;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import Model.MemberDao;

@Controller
public class loginController {
 
	@Autowired
	MemberDao mdao;
	
	@RequestMapping("/")
	public ModelAndView pathHandle01(HttpServletRequest request, HttpServletResponse response, 
			HttpSession session){
		
		ModelAndView mav = new ModelAndView();
		
		
		
		mav.setViewName("tile01");
		mav.addObject("title","메인화면");
		mav.addObject("main", "welcome");
		
		return mav;
	}
	
	@RequestMapping("/login/step01")
	public ModelAndView pathHandle02(HttpServletRequest request, HttpServletResponse response, 
			HttpSession session, @RequestParam(name="id",defaultValue="") String id, 
			@RequestParam(name="pass",defaultValue="")String pass){
		
		ModelAndView mav = new ModelAndView();
		
		HashMap param = new HashMap<>();
		param.put("id", id);
		param.put("pass", pass);
		
		
		int n = mdao.checkMember(param);
		
		if(n==1){
		
			HashMap map = new HashMap<>();
			
			map.put("id", id);
			
			mdao.login(map);
			
			
		
			session.setAttribute("login", "yes");
			session.setAttribute("id", id);
			
		mav.setViewName("tile01");
		mav.addObject("title","로그인성공");
		mav.addObject("main", "welcome");
		
		return mav;
		
		}else{
			mav.setViewName("tile01");
			mav.addObject("title","로그인실패");
			mav.addObject("main", "welcome");
			
			return mav;
		}
	}
	
	
	
	@RequestMapping("/login/step02")
	public ModelAndView pathHandle03(HttpServletRequest request, HttpServletResponse response, 
			HttpSession session, @RequestParam(name="id",defaultValue="") String id, 
			@RequestParam(name="pass",defaultValue="")String pass,
			@RequestParam(name="name",defaultValue="") String name,
			@RequestParam(name="age",defaultValue="") int age,
			@RequestParam(name="gender",defaultValue="") String gender,
			@RequestParam(name="email",defaultValue="") String email){
		
		ModelAndView mav = new ModelAndView();
		
		HashMap param = new HashMap<>();
		param.put("id", id);
		param.put("pass", pass);
		param.put("name", name);
		param.put("age", age);
		param.put("gender", gender);
		param.put("email", email);
		
		
		int n = mdao.addMember(param);
		
		if(n==1){
		
						
		mav.setViewName("tile01");
		mav.addObject("title","회원가입 성공");
		mav.addObject("main", "welcome");
		
		return mav;
		
		}else{
			mav.setViewName("tile01");
			mav.addObject("title","회원가입 실패");
			mav.addObject("main", "welcome");
			
			return mav;
		}
	}
	
	@RequestMapping("/login/step03")
	public ModelAndView pathHandle04(HttpServletRequest request, HttpServletResponse response, 
			HttpSession session){
		ModelAndView mav = new ModelAndView();
		session.invalidate();
		
		mav.setViewName("tile01");
		mav.addObject("title", "로그아웃 성공");
		mav.addObject("main", "welcome");
		
		return mav;
		
	}
}
	
	
	

