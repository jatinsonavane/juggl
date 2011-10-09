package me.juggl.client;

import java.util.List;

import me.juggl.shared.WorkStream;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

/**
 * The client side stub for the RPC service.
 */
@RemoteServiceRelativePath("jugglservice")
public interface JugglService extends RemoteService {

	long addWorkStream(WorkStream workStream);
	
	WorkStream getWorkStream(long id);
	
	List<WorkStream> getWorkStreams();
}
