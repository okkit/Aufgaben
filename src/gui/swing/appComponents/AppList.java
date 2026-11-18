package gui.swing.appComponents;

import javax.swing.DefaultListModel;
import javax.swing.JList;

import data.objekte.AObject;

public class AppList<T extends AObject> extends JList<AObject>{

	public AppList(DefaultListModel<AObject> model) {
		super(model);
	}

}
