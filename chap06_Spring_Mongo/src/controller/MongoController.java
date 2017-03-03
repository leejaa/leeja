package controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import model.InfosMongoDao;

@Controller
@RequestMapping("/mongo")
public class MongoController {
	@Autowired
	InfosMongoDao mdao;
	
	@RequestMapping("/insert01")
	public String insert01Hanler(@RequestParam Map map, @RequestParam("age") int age) {
		map.put("age", age);
		mdao.insertOne(map);
		return null;
	}
	@RequestMapping("/find01")
	public String find01Handler() {
		List li =mdao.findAll();
			Map map =(Map)li.get(0);
			System.out.println(map);
			System.out.println(map.get("_id"));
			System.out.println(map.get("gender"));
			System.out.println(map.get("age"));
		return null;
	}
}
