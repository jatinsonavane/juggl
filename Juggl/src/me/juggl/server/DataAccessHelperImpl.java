package me.juggl.server;

import java.util.ArrayList;
import java.util.List;

import me.juggl.shared.WorkStream;

import com.googlecode.objectify.Objectify;
import com.googlecode.objectify.ObjectifyService;

public class DataAccessHelperImpl implements DataAccessHelper {

	private static DataAccessHelperImpl instance = new DataAccessHelperImpl();

	private Objectify ofy;

	private DataAccessHelperImpl() {
		// untested!
		ObjectifyService.register(WorkStream.class);
		ofy = ObjectifyService.begin();
	}

	public static DataAccessHelperImpl getInstance() {
		return instance;
	}

	/*
	 * Only used for testing
	 */
	public Objectify getOfy() {
		return ofy;
	}

	/*
	 * Only used for testing
	 */
	public void setOfy(Objectify ofy) {
		this.ofy = ofy;
	}

	@Override
	public List<WorkStream> getAllWorkStreams() {
		List<WorkStream> workStreams = new ArrayList<WorkStream>();

		for (WorkStream workStream : ofy.query(WorkStream.class).fetch()) {
			workStreams.add(workStream);
		}

		return workStreams;
	}

	@Override
	public long addWorkStream(WorkStream workStream) {
		ofy.put(workStream);
		return workStream.getId();
	}

}
