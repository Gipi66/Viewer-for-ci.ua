package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Toolkit;
import java.awt.SystemColor;
import javax.swing.border.LineBorder;
import java.awt.Color;

public class EditorFrame extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EditorFrame frame = new EditorFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public EditorFrame() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Sergey\\Desktop\\Новая папка\\png\\24x24\\Wall.png"));
		setTitle("ЦентрИнформ. Просмотр ахивов объявлений.");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 400);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.activeCaption);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		EditorPanel mainPanel = new EditorPanel();
		mainPanel.setBorder(new LineBorder(new Color(0, 100, 0), 2));
		mainPanel.setBackground(SystemColor.textHighlight);
		contentPane.add(mainPanel);
	}

}
