package model;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Order;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

@Service
public class InfosMongoDao {
	@Autowired
	MongoTemplate template;
	
	public void findSome01() {
		Criteria c = Criteria.where("age").gt(70);
		Query q = new Query(c); 
		System.out.println(q.toString());
		long t = template.count(q, "infos");
		System.out.println(t);
	}

	public void findSome02() {
		Criteria c = Criteria.where("age").gt(70);
		Criteria c2 = Criteria.where("taste").is("����");
		Query q = new Query();
			q.addCriteria(c);
			q.addCriteria(c2);
		System.out.println(q.toString());
		long t = template.count(q, "infos");
		System.out.println(t);
		
		Criteria cc = Criteria.where("age").gt(70).and("taste").is("����");
		Query qq = new Query(cc);
		System.out.println(qq.toString());
		long tt = template.count(qq,"infos");
		System.out.println(tt);
	}
	
	
	
	public void insertOne(Map map) {
		template.insert(map, "infos");
	}
	
	//=============================================================
	public List findAll() {
		Query query = new Query();
			Criteria c1 = new Criteria("gender");
				c1.is("male");
			Criteria c2 = new Criteria("taste");
				String[] ar = {"����"};
				// c2.in("����","����","�ߵ�");
				c2.in(ar);
			query.addCriteria(c1);
			query.addCriteria(c2);
		List li = template.find(query , Map.class, "infos");	// ����,, ���� ��ü
		System.out.println(li.size());
		return li;
	}

	public void findSome03(){
		Criteria c1 = Criteria.where("taste").is("����");
		
		String[] ar = {"����","���","��õ"};
		Criteria c2 = Criteria.where("area").in(ar);
		
		Criteria c3 = Criteria.where("age").gte(30).andOperator(Criteria.where("age").lt(90));
		
		Query query = new Query();
		
		
		query.addCriteria(c1);
		query.addCriteria(c2);
		query.addCriteria(c3);
		
		
		System.out.println(query);
		long t = template.count(query, "infos");
		
		System.out.println(t +"�� �߰�");
		
		
	}
	
	
	public void findSome04(){
		Criteria c =  new Criteria().orOperator(
				Criteria.where("age").gte(30).lt(40),
				Criteria.where("age").gte(40).lt(50)
					);
		
		Query query = new Query();
		
		query.addCriteria(c);
		
				
		System.out.println(query);
		
		long t = template.count(query, "infos");
		
		System.out.println(t +"�� �߰�");
		
	}

	public void sortSome01(){
		
		Query q = new Query(); 	
		// ������ Criteria ��  
		// find �� sort�� ���ϰŸ�. Query�� with�� ����
	Sort s =
			new Sort("age", "taste");// �⺻�� �������� .. �ΰ��� ���ʴ�� ���� ����
	// 	new Sort(Sort.Direction.ASC, "age", "taste");
	Sort ss= new Sort(Sort.Direction.DESC, "area"); 
	
	// ����. ���̼� ����, area �� �ø�..  �˾Ƽ� �˷��޶�.
	new Order(Sort.Direction.ASC, "taste");
	new Order(Sort.Direction.DESC, "age");
	
	q.with(ss);
	q.with(s);
	
	
	System.out.println(q.toString());
	List<Map> li =template.find(q, Map.class, "infos");
	for(int i=0; i<10; i++) {
		Map map = li.get(i);
		System.out.println(map.toString());
	}
		
	}
}


