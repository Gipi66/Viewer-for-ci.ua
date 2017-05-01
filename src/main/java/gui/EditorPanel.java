package gui;

import javax.swing.JPanel;
import java.awt.BorderLayout;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFileChooser;

import java.awt.GridLayout;
import java.awt.Image;

import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.SystemColor;
import java.io.File;
import java.io.FileNotFoundException;
import java.net.URL;
import java.util.ArrayList;

import javax.swing.JScrollPane;
import javax.swing.SwingConstants;
import javax.swing.UIManager;

import editor.Advert;
import editor.Utils;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Color;
import javax.swing.border.TitledBorder;
import javax.swing.JFormattedTextField;
import javax.swing.JEditorPane;
import javax.swing.JTextPane;

public class EditorPanel extends JPanel {
	private JTextField filterField;
	private ArrayList<Advert> adverts = new ArrayList<Advert>();
	private JFileChooser fileopen;
	private File file;
	private JPanel advertsPanel;
	private Color ciColor = Color.decode("#6365ff");

	/**
	 * Create the panel.
	 */
	public EditorPanel() {
		setBackground(new Color(128, 128, 0));
		setLayout(new BorderLayout(0, 0));

		JPanel topPanel = new JPanel();
		topPanel.setBackground(new Color(99, 101, 255));
		add(topPanel, BorderLayout.NORTH);

		JLabel label = new JLabel("Фильтр");
		topPanel.add(label);

		filterField = new JTextField();
		topPanel.add(filterField);
		filterField.setColumns(10);

		JButton btnFilter = new JButton("Применить фильтр");
		btnFilter.setBackground(new Color(250, 250, 250));
		btnFilter.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				fillAdverts(filterByText(filterField.getText().toLowerCase()));
			}
		});
		topPanel.add(btnFilter);

		JPanel center = new JPanel();
		center.setBackground(new Color(0, 0, 255));
		add(center, BorderLayout.CENTER);
		center.setLayout(new GridLayout(0, 1, 0, 0));

		advertsPanel = new JPanel();
		advertsPanel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "\u0421\u043F\u0438\u0441\u043E\u043A \u043E\u0431\u0435\u043A\u0442\u043E\u0432", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0)));
		advertsPanel.setBackground(new Color(30, 144, 255));

		JScrollPane scrollPane = new JScrollPane(advertsPanel);
		advertsPanel.setLayout(new GridLayout(0, 1, 0, 0));
		center.add(scrollPane);

		JPanel botton = new JPanel();
		add(botton, BorderLayout.SOUTH);
		botton.setLayout(new GridLayout(0, 1, 0, 0));

		JPanel panel = new JPanel();
		botton.add(panel);
		panel.setLayout(new GridLayout(1, 0, 0, 0));

		JButton btnNewButton_2 = new JButton("Открыть файл");
		btnNewButton_2.setForeground(Color.BLACK);
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				openFile();
				fillAdverts(adverts);

			}
		});
		btnNewButton_2.setBackground(new Color(255, 173, 0));
		panel.add(btnNewButton_2);

		JPanel panel_1 = new JPanel();
		botton.add(panel_1);
		panel_1.setLayout(new GridLayout(0, 2, 0, 0));

		JButton btnNewButton = new JButton("Выход");
		btnNewButton.setBackground(new Color(255, 0, 0));
		panel_1.add(btnNewButton);

		JButton btnNewButton_1 = new JButton("Что-то еще");
		btnNewButton_1.setBackground(new Color(0, 128, 0));
		panel_1.add(btnNewButton_1);

	}
	public void openFile() {
		fileopen = new JFileChooser();
		int ret = fileopen.showDialog(null, "Открыть файл");
		if (ret == JFileChooser.APPROVE_OPTION) {
			createAdverts(fileopen.getSelectedFile().getAbsolutePath());
			/*
			 * Какие-то действия.
			 */
		}
	}

	public void createAdverts(String fileName) {
		try {
			Utils.read(fileName).forEach(i -> adverts.add(new Advert(i)));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void fillAdverts(ArrayList<Advert> advList) {
		advertsPanel.removeAll();
		for (Advert adv : advList) {
			JPanel advertPanel = new JPanel();
			advertPanel.setBackground(SystemColor.textHighlightText);
			advertPanel.setBorder(UIManager.getBorder("Spinner.border"));
			advertsPanel.add(advertPanel);
			advertPanel.setLayout(new BorderLayout(5, 5));

			JLabel lblPhones = new JLabel(String.join(", ", adv.getPhones()));
			lblPhones.setForeground(SystemColor.BLUE);
			lblPhones.setVerticalAlignment(SwingConstants.TOP);
			lblPhones.setHorizontalAlignment(SwingConstants.LEFT);
			lblPhones.setEnabled(true);
			advertPanel.add(lblPhones, BorderLayout.WEST);

			JLabel lblText = new JLabel(adv.getText());
			lblText.setHorizontalAlignment(SwingConstants.LEFT);
			lblText.setVerticalAlignment(SwingConstants.TOP);
			advertPanel.add(lblText, BorderLayout.CENTER);

		}
		advertsPanel.validate();
		advertsPanel.repaint();

	}

	public ArrayList<Advert> filterByText(String filterText) {
		ArrayList<Advert> filterAdverts = new ArrayList<Advert>(adverts);
		filterAdverts.removeIf(i -> !i.getText().toLowerCase().contains(filterText));
		return filterAdverts;
	}
}
