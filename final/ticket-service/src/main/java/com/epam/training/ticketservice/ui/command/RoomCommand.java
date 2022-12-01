package com.epam.training.ticketservice.ui.command;

import java.util.Objects;

import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellMethodAvailability;

import com.epam.training.ticketservice.core.movie.MovieService;
import com.epam.training.ticketservice.core.movie.model.MovieDto;
import com.epam.training.ticketservice.core.room.RoomService;
import com.epam.training.ticketservice.core.room.model.RoomDto;
import com.epam.training.ticketservice.core.user.UserService;

import lombok.AllArgsConstructor;

@ShellComponent
@AllArgsConstructor
public class RoomCommand {

	private final RoomService roomService;

	@ShellMethodAvailability("isAvailable")
	@ShellMethod(key = "create room ", value = "create new room.")
	public RoomDto createRoom(String name, int rowCount, int columnCount) {
		if (name == null || rowCount < 1 || columnCount < 1) {
			throw new IllegalArgumentException(
					"You should add 3 arguments: room name, row count and column count (should be larger than 0)");
		}
		RoomDto roomDto = RoomDto.builder()
				.withName(name)
				.withRowCount(rowCount)
				.withColumnCount(columnCount)
				.build();
		roomService.createRoom(roomDto);
		return roomDto;
	}

	@ShellMethodAvailability("isAvailable")
	@ShellMethod(key = "update room ", value = "Update existing room.")
	public RoomDto updateRoom(String name, int rowCount, int columnCount) {
		if (name == null || rowCount < 1 || columnCount < 1) {
			throw new IllegalArgumentException(
					"You should add 3 arguments: room name, row count and column count (should be larger than 0)");
		}

		RoomDto roomDto = RoomDto.builder()
				.withName(name)
				.withRowCount(rowCount)
				.withColumnCount(columnCount)
				.build();
		roomService.updateRoom(roomDto);
		return roomDto;
	}

	@ShellMethodAvailability("isAvailable")
	@ShellMethod(key = "delete room ", value = "Delete existing room.")
	public RoomDto deleteRoom(String name) {
		Objects.requireNonNull(name, "Room name should not be empty!");
		return roomService.deleteRoom(name);

	}

	@ShellMethod(key = "list rooms", value = "List the available rooms")
	public String listMovies() {
		if (roomService.getRoomList().isEmpty()) {
			return "There are no rooms at the moment!";
		}
		StringBuilder result = new StringBuilder();
		roomService.getRoomList().forEach(roomDto -> result.append(roomDto).append("\n"));
		return result.toString();
	}
}
