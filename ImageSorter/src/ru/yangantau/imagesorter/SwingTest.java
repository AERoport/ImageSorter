package ru.yangantau.imagesorter;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Rectangle;
import javax.swing.JTree;
import java.awt.BorderLayout;
import javax.swing.JList;
import javax.swing.ListSelectionModel;
import java.awt.Component;
import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.ComponentOrientation;
import javax.swing.AbstractListModel;
import javax.swing.JTable;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import java.awt.FlowLayout;
import java.awt.Point;
import java.awt.Dimension;
import javax.swing.BoxLayout;
import java.awt.GridLayout;
import java.awt.CardLayout;
import java.awt.SystemColor;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import net.miginfocom.swing.MigLayout;

public class SwingTest {

	private JFrame frmAeroportImagesorter;
	private JTable table_EXIF;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SwingTest window = new SwingTest();
					window.frmAeroportImagesorter.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public SwingTest() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmAeroportImagesorter = new JFrame();
		frmAeroportImagesorter.setSize(new Dimension(500, 500));
		frmAeroportImagesorter.setMaximumSize(new Dimension(1000, 1000));
		frmAeroportImagesorter.setMinimumSize(new Dimension(500, 500));
		frmAeroportImagesorter.setBounds(new Rectangle(0, 0, 10, 10));
		frmAeroportImagesorter.setTitle("AERoport ImageSorter");
		frmAeroportImagesorter.setBounds(100, 100, 501, 501);
		frmAeroportImagesorter.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmAeroportImagesorter.getContentPane().setLayout(
				new BoxLayout(frmAeroportImagesorter.getContentPane(),
						BoxLayout.X_AXIS));

		JPanel panel_left = new JPanel();
		frmAeroportImagesorter.getContentPane().add(panel_left);
		panel_left.setLayout(null);

		JTree tree = new JTree();
		tree.setBounds(0, 0, 147, 340);
		panel_left.add(tree);

		JPanel panel_middle = new JPanel();
		frmAeroportImagesorter.getContentPane().add(panel_middle);

		JComboBox comboBox = new JComboBox();
		comboBox.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		comboBox.setToolTipText("111111111");
		comboBox.setName("");
		comboBox.setMaximumRowCount(10);
				panel_middle.setLayout(new BoxLayout(panel_middle, BoxLayout.X_AXIS));
		
				JList list = new JList();
				list.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
				panel_middle.add(list);
				list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		panel_middle.add(comboBox);
		
				JPanel panel_right = new JPanel();
				frmAeroportImagesorter.getContentPane().add(panel_right);
				panel_right.setLayout(null);
				
						table_EXIF = new JTable();
						table_EXIF.setBounds(25, 61, 106, 224);
						panel_right.add(table_EXIF);
	}

}
