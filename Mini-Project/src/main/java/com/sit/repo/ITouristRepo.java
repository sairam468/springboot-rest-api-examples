package com.sit.repo;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import com.sit.entity.Tourist;

import jakarta.transaction.Transactional;

public interface ITouristRepo extends JpaRepository<Tourist, Integer> {

    @Query("SELECT t FROM Tourist t WHERE t.city IN (:city1, :city2, :city3) ORDER BY t.name ASC")
    List<Tourist> showAllTourist(@Param("city1") String city1, 
                                 @Param("city2") String city2, 
                                 @Param("city3") String city3);
    
    @Query("SELECT t FROM Tourist t WHERE t.name = :name")
    public List<Tourist> getTouristByName(@Param("name")String name);
    
    @Modifying
    @Transactional
    @Query("DELETE FROM Tourist t WHERE t.budget BETWEEN :start AND :end")
    int removeTouristByBudgetRange(@Param("start") Double start, @Param("end") Double end);
    
}
