package com.epam.training.ticketservice.core.screening.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.epam.training.ticketservice.core.screening.persistence.entity.Screening;

public interface ScreeningRepository extends JpaRepository<Screening,Integer> {

	Screening findByMovieTitle(String title);

	Screening deleteByMovieTitle(String title);

}
