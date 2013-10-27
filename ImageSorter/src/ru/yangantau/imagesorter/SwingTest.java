package ru.yangantau.imagesorter;

import java.awt.BorderLayout;
import java.awt.ComponentOrientation;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.util.ArrayList;

import javax.swing.AbstractListModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JTree;
import javax.swing.ListModel;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;

import com.drew.metadata.exif.ExifSubIFDDirectory;
import javax.swing.ListSelectionModel;
import java.awt.FlowLayout;
import javax.swing.BoxLayout;
import java.awt.Component;
import java.awt.Rectangle;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JCheckBox;

public class SwingTest {

	private JFrame frmAeroportImagesorter;
	private JTextField textFieldData;
	private JTextField textFieldSource;
	private JTextField textFieldDest;

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
	 * 
	 * @throws ClassNotFoundException
	 */
	public SwingTest() {
		initialize();
	}

	// /
	static final String[] TAG_TYPES_SERIES = { "ExifSubIFDDirectory",
			"ExifIFD0Directory", "ExifInteropDirectory",
			"ExifThumbnailDirectory", "JpegDirectory", "JpegCommentDirectory",
			"JfifDirectory", "BmpHeaderDirectory", "GifHeaderDirectory",
			"GpsDirectory", "AdobeJpegDirectory", "CanonMakernoteDirectory",
			"CasioType1MakernoteDirectory", "CasioType2MakernoteDirectory",
			"FujifilmMakernoteDirectory", "IccDirectory", "IptcDirectory",
			"KodakMakernoteDirectory", "KyoceraMakernoteDirectory",
			"LeicaMakernoteDirectory", "NikonType1MakernoteDirectory",
			"NikonType2MakernoteDirectory", "OlympusMakernoteDirectory",
			"PanasonicMakernoteDirectory", "PentaxMakernoteDirectory",
			"PhotoshopDirectory", "PngChromaticitiesDirectory", "PngDirectory",
			"PsdHeaderDirectory", "RicohMakernoteDirectory",
			"SanyoMakernoteDirectory", "SigmaMakernoteDirectory",
			"SonyType1MakernoteDirectory", "SonyType6MakernoteDirectory",
			"XmpDirectory" };

	/*
	 * ListModel<String> lm = new AbstractListModel<String>() {
	 * GetConstReflection gcr = new GetConstReflection(
	 * ExifSubIFDDirectory.class); ArrayList<String> al = gcr.getConst();
	 * 
	 * public int getSize() { return al.size(); }
	 * 
	 * public String getElementAt(int index) { return al.get(index); } };
	 */
	/**
	 * Initialize the contents of the frame.
	 * 
	 * @throws ClassNotFoundException
	 */
	private void initialize() {
		frmAeroportImagesorter = new JFrame();
		frmAeroportImagesorter.setSize(new Dimension(537, 417));
		frmAeroportImagesorter.setMinimumSize(new Dimension(300, 300));
		frmAeroportImagesorter.setTitle("AERoport ImageSorter");
		frmAeroportImagesorter.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 100, 100, 10, 100, 20, 30, 30 };
		gridBagLayout.rowHeights = new int[] { 10, 10, 10, 10, 200 };
		gridBagLayout.columnWeights = new double[] { 10, 10, 0, 1, 1, 1, 1.0 };
		gridBagLayout.rowWeights = new double[] { 0, 0, 0, 0, 20 };
		frmAeroportImagesorter.getContentPane().setLayout(gridBagLayout);

		JComboBox comboBoxEXIFTagType = new JComboBox(TAG_TYPES_SERIES);// Fill
		// TagTypesSeries
		GridBagConstraints gbc_comboBoxEXIFTagType = new GridBagConstraints();
		gbc_comboBoxEXIFTagType.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBoxEXIFTagType.insets = new Insets(0, 0, 5, 5);
		gbc_comboBoxEXIFTagType.gridx = 0;
		gbc_comboBoxEXIFTagType.gridy = 0;
		frmAeroportImagesorter.getContentPane().add(comboBoxEXIFTagType,
				gbc_comboBoxEXIFTagType);

		JComboBox comboBoxDataType = new JComboBox();
		GridBagConstraints gbc_comboBoxDataType = new GridBagConstraints();
		gbc_comboBoxDataType.insets = new Insets(0, 0, 5, 5);
		gbc_comboBoxDataType.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBoxDataType.gridx = 1;
		gbc_comboBoxDataType.gridy = 0;
		frmAeroportImagesorter.getContentPane().add(comboBoxDataType,
				gbc_comboBoxDataType);

