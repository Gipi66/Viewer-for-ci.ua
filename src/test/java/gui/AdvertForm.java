package gui;

import javax.swing.JPanel;
import java.awt.GridLayout;
import javax.swing.JSplitPane;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.FlowLayout;

public class AdvertForm extends JPanel {
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;

	/**
	 * Create the panel.
	 */
	public AdvertForm() {
		setLayout(new GridLayout(0, 1, 0, 0));
		
		JPanel panel = new JPanel();
		add(panel);
		panel.setLayout(new GridLayout(0, 1, 0, 0));
		
		JPanel panel_3 = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panel_3.getLayout();
		flowLayout.setAlignment(FlowLayout.LEFT);
		panel.add(panel_3);
		
		JSplitPane splitPane = new JSplitPane();
		panel_3.add(splitPane);
		
		JPanel panel_1 = new JPanel();
		splitPane.setLeftComponent(panel_1);
		
		JButton btnNewButton = new JButton("New button");
		panel_1.add(btnNewButton);
		
		JPanel panel_2 = new JPanel();
		splitPane.setRightComponent(panel_2);
		FlowLayout fl_panel_2 = new FlowLayout(FlowLayout.LEFT, 5, 5);
		panel_2.setLayout(fl_panel_2);
		
		textField = new JTextField();
		panel_2.add(textField);
		textField.setColumns(10);
		
		JSplitPane splitPane_1 = new JSplitPane();
		panel_3.add(splitPane_1);
		
		JPanel panel_4 = new JPanel();
		splitPane_1.setLeftComponent(panel_4);
		
		JButton button = new JButton("New button");
		panel_4.add(button);
		
		JPanel panel_5 = new JPanel();
		splitPane_1.setRightComponent(panel_5);
		panel_5.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		panel_5.add(textField_1);
		
		JSplitPane splitPane_2 = new JSplitPane();
		panel_3.add(splitPane_2);
		
		JPanel panel_6 = new JPanel();
		splitPane_2.setLeftComponent(panel_6);
		
		JButton button_1 = new JButton("New button");
		panel_6.add(button_1);
		
		JPanel panel_7 = new JPanel();
		splitPane_2.setRightComponent(panel_7);
		panel_7.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		panel_7.add(textField_2);

	}

}
