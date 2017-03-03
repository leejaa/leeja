package Controller;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import Model.MemberDao;

@Controller
public class memberController {

	@Autowired
	MemberDao mdao;
	
	@RequestMapping("/member/step01")
	public ModelAndView pathHandle(){
		ModelAndView mav = new ModelAndView();
		
		
		List<HashMap> list1 = mdao.getAgeList();
		
		List<HashMap> list2 = mdao.getGenderList();
		
		List<HashMap> list3 = mdao.getAgeLogin();
		
		List<HashMap> list4 = mdao.getGenderLogin();
		
		
		
		mav.setViewName("tile01");
		mav.addObject("list1", list1);
		mav.addObject("list2", list2);
		mav.addObject("list3", list3);
		mav.addObject("list4", list4);
		mav.addObject("title", "∏‚πˆµ•¿Ã≈Õ");
		mav.addObject("main", "/member/main");
		
		return mav;
	}
}
