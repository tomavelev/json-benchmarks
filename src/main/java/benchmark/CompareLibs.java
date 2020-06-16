package benchmark;

import static net.minidev.json.parser.JSONParser.ACCEPT_TAILLING_SPACE;
import static net.minidev.json.parser.JSONParser.USE_HI_PRECISION_FLOAT;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import javax.json.Json;
import javax.json.JsonObject;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.reflect.TypeToken;

import net.minidev.json.JSONArray;
import net.minidev.json.JSONObject;

public class CompareLibs {

	public static void main(String[] args) throws Exception {
		Type listType = new TypeToken<List<Dummy>>() {
		}.getType();
		List<Dummy> list = new ArrayList<Dummy>();

		for (int i = 0; i < 1000; i++) {
			list.add(new Dummy(i, i + "dummy"));
		}

		long before = System.currentTimeMillis();
		String json = new Gson().toJson(list);
		long diff = System.currentTimeMillis() - before;
		System.out.println("gson toString " + diff);

		before = System.currentTimeMillis();
		List<Dummy> fromJson = new Gson().fromJson(json, listType);
		diff = System.currentTimeMillis() - before;
		System.out.println("gson fromString " + diff);

		final ObjectMapper mapper = new ObjectMapper();

		before = System.currentTimeMillis();
		json = mapper.writeValueAsString(list);
		diff = System.currentTimeMillis() - before;
		System.out.println("jackson toString " + diff);

		before = System.currentTimeMillis();
		fromJson = mapper.readValue(json, mapper.getTypeFactory().constructCollectionType(List.class, Dummy.class));
		diff = System.currentTimeMillis() - before;
		System.out.println("jackson fromString " + diff);

		before = System.currentTimeMillis();
		json = JSONArray.toJSONString(list);
		diff = System.currentTimeMillis() - before;
		System.out.println("smart toString " + diff);

		before = System.currentTimeMillis();
		fromJson = (List<Dummy>) new net.minidev.json.parser.JSONParser(USE_HI_PRECISION_FLOAT | ACCEPT_TAILLING_SPACE)
				.parse(json);
		diff = System.currentTimeMillis() - before;
		System.out.println("smart fromString " + diff);
		
		
		
		
		
		
		
//		 JsonObject object = Json.createArrayBuilder().addcreateObjectBuilder().build();

		before = System.currentTimeMillis();
		json = object.t
		diff = System.currentTimeMillis() - before;
		System.out.println("j2ee json toString " + diff);

		before = System.currentTimeMillis();
		fromJson = (List<Dummy>) new net.minidev.json.parser.JSONParser(USE_HI_PRECISION_FLOAT | ACCEPT_TAILLING_SPACE)
				.parse(json);
		diff = System.currentTimeMillis() - before;
		System.out.println("j2ee json fromString " + diff);

	}

	

}
//gson toString 156
//gson fromString 47
//jackson toString 94
//jackson fromString 75
//v1.3.1
//smart toString 48
//smart fromString 23

//gson toString 156
//gson fromString 30
//jackson toString 79
//jackson fromString 55
//2.3
//smart toString 64
//smart fromString 16
