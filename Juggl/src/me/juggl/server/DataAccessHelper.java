package me.juggl.server;

import java.util.List;

import me.juggl.shared.WorkStream;

public interface DataAccessHelper {

	List<WorkStream> getAllWorkStreams();

	long addWorkStream(WorkStream workStream);

}