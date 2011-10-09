package me.juggl.client;

import java.util.List;

import me.juggl.shared.WorkStream;

import com.google.gwt.user.client.rpc.AsyncCallback;


/**
 * The async counterpart of <code>GreetingService</code>.
 */
public interface JugglServiceAsync {
	
	void addWorkStream(WorkStream workStream, AsyncCallback<Long> callback) throws IllegalArgumentException;
	
	void getWorkStream(long id, AsyncCallback<WorkStream> callback) throws IllegalArgumentException;
	
	void getWorkStreams(AsyncCallback<List<WorkStream>> callback);
}
