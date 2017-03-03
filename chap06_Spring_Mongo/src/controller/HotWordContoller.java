package controller;

import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import model.InfosMongoDao2;

@Controller
@RequestMapping("/find")
public class HotWordContoller {
	
	@Autowired
	InfosMongoDao2 mdao;
	
	
	@RequestMapping("/wordAjax")
	@ResponseBody
	public List AjaxController(@RequestParam(name="start") String start){
		
		List list = mdao.AllWord4(start);
		
		
		return list;
	}
	
	
	
	
	@RequestMapping("/word")
	public String wordController() {
		return "find/word";
	}
	
	@RequestMapping("/result")
	public ModelAndView resultController(@RequestParam Map map) {
		
		mdao.insert(map);
		
		
		List list = mdao.AllWord();
		
		ModelAndView mav = new ModelAndView();
		
		mav.setViewName("find/wordList");
		
		mav.addObject("list",list);
		
		return mav;
		
		
		}
	
	
	@RequestMapping("/result2")
	public ModelAndView resultController2(@RequestParam(name="word") String word ) {
		
		List list = mdao.findWord(word);
				
		ModelAndView mav = new ModelAndView();
		
		mav.setViewName("find/wordFind");
		
		mav.addObject("list",list);
		
		return mav;
		
		
		}
	
}
