package model;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Order;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.aggregation.AggregationOperation;
import org.springframework.data.mongodb.core.aggregation.AggregationResults;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;


@Service
public class InfosMongoDao2 {
	@Autowired
	MongoTemplate template;
	
	public void aggrTest() {
		
		AggregationOperation a1 = Aggregation.match(Criteria.where("age").gt(30));
		AggregationOperation a2 =
				Aggregation.group("area","taste").count().as("cnt").avg("age").as("avgage");
		AggregationOperation a3 = Aggregation.sort(Sort.Direction.DESC, "cnt");
		AggregationOperation a4 = Aggregation.limit(5);
		Aggregation aggr = Aggregation.newAggregation( a1, a2 , a3, a4);
		
		System.out.println(aggr.toString());
		AggregationResults<Map> results = template.aggregate(aggr,"infos", Map.class);
		//	System.out.println(results.toString());
		// 실제 요소들을 뽑아쓰려면.. list로 바꿔서 쓰거나. Iterator
		List<Map> list = results.getMappedResults();
		for(Map each : list) {
			System.out.println(each.toString());
		}
		
	}
	
	public List find01(String name){
		
	AggregationOperation a1 = Aggregation.group(name).count().as("cnt");
	
	AggregationOperation a2 = Aggregation.sort(Sort.Direction.DESC, "cnt");
	
	Aggregation aggr = Aggregation.newAggregation(a1,a2);
	
	AggregationResults<Map> results = template.aggregate(aggr, "research", Map.class);
	
	List<Map> list = results.getMappedResults();
	
	return list;
	
	
}
	
	public List find02(String name){
		
		AggregationOperation a1 = Aggregation.match(Criteria.where("religion").is(name));
		
		AggregationOperation a2 = Aggregation.group("blood").count().as("cnt");
		
		Aggregation aggr = Aggregation.newAggregation(a1,a2);
		
		AggregationResults<Map> results = template.aggregate(aggr, "research", Map.class);
		
		List<Map> list = results.getMappedResults();
		
		return list;
	}
	
	
	
public List find03(String name){
		
		AggregationOperation a1 = Aggregation.match(Criteria.where("birth").is(name));
		
		AggregationOperation a2 = Aggregation.group("religion").count().as("cnt");
		
		Aggregation aggr = Aggregation.newAggregation(a1,a2);
		
		AggregationResults<Map> results = template.aggregate(aggr, "research", Map.class);
		
		List<Map> list = results.getMappedResults();
		
		return list;
	}
	

public void insert(Map map){
		template.insert(map, "word");
	}


public List AllWord(){
	
	AggregationOperation a1 = Aggregation.group("word").count().as("cnt");
	
	AggregationOperation a2 = Aggregation.sort(Sort.Direction.DESC, "cnt");
	
	Aggregation aggr = Aggregation.newAggregation(a1,a2);
	
	AggregationResults<Map> results = template.aggregate(aggr, "word", Map.class);
	
	List<Map> list = results.getMappedResults();
	
	return list;
	
	}

public List findWord(String word){
	
	AggregationOperation a1 = Aggregation.group("word").count().as("cnt");
	
	AggregationOperation a2 = Aggregation.sort(Sort.Direction.DESC,"cnt");
	
	AggregationOperation a3 = Aggregation.match(Criteria.where("_id").is(word));
	
	Aggregation aggr = Aggregation.newAggregation(a1,a2,a3);
	
	AggregationResults<Map> results = template.aggregate(aggr, "word", Map.class);
	
	List<Map> list = results.getMappedResults();
	
	return list;
	
	}

public List AllWord4(String start){
	
	AggregationOperation a1 = Aggregation.group("word").count().as("cnt");
	
	AggregationOperation a2 = Aggregation.sort(Sort.Direction.DESC, "cnt");
	
	AggregationOperation a3 = Aggregation.limit(4);
	
	AggregationOperation a4 = Aggregation.match(Criteria.where("_id").regex("^"+start));
	
	Aggregation aggr = Aggregation.newAggregation(a1,a2,a3,a4);
	
	AggregationResults<Map> results = template.aggregate(aggr, "word", Map.class);
	
	List<Map> list = results.getMappedResults();
	
	return list;
	
	}
}

