package ru.yangantau.imagesorter;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Rectangle;
import javax.swing.JTree;
import java.awt.BorderLayout;

public class SwingTest {

	private JFrame frmAeroportImagesorter;

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
		frmAeroportImagesorter.setBounds(new Rectangle(0, 0, 10, 10));
		frmAeroportImagesorter.setTitle("AERoport ImageSorter");
		frmAeroportImagesorter.setBounds(100, 100, 496, 501);
		frmAeroportImagesorter.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JTree tree = new JTree();
		frmAeroportImagesorter.getContentPane().add(tree, BorderLayout.WEST);
	}

}
