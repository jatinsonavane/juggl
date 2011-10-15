package me.juggl.client;

import java.util.List;

import me.juggl.shared.WorkStream;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.KeyCodes;
import com.google.gwt.event.dom.client.KeyUpEvent;
import com.google.gwt.event.dom.client.KeyUpHandler;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.HTMLTable;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.TextBox;

public class JugglClient implements EntryPoint {

	private final JugglServiceAsync jugglService = GWT
			.create(JugglService.class);
	private final String ENTER_NEW_WORKSTREAM = "Enter new workstream";

	@Override
	public void onModuleLoad() {
		final TextBox workStreamNameField = new TextBox();
		workStreamNameField.setText(ENTER_NEW_WORKSTREAM);
		final Button addWorkStreamButton = new Button("Add");

		// This class needs to be local to this function because
		// it accesses some of the local widgets.
		class AddWorkStreamHandler implements ClickHandler, KeyUpHandler {

			@Override
			public void onKeyUp(KeyUpEvent event) {
				if (event.getNativeKeyCode() == KeyCodes.KEY_ENTER) {
					addWorkStream();
				}
			}

			@Override
			public void onClick(ClickEvent event) {
				if (event.getSource().equals(workStreamNameField))
					workStreamNameField.selectAll();
				else if (event.getSource().equals(addWorkStreamButton))
					addWorkStream();
			}

			private void addWorkStream() {
				String name = workStreamNameField.getText();
				WorkStream workStream = new WorkStream();
				workStream.setName(name);

				addWorkStreamButton.setEnabled(false);

				jugglService.addWorkStream(workStream,
						new AsyncCallback<Long>() {

							@Override
							public void onFailure(Throwable caught) {
								System.out
										.println("bah! failure in jugglService.addWorkStream()");
								addWorkStreamButton.setEnabled(true);
								workStreamNameField
										.setText(ENTER_NEW_WORKSTREAM);
								workStreamNameField.selectAll();
							}

							@Override
							public void onSuccess(Long result) {
								System.out
										.println("so this finally worked. id: "
												+ result);
								workStreamNameField
										.setText(ENTER_NEW_WORKSTREAM);
								workStreamNameField.selectAll();
								addWorkStreamButton.setEnabled(true);
								refreshWorkStreams();
							}

						});
			}
		}

		AddWorkStreamHandler addWorkStreamHandler = new AddWorkStreamHandler();
		workStreamNameField.addKeyUpHandler(addWorkStreamHandler);
		workStreamNameField.addClickHandler(addWorkStreamHandler);
		addWorkStreamButton.addClickHandler(addWorkStreamHandler);

		RootPanel.get("workStreamNameContainer").add(workStreamNameField);
		RootPanel.get("addWorkStreamButtonContainer").add(addWorkStreamButton);

		refreshWorkStreams();
	}

	private void refreshWorkStreams() {

		jugglService.getWorkStreams(new AsyncCallback<List<WorkStream>>() {

			@Override
			public void onFailure(Throwable caught) {
				System.out.println("couldn't refresh workstreams");
			}

			@Override
			public void onSuccess(List<WorkStream> result) {

				System.out.println("refreshed workstreams - got "
						+ result.size());

				HTMLTable table = new FlexTable();
				int row = 0;

				for (WorkStream workStream : result) {
					TextBox textBox = new TextBox();
					textBox.setText(workStream.getName());
					textBox.setEnabled(false);

					table.setWidget(row++, 0, textBox);
				}

				RootPanel.get("workStreamListContainer").clear();
				RootPanel.get("workStreamListContainer").add(table);
			}
		});
	}
}
