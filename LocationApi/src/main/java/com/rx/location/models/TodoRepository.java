package com.rx.location.models;

import org.springframework.data.repository.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
//import org.springframework.data.repository.*;

public interface TodoRepository extends Repository<Location, Long> {

	/*
	 * @Query(
	 * value="SELECT top 1 name   FROM LOCATION where SQRT(POWER(69.1 * (latitude - :latitudein), 2) +POWER(69.1 * (:longitudein - longitude) * COS(latitude / 57.3), 2))  <28;\r\n"
	 * ,nativeQuery=true)
	 */
	
	@Query(value="SELECT  top 1 name,address, SQRT(POWER(69.1 * (latitude - :latitudein), 2) +POWER(69.1 * (:longitudein- longitude) * COS(latitude / 57.3), 2)) as Distance  FROM LOCATION order by Distance ASC"
	,nativeQuery=true)
    String findBySearchTerm(double latitudein,double longitudein);

}
