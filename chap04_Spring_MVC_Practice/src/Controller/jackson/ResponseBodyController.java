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
		// String만 날리더라도, 한글을 보내고 싶을때가 있다. 
		// 그럴때는 ..해결 방법은 수동 설정
		
		return "성공";
	}
	
	
	@RequestMapping("/exam01")
	@ResponseBody
	public boolean example01() {	
		// boolean이 return이 되는건 Object→ String 으로 변환해주는 
		// Jackson Databind library가 있어서.. (?? 빈등록을 안해도 얘가 활성화 되는건.. <mvc:annotation-driven/> 
		return true;
	}
	
	@RequestMapping("/exam02")
	@ResponseBody
	public String[] example02() {	
		String[] ar = new String[]{"루피", "zoro", "nami", "sanji", "usop"};
		
		return ar;
	}
	
	@RequestMapping(path="/exam02v", produces="application/json;charset=utf-8")
	@ResponseBody
	public String example02v() throws JsonProcessingException {	
		String[] ar = new String[]{"루피", "zoro", "nami", "sanji", "usop"};
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






