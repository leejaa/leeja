package controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import model.InfosMongoDao2;

@Controller
@RequestMapping("/research")
public class DataSettingController {
	@Autowired
	MongoTemplate template;
	
	@Autowired
	InfosMongoDao2 mdao;
	
	@RequestMapping("/init")
	public void initHandler() {
		String[] bloods = new String[]{"A", "B", "O", "AB" };
		String[] religions = new String[]{"õ�ֱ�", "�⵶��", "�ұ�", "��Ÿ��", "����" };
		String[] birth = new String[]{"��","����","����","�ܿ�" };
		
		for(int i=1; i<5000; i++) {
			Map map = new HashMap();
				map.put("blood", bloods[(int)(Math.random()*4)]);
				map.put("religion", religions[(int)(Math.random()*5)]);
				map.put("birth", birth[(int)(Math.random()*4)]);
			template.insert(map, "research");
		}
		
		
	}
	
	@RequestMapping("/init2")
	public void initHandler2() {
		Map map = new HashMap<>();
		
		map.put("word","�ȳ��ϼ���");
		
			template.insert(map, "word");
		}
		
		
		
	
	
	
	
	
	
	
	@RequestMapping("/result")
	public ModelAndView Handler01(){
		
		ModelAndView mav = new ModelAndView();
		
		List<Map> list1 = mdao.find01("blood");
		
		List<Map> list2 = mdao.find01("religion");
		
		List<Map> list3 = mdao.find01("birth");
		
		mav.addObject("list1",list1);
		
		mav.addObject("list2",list2);
		
		mav.addObject("list3",list3);
		
		mav.setViewName("result2");
		
		return mav;
	}
	
	
	@RequestMapping("/religion")
	public ModelAndView Handler02(){
		
		ModelAndView mav = new ModelAndView();
		
		List<Map> list1 = mdao.find02("õ�ֱ�");
		
		List<Map> list2 = mdao.find02("�⵶��");
		
		List<Map> list3 = mdao.find02("�ұ�");
		
		List<Map> list4 = mdao.find02("��Ÿ��");
		
		List<Map> list5 = mdao.find02("����");
		
		mav.addObject("list1",list1);
		
		mav.addObject("list2",list2);
		
		mav.addObject("list3",list3);
		
		mav.addObject("list4",list4);
		
		mav.addObject("list5",list5);
		
		mav.setViewName("result3");
		
		return mav;
}
	
	
	
	@RequestMapping("/birth")
	public ModelAndView Handler03(){
		
		ModelAndView mav = new ModelAndView();
		
		List<Map> list1 = mdao.find03("��");
		
		List<Map> list2 = mdao.find03("����");
		
		List<Map> list3 = mdao.find03("����");
		
		List<Map> list4 = mdao.find03("�ܿ�");
		
		System.out.println(list1.toString());
		
		mav.addObject("list1",list1);
		
		
		mav.addObject("list2",list2);
		
		mav.addObject("list3",list3);
		
		mav.addObject("list4",list4);
		
		
		mav.setViewName("result4");
		
		return mav;
}
	
}



