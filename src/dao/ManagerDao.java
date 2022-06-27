package dao;

import java.io.IOException;
import java.lang.reflect.Type;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Map;

import com.google.gson.reflect.TypeToken;

//import beans.Customer;
import beans.Manager;

public class ManagerDao extends GenericDao<String, Manager, ManagerDao> {

	@Override
	protected String getKey(Manager entity) {
		return entity.getUsername();
	}

	@Override
	protected String getFilePath() {
		return "manager.json";
	}
	
	@Override
	public Map<String,Manager> getAllToMap(){
		String json = "";
		try {
			json = new String(Files.readAllBytes(Paths.get(getPath())));
		} catch (IOException e) {
			e.printStackTrace();
		}

		Type empMapType = new TypeToken<Map<String, Manager>>() {
		}.getType();

		Map<String, Manager> map = gs.fromJson(json, empMapType);
		return map;
		
	}
	
	@Override
	public ArrayList<Manager> getAllToList() {
		return new ArrayList<Manager>(getAllToMap().values());
	}

}

