package com.s284746.web.faces.event;

import javax.faces.event.*;

import com.s284746.web.faces.util.SQLProcessor;

/**
 * todo comment
 */
public class DataDeleter implements ActionListener {
	public static int userid = 0;

	@Override
	public void processAction(ActionEvent actionEvent) throws AbortProcessingException {
		try {
			SQLProcessor.deleteData(userid);
		} catch (Exception exception) {
			exception.printStackTrace();
		}
	}
}
