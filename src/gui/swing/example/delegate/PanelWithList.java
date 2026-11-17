package gui.swing.example.delegate;

import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JPanel;

/**
 * Eine sehr einfache Klasse für ein Panel mit einer JList (eine Liste aus Strings).<br>
 * 
 * Die Klasse besitzt einen Delegate, an den nach dem Klicken eines Listeneintrags<br>
 * weiter deligiert wird.
 */
public class PanelWithList extends JPanel {
	
	private ArrayList<String> listData;
	private JList<String> list;
	
	private ListItemDelegate itemDelegate;
	public void setItemDelegate(ListItemDelegate itemDelegate) {
		this.itemDelegate = itemDelegate;
	}

	public PanelWithList() {
		super();	
		setLayout(new GridLayout(0, 1));
		DefaultListModel<String> model = createListModel();
		list = new JList<String>(model);
		add(list);
		
		list.addListSelectionListener(_-> itemDelegate.showItem(list.getSelectedValue()));
		list.setAutoscrolls(true);
	}

	private DefaultListModel<String> createListModel() {
		DefaultListModel<String> model = new DefaultListModel<String>();
		listData = new ArrayList<String>();
		listData.add("Irgendwas");
		listData.add("Noch irgendwas");
		model.addAll(listData);
		return model;
	}

	public void addToList(String data) {		
		DefaultListModel<String> model = (DefaultListModel<String>) list.getModel();
		model.addElement(data);
		list.setSelectedIndex(model.getSize() - 1);
	}
}
