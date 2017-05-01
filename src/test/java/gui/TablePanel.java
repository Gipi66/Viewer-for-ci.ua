package gui;

import javax.swing.JPanel;
import java.awt.GridLayout;
import java.awt.BorderLayout;
import javax.swing.JTable;
import java.awt.Color;

public class TablePanel extends JPanel {
	private JTable table;

	/**
	 * Create the panel.
	 */
	public TablePanel() {
		setLayout(new GridLayout(0, 1, 0, 0));

		JPanel panel = new JPanel();
		add(panel);
		panel.setLayout(new BorderLayout(0, 0));

		JPanel panel_3 = new JPanel();
		panel.add(panel_3, BorderLayout.CENTER);
		panel_3.setLayout(new GridLayout(0, 1, 0, 0));

		String[] name = { "Номер", "Текст" };

		Object[][] cells = { { "068-737-32-83", "Продам 2 к. в новостройке \"Подольский\", ул. Кузнечная. 81 м. Дом сдан, документы на руках. 750 за м2. Т. 068-737-32-83 [Премьер]" }, { "067-506-70-20, 050-42-51-169", "Продам свою 1 комн. квартиру в новострое на Алексеевке. Квартира с ремонтом. Без посредников. 067-506-70-20, 050-42-51-169 [Премьер]" } };

		table = new JTable(cells, name);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		table.setColumnSelectionAllowed(true);
		table.setCellSelectionEnabled(true);
		table.setFillsViewportHeight(true);

		panel_3.add(table);

		JPanel panel_2 = new JPanel();
		panel.add(panel_2, BorderLayout.SOUTH);

	}

}
