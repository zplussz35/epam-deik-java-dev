package com.epam.training.ticketservice.core.room.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.epam.training.ticketservice.core.room.persistence.entity.Room;

public interface RoomRepository extends JpaRepository<Room, Integer> {


	Room findByName(String name);

	Room deleteByName(String name);
}
