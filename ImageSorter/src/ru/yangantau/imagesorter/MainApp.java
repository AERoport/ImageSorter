package ru.yangantau.imagesorter;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collection;

import javax.swing.AbstractListModel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JTree;
import javax.swing.ListModel;

import com.drew.metadata.Directory;
import com.drew.metadata.Tag;

public class MainApp {

	private JFrame frmAeroportImagesorter;
	private JTextField textFieldData;
	private JTextField textFieldSource;
	private JTextField textFieldDest;
	private JComboBox<String> comboBoxEXIFTagType;
	private JTextArea textArea;
	private JList<String> list_EXIF;
	private JComboBox<String> comboBoxDataType;
	private JComboBox<String> comboBoxProfile;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainApp window = new MainApp();
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
	 * @throws IllegalAccessException
	 * @throws InstantiationException
	 * 
	 * @throws ClassNotFoundException
	 */
	public MainApp() throws InstantiationException, IllegalAccessException {
		initialize();
	}

	// /
	private static final String[] TAG_TYPES_SERIES = { "ExifSubIFDDirectory",
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

	ListModel<String> getTags(final String className) {
		ListModel<String> lm;
		try {
			lm = new AbstractListModel<String>() {

				ArrayList<String> al = GetConstReflection
						.CalculateTags(className);

				public int getSize() {
					return al.size();
				}

				public String getElementAt(int index) {
					return al.get(index);
				}
			};
		} catch (ClassNotFoundException e) {
			return null;
		}
		;

		return lm;
	};

	/**
	 * Initialize the contents of the frame.
	 * 
	 * @throws ClassNotFoundException
	 * @throws IllegalAccessException
	 * @throws InstantiationException
	 */
	private void initialize() throws InstantiationException,
			IllegalAccessException {
		frmAeroportImagesorter = new JFrame();
		frmAeroportImagesorter.setSize(new Dimension(537, 417));
		frmAeroportImagesorter.setMinimumSize(new Dimension(300, 300));
		frmAeroportImagesorter.setTitle("AERoport ImageSorter");
		frmAeroportImagesorter.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 100, 100, 10, 100, 20, 30, 30 };
		gridBagLayout.rowHeights = new int[] { 10, 10, 10, 10, 200 };
		gridBagLayout.columnWeights = new double[] { 10, 10, 0, 1.0, 1, 1, 1.0 };
		gridBagLayout.rowWeights = new double[] { 0, 0, 0, 0, 1.0 };
		frmAeroportImagesorter.getContentPane().setLayout(gridBagLayout);

		textArea = new JTextArea();
		GridBagConstraints gbc_textArea = new GridBagConstraints();
		gbc_textArea.gridwidth = 4;
		gbc_textArea.insets = new Insets(0, 0, 0, 5);
		gbc_textArea.fill = GridBagConstraints.BOTH;
		gbc_textArea.gridx = 3;
		gbc_textArea.gridy = 4;
		frmAeroportImagesorter.getContentPane().add(textArea, gbc_textArea);

		comboBoxEXIFTagType = new JComboBox<String>(TAG_TYPES_SERIES);// Fill
		comboBoxEXIFTagType.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				textArea.append("actionPerformed\n");
				String selItem = "com.drew.metadata.exif."
						+ (String) comboBoxEXIFTagType.getModel()
								.getSelectedItem();
				ListModel<String> lm = getTags(selItem);
				if (lm != null) {
					list_EXIF.setModel(lm);
				}

			}
		});

		GridBagConstraints gbc_comboBoxEXIFTagType = new GridBagConstraints();
		gbc_comboBoxEXIFTagType.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBoxEXIFTagType.insets = new Insets(0, 0, 5, 5);
		gbc_comboBoxEXIFTagType.gridx = 0;
		gbc_comboBoxEXIFTagType.gridy = 0;
		frmAeroportImagesorter.getContentPane().add(comboBoxEXIFTagType,
				gbc_comboBoxEXIFTagType);

		comboBoxDataType = new JComboBox<String>();
		GridBagConstraints gbc_comboBoxDataType = new GridBagConstraints();
		gbc_comboBoxDataType.insets = new Insets(0, 0, 5, 5);
		gbc_comboBoxDataType.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBoxDataType.gridx = 1;
		gbc_comboBoxDataType.gridy = 0;
		frmAeroportImagesorter.getContentPane().add(comboBoxDataType,
				gbc_comboBoxDataType);

		comboBoxProfile = new JComboBox();
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
		gbc_tree.insets = new Insets(0, 0, 5, 0);
		gbc_tree.gridwidth = 4;
		gbc_tree.fill = GridBagConstraints.BOTH;
		gbc_tree.gridx = 3;
		gbc_tree.gridy = 3;
		frmAeroportImagesorter.getContentPane().add(tree, gbc_tree);

		// ************** List of param
		JList<String> listParam = new JList<String>();
		JScrollPane scrollPaneListParam = new JScrollPane(listParam);
		GridBagConstraints gbc_scrollPaneListParam = new GridBagConstraints();
		gbc_scrollPaneListParam.gridwidth = 2;
		gbc_scrollPaneListParam.insets = new Insets(0, 0, 0, 5);
		gbc_scrollPaneListParam.fill = GridBagConstraints.BOTH;
		gbc_scrollPaneListParam.gridx = 1;
		gbc_scrollPaneListParam.gridy = 4;
		frmAeroportImagesorter.getContentPane().add(scrollPaneListParam,
				gbc_scrollPaneListParam);

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

		// ********************** list EXIF Tags

		list_EXIF = new JList<String>();
		String selItem = "com.drew.metadata.exif."
				+ (String) comboBoxEXIFTagType.getModel().getSelectedItem();
		// **************
		textArea.append("selItem="+selItem + "\n");

		// **************************************
		// ************* TEST!!!!! *************
		try {
			Directory d = (Directory) Class.forName(selItem).newInstance();
			textArea.append("d.getName()="+d.getName() + "\n");
			textArea.append("d.getTagCount()="+d.getTagCount());
			for (Tag t:d.getTags()) {
				textArea.append(t.toString()+"\n");
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			textArea.append("ERROR\n");
		}
		// ************* TEST END *************
		// **************************************

		ListModel<String> lm = getTags(selItem);
		if (lm != null) {
			list_EXIF.setModel(lm);
		}

		JScrollPane scrollPanelistEXIF = new JScrollPane(list_EXIF);
		GridBagConstraints gbc_scrollPanelistEXIF = new GridBagConstraints();
		gbc_scrollPanelistEXIF.gridheight = 4;
		gbc_scrollPanelistEXIF.insets = new Insets(0, 0, 0, 5);
		gbc_scrollPanelistEXIF.fill = GridBagConstraints.BOTH;
		gbc_scrollPanelistEXIF.gridx = 0;
		gbc_scrollPanelistEXIF.gridy = 1;
		frmAeroportImagesorter.getContentPane().add(scrollPanelistEXIF,
				gbc_scrollPanelistEXIF);

		// ************ BUTTON ADD
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

	}
}
