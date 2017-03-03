package Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/tiles")
public class TilesExamController {

	@RequestMapping("/exam03")
	public ModelAndView example03() {
		ModelAndView mav = new ModelAndView();
			mav.setViewName("t_el");
			mav.addObject("title", "Expression Tiles");
			mav.addObject("main", "welcome");
		return mav;
	}
	
	@RequestMapping("/exam04")
	public ModelAndView example04() {
		ModelAndView mav = new ModelAndView();
			mav.setViewName("tw_review/new");
		return mav;
	}
	
	
	@RequestMapping("/exam01")
	public String example01() {
		return "t_01";
	}
	
	@RequestMapping("/exam02")
	public String example02() {
		return "t_04";
	}
}
