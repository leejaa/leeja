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
		// ���ϵǴ� �� ���� SpringDispatcher���� ���̸����� �������� �ʰ�,
		// �ٷ� �������� ����Ѵ�. String ��ü�� ����� �����ϰ�, �ѱ� ��� �Ұ���
		// ��� Conveter �� ����ϸ�, �ѱ� ��µ� �����ϰ�, ��Ÿ����� ȿ���� ������ �ִ�.
		
		boolean rst = true;	// false;
		// 'YYYYY' or 'NNNNN'  �̷� ���ڸ� ������ָ� �ȴ�.
		if(rst) 
			return "YYYYY";
		else
			return "NNNNN";
	}

}