		JComboBox comboBoxProfile = new JComboBox();
		GridBagConstraints gbc_comboBoxProfile = new GridBagConstraints();
		gbc_comboBoxProfile.insets = new Insets(0, 0, 5, 5);
		gbc_comboBoxProfile.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBoxProfile.gridx = 3;
		gbc_comboBoxProfile.gridy = 2;
		frmAeroportImagesorter.getContentPane().add(comboBoxProfile,
				gbc_comboBoxProfile);

		textFieldDest = new JTextField();
		GridBagConstraints gbc_textFieldDest = new GridBagConstraints();
		gbc_textFieldDest.gridwidth = 4;
		gbc_textFieldDest.insets = new Insets(0, 0, 5, 0);
		gbc_textFieldDest.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldDest.gridx = 3;
		gbc_textFieldDest.gridy = 1;
		frmAeroportImagesorter.getContentPane().add(textFieldDest,
				gbc_textFieldDest);
		textFieldDest.setColumns(10);

		JButton btnGo = new JButton("GO!");
		GridBagConstraints gbc_btnGo = new GridBagConstraints();
		gbc_btnGo.insets = new Insets(0, 0, 5, 0);
		gbc_btnGo.gridx = 6;
		gbc_btnGo.gridy = 2;
		frmAeroportImagesorter.getContentPane().add(btnGo, gbc_btnGo);

		JTree tree = new JTree();
		GridBagConstraints gbc_tree = new GridBagConstraints();
		gbc_tree.gridwidth = 4;
		gbc_tree.gridheight = 2;
		gbc_tree.fill = GridBagConstraints.BOTH;
		gbc_tree.gridx = 3;
		gbc_tree.gridy = 3;
		frmAeroportImagesorter.getContentPane().add(tree, gbc_tree);

		JList listParam = new JList();
		GridBagConstraints gbc_listParam = new GridBagConstraints();
		gbc_listParam.gridwidth = 2;
		gbc_listParam.gridheight = 4;
		gbc_listParam.insets = new Insets(0, 0, 5, 5);
		gbc_listParam.fill = GridBagConstraints.BOTH;
		gbc_listParam.gridx = 1;
		gbc_listParam.gridy = 4;
		frmAeroportImagesorter.getContentPane().add(listParam, gbc_listParam);

		textFieldData = new JTextField();
		GridBagConstraints gbc_textFieldData = new GridBagConstraints();
		gbc_textFieldData.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldData.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldData.gridx = 1;
		gbc_textFieldData.gridy = 2;
		frmAeroportImagesorter.getContentPane().add(textFieldData,
				gbc_textFieldData);
		textFieldData.setColumns(10);

		JComboBox comboBoxDataLength = new JComboBox();
		GridBagConstraints gbc_comboBoxDataLength = new GridBagConstraints();
		gbc_comboBoxDataLength.insets = new Insets(0, 0, 5, 5);
		gbc_comboBoxDataLength.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBoxDataLength.gridx = 1;
		gbc_comboBoxDataLength.gridy = 1;
		frmAeroportImagesorter.getContentPane().add(comboBoxDataLength,
				gbc_comboBoxDataLength);

		JList list_EXIF = new JList();
		GridBagConstraints gbc_list_EXIF = new GridBagConstraints();
		gbc_list_EXIF.insets = new Insets(0, 0, 0, 5);
		gbc_list_EXIF.gridheight = 7;
		gbc_list_EXIF.fill = GridBagConstraints.BOTH;
		gbc_list_EXIF.gridx = 0;
		gbc_list_EXIF.gridy = 1;
		frmAeroportImagesorter.getContentPane().add(list_EXIF, gbc_list_EXIF);

		JScrollPane scrollPanelistEXIF = new JScrollPane(list_EXIF);
		GridBagConstraints gbc_scrollPanelistEXIF = new GridBagConstraints();
		gbc_scrollPanelistEXIF.gridheight = 4;
		gbc_scrollPanelistEXIF.insets = new Insets(0, 0, 0, 5);
		gbc_scrollPanelistEXIF.fill = GridBagConstraints.BOTH;
		gbc_scrollPanelistEXIF.gridx = 0;
		gbc_scrollPanelistEXIF.gridy = 1;
		frmAeroportImagesorter.getContentPane().add(scrollPanelistEXIF,
				gbc_scrollPanelistEXIF);

