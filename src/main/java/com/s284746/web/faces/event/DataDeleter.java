package com.s284746.web.faces.event;

import javax.faces.event.*;

import com.s284746.web.faces.util.SQLProcessor;

/**
 * Class for performing data deletion when 'Clear' button is pressed
 */
public class DataDeleter implements ActionListener {
	public static int userid = 0;

	/**
	 * Catches a click and invokes process
	 * @param actionEvent click event as object
	 * @throws AbortProcessingException if something is wrong
	 */
	@Override
	public void processAction(ActionEvent actionEvent) throws AbortProcessingException {
		try {
			SQLProcessor.deleteData(userid);
		} catch (Exception exception) {
			exception.printStackTrace();
		}
	}
}
