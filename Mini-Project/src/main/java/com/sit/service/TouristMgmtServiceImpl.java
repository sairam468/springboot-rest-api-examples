package com.sit.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sit.entity.Tourist;
import com.sit.exception.TouristNotFoundException;
import com.sit.repo.ITouristRepo;

@Service("touristService")
public class TouristMgmtServiceImpl implements ITouristMgmtService{

	@Autowired
	private ITouristRepo repo;
	
	@Override
	public String registerTourist(Tourist tourist) {
		int idVal=repo.save(tourist).getTid();
		return "Tourist is registered having id values :: "+idVal;
	}

	@Override
	public List<Tourist> fetchAll() {
		List<Tourist> all = repo.findAll();
		return all.stream().sorted((t1,t2)->t1.getTid()<t2.getTid()?1:-1).toList();
	}

	@Override
	public List<Tourist> showAllTourist(String city1, String city2, String city3) {
		return repo.showAllTourist(city1, city2, city3);
	}

	@Override
	public Tourist fetchById(Integer tid) throws TouristNotFoundException {
		
		return repo.findById(tid)
				.orElseThrow(()->new TouristNotFoundException(tid+" tid not found"));
	}

	@Override
	public String updateTourist(Tourist t) throws TouristNotFoundException {
		Optional<Tourist> byId = repo.findById(t.getTid());
		if(byId.isPresent()) {
			repo.save(t);
			return t.getTid()+" Tourist Updated";
		}
		else {
			throw new TouristNotFoundException(t.getTid()+" Tourist not Found");
		}
	}

	@Override
	public List<Tourist> showTouristByName(String name) {
		
		return repo.getTouristByName(name);
	}

	@Override
	public String updateTouristById(Integer tid, Double hikePercentage) throws TouristNotFoundException {
		Optional<Tourist> byId = repo.findById(tid);
		if(byId.isPresent()) {
			Tourist tourist = byId.get();
			double budget=tourist.getBudget();
			double newBudget=budget+(budget*hikePercentage/100.0);
			tourist.setBudget(newBudget);
			repo.save(tourist);
			return " Tourist Budget hiked... new Budget : "+newBudget;
		}
		else {
			throw new TouristNotFoundException(tid+" Tourist not Found");
		}
	}

	@Override
	public String removeTouristById(Integer tid) throws TouristNotFoundException {
		Optional<Tourist> byId = repo.findById(tid);
		if(byId.isPresent()) {
			
			repo.deleteById(tid);;
			return tid+" Tourist Deleted";
		}
		else {
			throw new TouristNotFoundException(tid+"Tourist not Found for Deletion");
		}
	}

	@Override
	public String removeTouristByBudgetRange(Double start, Double end) throws TouristNotFoundException {
		int count=repo.removeTouristByBudgetRange(start, end);
		return count==0?"Tourists not found for deletion ":count +" number of Tourists are dound and deleted";
	}
		

}