		JButton btnToParamList = new JButton("Add");
		GridBagConstraints gbc_btnToParamList = new GridBagConstraints();
		gbc_btnToParamList.insets = new Insets(0, 0, 5, 5);
		gbc_btnToParamList.gridx = 1;
		gbc_btnToParamList.gridy = 3;
		frmAeroportImagesorter.getContentPane().add(btnToParamList,
				gbc_btnToParamList);

		JButton buttonToTree = new JButton("To tree");
		GridBagConstraints gbc_buttonToTree = new GridBagConstraints();
		gbc_buttonToTree.insets = new Insets(0, 0, 5, 5);
		gbc_buttonToTree.gridx = 2;
		gbc_buttonToTree.gridy = 3;
		frmAeroportImagesorter.getContentPane().add(buttonToTree,
				gbc_buttonToTree);

		JLabel lblSource = new JLabel("Source");
		GridBagConstraints gbc_lblSource = new GridBagConstraints();
		gbc_lblSource.insets = new Insets(0, 0, 5, 5);
		gbc_lblSource.anchor = GridBagConstraints.EAST;
		gbc_lblSource.gridx = 2;
		gbc_lblSource.gridy = 0;
		frmAeroportImagesorter.getContentPane().add(lblSource, gbc_lblSource);

		textFieldSource = new JTextField();
		GridBagConstraints gbc_textFieldSource = new GridBagConstraints();
		gbc_textFieldSource.gridwidth = 4;
		gbc_textFieldSource.insets = new Insets(0, 0, 5, 0);
		gbc_textFieldSource.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldSource.gridx = 3;
		gbc_textFieldSource.gridy = 0;
		frmAeroportImagesorter.getContentPane().add(textFieldSource,
				gbc_textFieldSource);
		textFieldSource.setColumns(10);

		JLabel lblDest = new JLabel("Dest");
		GridBagConstraints gbc_lblDest = new GridBagConstraints();
		gbc_lblDest.anchor = GridBagConstraints.EAST;
		gbc_lblDest.insets = new Insets(0, 0, 5, 5);
		gbc_lblDest.gridx = 2;
		gbc_lblDest.gridy = 1;
		frmAeroportImagesorter.getContentPane().add(lblDest, gbc_lblDest);

		JLabel lblProfile = new JLabel("Profile");
		GridBagConstraints gbc_lblProfile = new GridBagConstraints();
		gbc_lblProfile.anchor = GridBagConstraints.EAST;
		gbc_lblProfile.insets = new Insets(0, 0, 5, 5);
		gbc_lblProfile.gridx = 2;
		gbc_lblProfile.gridy = 2;
		frmAeroportImagesorter.getContentPane().add(lblProfile, gbc_lblProfile);

		JButton btnSave = new JButton("Save");
		GridBagConstraints gbc_btnSave = new GridBagConstraints();
		gbc_btnSave.insets = new Insets(0, 0, 5, 5);
		gbc_btnSave.gridx = 4;
		gbc_btnSave.gridy = 2;
		frmAeroportImagesorter.getContentPane().add(btnSave, gbc_btnSave);

		JCheckBox chckbxDefault = new JCheckBox("Default");
		GridBagConstraints gbc_chckbxDefault = new GridBagConstraints();
		gbc_chckbxDefault.insets = new Insets(0, 0, 5, 5);
		gbc_chckbxDefault.gridx = 5;
		gbc_chckbxDefault.gridy = 2;
		frmAeroportImagesorter.getContentPane().add(chckbxDefault,
				gbc_chckbxDefault);

		JScrollPane scrollPaneListParam = new JScrollPane(listParam);
		GridBagConstraints gbc_scrollPaneListParam = new GridBagConstraints();
		gbc_scrollPaneListParam.gridwidth = 2;
		gbc_scrollPaneListParam.insets = new Insets(0, 0, 0, 5);
		gbc_scrollPaneListParam.fill = GridBagConstraints.BOTH;
		gbc_scrollPaneListParam.gridx = 1;
		gbc_scrollPaneListParam.gridy = 4;
		frmAeroportImagesorter.getContentPane().add(scrollPaneListParam,
				gbc_scrollPaneListParam);

	}
}
