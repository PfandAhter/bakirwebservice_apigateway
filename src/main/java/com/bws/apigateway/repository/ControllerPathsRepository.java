package com.bws.apigateway.repository;

import com.bws.apigateway.model.entity.ControllerPaths;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ControllerPathsRepository extends JpaRepository<ControllerPaths,Integer> {

    @Query("select c from ControllerPaths c where ((?1 = 'all' and c.parentId is null) or c.pathName = ?1) and c.status = '1' ")
    List<ControllerPaths> findControllerPathsByCriteria(String pathName);

}
