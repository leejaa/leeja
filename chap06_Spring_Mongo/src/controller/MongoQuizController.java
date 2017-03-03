package controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import model.InfosMongoDao;
import model.InfosMongoDao2;

@Controller
@RequestMapping("/quiz")
public class MongoQuizController {

	@Autowired
	InfosMongoDao mdao;
	
	@Autowired
	InfosMongoDao2 mdao2;
	
	
	@RequestMapping("/search")
	public String searchHandler(){
		
		return "srch";
	}
	
	@RequestMapping("/search/result")
	public ModelAndView searchResultHandler(@RequestParam(name="gender",required=false) String[] gender
			,@RequestParam(name="taste",required=false) String[] taste){
		System.out.println(gender[0] + taste[0]);
		  
		ModelAndView mav = new ModelAndView();
		
		Map<String,Object> map = new HashMap<>();
		
		map.put("gender", gender);
		
		map.put("taste", taste);
		
		List list = mdao.findAll();
		
		mav.setViewName("result");
		
		mav.addObject("list",list);
		
		return mav;
	}
	
	@RequestMapping("/findSome")
	public String findSome03(){
		
		
		mdao2.aggrTest();
		
		return null;
	}
	
	
}
