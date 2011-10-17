package me.juggl.server;

import java.util.List;

import me.juggl.client.JugglService;
import me.juggl.shared.WorkStream;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;

/**
 * The server side implementation of the RPC service.
 */
@SuppressWarnings("serial")
public class JugglServiceImpl extends RemoteServiceServlet implements JugglService {

	private DataAccessHelper helper = DataAccessHelperImpl.getInstance();

	@Override
	public Long addWorkStream(WorkStream workStream) {
		helper.addWorkStream(workStream);
		return workStream.getId();
	}

	@Override
	public List<WorkStream> getWorkStreams() {
		return helper.getAllWorkStreams();
	}

	/*
	 * only used by junit tests
	 */
	public void setDataAccessHelper(DataAccessHelper helper) {
		this.helper = helper;
	}

	public DataAccessHelper getDataAccessHelper() {
		return helper;
	}
}