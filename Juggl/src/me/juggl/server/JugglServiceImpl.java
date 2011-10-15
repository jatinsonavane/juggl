package me.juggl.server;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;

import me.juggl.client.JugglService;
import me.juggl.shared.WorkStream;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import com.googlecode.objectify.Objectify;
import com.googlecode.objectify.ObjectifyService;

/**
 * The server side implementation of the RPC service.
 */
@SuppressWarnings("serial")
public class JugglServiceImpl extends RemoteServiceServlet implements
		JugglService {

	private Objectify ofy;

	@Override
	public void init() throws ServletException {
		// TODO untested code
		super.init();
		ObjectifyService.register(WorkStream.class);
		ofy = ObjectifyService.begin();
	}

	@Override
	public Long addWorkStream(WorkStream workStream) {
		ofy.put(workStream);
		return workStream.getId();
	}

	@Override
	public List<WorkStream> getWorkStreams() {
		List<WorkStream> workStreams = new ArrayList<WorkStream>();

		for (WorkStream workStream : ofy.query(WorkStream.class).fetch()) {
			workStreams.add(workStream);
		}

		return workStreams;
	}

	public void setObjectify(Objectify ofy) {
		this.ofy = ofy;
	}
}