package Controller.jackson;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import Model.Dao;

@Controller
@RequestMapping("/data")
public class ResponseBodyController {
	@Autowired
	Dao rdao;
	
	@RequestMapping("/exam05")
	@ResponseBody
	public List<Map> example05() {
		List li = rdao.readAll();
		return li;
	}
	
	
	@RequestMapping(path="/exam06", produces="application/json;charset=utf-8")	
	@ResponseBody
	public String example06() {	
		// String�� ��������, �ѱ��� ������ �������� �ִ�. 
		// �׷����� ..�ذ� ����� ���� ����
		
		return "����";
	}
	
	
	@RequestMapping("/exam01")
	@ResponseBody
	public boolean example01() {	
		// boolean�� return�� �Ǵ°� Object�� String ���� ��ȯ���ִ� 
		// Jackson Databind library�� �־.. (?? ������ ���ص� �갡 Ȱ��ȭ �Ǵ°�.. <mvc:annotation-driven/> 
		return true;
	}
	
	@RequestMapping("/exam02")
	@ResponseBody
	public String[] example02() {	
		String[] ar = new String[]{"����", "zoro", "nami", "sanji", "usop"};
		
		return ar;
	}
	
	@RequestMapping(path="/exam02v", produces="application/json;charset=utf-8")
	@ResponseBody
	public String example02v() throws JsonProcessingException {	
		String[] ar = new String[]{"����", "zoro", "nami", "sanji", "usop"};
		ObjectMapper om = new ObjectMapper();
		return om.writeValueAsString(ar);
	}
	
	@RequestMapping("/exam03")
	@ResponseBody
	public Map example03() {	
		Map map = new LinkedHashMap();
			map.put("id", "saan");
			map.put("pass", "oralce");
			map.put("age", 19);
			map.put("admin", true);
			map.put("role", new String[]{"connect", "resource"} );
			System.out.println(map.toString());
		return map;
	}
	
	@RequestMapping("/exam04")
	@ResponseBody
	public List example04() {
		List li = new ArrayList();
			li.add("monday");
			li.add("friday");
			li.add("saturday");
			li.add("saturday");
			li.add("saturday");
			li.add("sunday");
			li.add("sunday");
		return li;
	}
	
	
}






