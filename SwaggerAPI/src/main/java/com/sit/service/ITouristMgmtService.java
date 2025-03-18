package com.sit.service;

import java.util.List;

import com.sit.entity.Tourist;
import com.sit.exception.TouristNotFoundException;

public interface ITouristMgmtService {

	public String registerTourist(Tourist tourist);
	
	public List<Tourist> fetchAll();
	
	public List<Tourist> showAllTourist(String city1,String city2,String city3);
	
	public Tourist fetchById(Integer tid)throws TouristNotFoundException;
	
	public String updateTourist(Tourist t) throws TouristNotFoundException;
	
	public String updateTouristById(Integer tid,Double hikePercentage) throws TouristNotFoundException;
	
	public List<Tourist> showTouristByName(String name);
	
	public String removeTouristById(Integer tid) throws TouristNotFoundException;
	
	public String removeTouristByBudgetRange(Double start,Double end) throws TouristNotFoundException;
	
}
