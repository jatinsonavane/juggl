package me.juggl.server;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import me.juggl.client.JugglService;
import me.juggl.shared.WorkStream;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;

/**
 * The server side implementation of the RPC service.
 */
@SuppressWarnings("serial")
public class JugglServiceImpl extends RemoteServiceServlet implements JugglService {

	private Map<Long, WorkStream> workStreamMap = new HashMap<Long, WorkStream>();
	private long counter = 0; // only written to pass a test. This should be forced out by persistence related tests
	
	@Override
	public long addWorkStream(WorkStream workStream) {
		counter++; // already not thread-safe
		workStreamMap.put(Long.valueOf(counter), workStream);
		return counter;
	}

	@Override
	public WorkStream getWorkStream(long id) {
		return workStreamMap.get(id);
	}

	@Override
	public List<WorkStream> getWorkStreams() {
		List<WorkStream> workStreams = new ArrayList<WorkStream>();
		
		for (WorkStream workStream : workStreamMap.values()) {
			workStreams.add(workStream);
		}
		
		return workStreams;
	}

}
