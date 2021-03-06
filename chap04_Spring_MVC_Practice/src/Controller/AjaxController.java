package Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import Model.MemberDao;


@Controller
@RequestMapping("/checkAjax")
public class AjaxController {
	
	@Autowired
	MemberDao mdao;
	
	@RequestMapping("/step01")
	@ResponseBody
	public String cAjaxHandler(@RequestParam(name="id") String id) {
		ModelAndView mav = new ModelAndView("t_join02");
		// boolean rst = mdao.useAvailableCheck(id);
		// 리턴되는 그 값을 SpringDispatcher에서 뷰이름으로 생각하지 않고,
		// 바로 응답으로 출력한다. String 객체만 출력이 가능하고, 한글 출력 불가능
		// 대신 Conveter 를 사용하면, 한글 출력도 가능하고, 기타등등의 효과를 볼수가 있다.
		
		boolean rst = true;	// false;
		// 'YYYYY' or 'NNNNN'  이런 문자만 출력해주면 된다.
		if(rst) 
			return "YYYYY";
		else
			return "NNNNN";
	}

}
