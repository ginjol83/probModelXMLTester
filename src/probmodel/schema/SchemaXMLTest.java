/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Properties;

import javax.swing.BorderFactory;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.border.Border;
import javax.xml.bind.JAXBException;

/**
 *
 * @author Andrés Giménez Perales
 */
public class SchemaXMLTest extends javax.swing.JFrame {

	private static final long serialVersionUID = 1L;

	/**
	 * Creates new form SchemaXMLTest
	 */
	public SchemaXMLTest() {
		initComponents();
	}

	/**
	 * This method is called from within the constructor to initialize the form.
	 */
	private void initComponents() {

		URL url = getClass().getResource("configurations/config.properties");
		File file = new File(url.getPath());
		Properties properties = new Properties();

		try {
			properties.load(new FileInputStream(file));
		} catch (IOException e) {
			e.printStackTrace();
		}

		//get properties from properties file
		defaultResourcesPGMXPath = properties.getProperty("default_xml_path");
		resourcesPath = properties.getProperty("default_schema_path");
		resourcesPGMXPath = properties.getProperty("default_xml_path");

		Language language = new Language(properties.getProperty("language"));

		this.setTitle("SchemaXMLTest 1.0");
		
		//initialization Swing components
		scrollPane = new javax.swing.JScrollPane();
		textComponent = new javax.swing.JTextPane();
		toolBar = new javax.swing.JToolBar();
		selectPathButton = new javax.swing.JButton();
		separator3 = new javax.swing.JToolBar.Separator();
		cleanPathButton = new javax.swing.JButton();
		runTestButton = new javax.swing.JButton();
		separator1 = new javax.swing.JToolBar.Separator();
		configButton = new javax.swing.JButton();
		helpButton = new javax.swing.JButton();
		separator2 = new javax.swing.JToolBar.Separator();
		closeTestButton = new javax.swing.JButton();
		panel = new javax.swing.JPanel();
		fileChooserLabel = new javax.swing.JLabel();
		fileText = new javax.swing.JTextField();
		menuBar = new javax.swing.JMenuBar();
		fileMenu = new javax.swing.JMenu();
		selectPathMenuItem = new javax.swing.JMenuItem();
		configurationMenuItem = new javax.swing.JMenuItem();
		exitMenuItem = new javax.swing.JMenuItem();
		runMenu = new javax.swing.JMenu();
		clearMenuItem = new javax.swing.JMenuItem();
		runMenuItem = new javax.swing.JMenuItem();
		helpMenu = new javax.swing.JMenu();
		helpMenuItem = new javax.swing.JMenuItem();

		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

		fileText.setEditable(false);
		fileText.setText(resourcesPGMXPath);
		fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);

		// JTextPane textComponent
		Border border = BorderFactory.createLineBorder(Color.BLACK);
		textComponent.setContentType("text/html");
		textComponent.setEditable(false);
		textComponent.setBorder(border);

		panel.add(textComponent, BorderLayout.CENTER);

		scrollPane.setViewportView(textComponent);

		toolBar.setFloatable(false);
		toolBar.setRollover(true);

		selectPathButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/download.png"))); 
		selectPathButton.setToolTipText("");
		selectPathButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				openFileChooserDialog();
			}
		});

		toolBar.add(selectPathButton);
		toolBar.add(separator3);

		cleanPathButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/trash.png")));
		cleanPathButton.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				textComponent.setText("");
				fileText.setText(defaultResourcesPGMXPath);
			}
		});

		toolBar.add(cleanPathButton);

		runTestButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/play-green.png"))); 
		runTestButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String content = executeTest().toString();
				textComponent.setText(content);
			}
		});

		toolBar.add(runTestButton);
		toolBar.add(separator1);

		configButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/manage.png"))); 
		configButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				ConfigurationDialog configurationForm = new ConfigurationDialog(null, true);
				configurationForm.setVisible(true);
				initComponents();
			}
		});
		
		toolBar.add(configButton);

		helpButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/question.png"))); 
		helpButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null,
						"App: SchemaXMLTest 1.0\ndeveloped By: Andrés Giménez\n Version:1.0", "SchemaXMLTest 1.0 Help",
						0, null);
			}
		});
		
		toolBar.add(helpButton);
		toolBar.add(separator2);

		closeTestButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/log-out.png"))); // NOI18N
		closeTestButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		closeTestButton.setToolTipText("");

		toolBar.add(closeTestButton);

		fileChooserLabel.setText(language.getProperty("Path_selected"));

		javax.swing.GroupLayout panelLayout = new javax.swing.GroupLayout(panel);
		panel.setLayout(panelLayout);
		panelLayout.setHorizontalGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(panelLayout.createSequentialGroup().addContainerGap().addComponent(fileChooserLabel)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED).addComponent(fileText)
						.addContainerGap()));
		panelLayout.setVerticalGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(panelLayout.createSequentialGroup().addContainerGap()
						.addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(fileChooserLabel).addComponent(fileText,
										javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE,
										javax.swing.GroupLayout.PREFERRED_SIZE))
						.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));

		fileMenu.setText(language.getProperty("File"));

		selectPathMenuItem.setText(language.getProperty("Open_file"));
		selectPathMenuItem.setName("openFileMenu");
		selectPathMenuItem.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				openFileChooserDialog();
			}
		});

		fileMenu.add(selectPathMenuItem);

		configurationMenuItem.setText(language.getProperty("Configuration"));
		configurationMenuItem.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {

				ConfigurationDialog configurationForm = new ConfigurationDialog(null, true);

				configurationForm.setVisible(true);

			}
		});

		fileMenu.add(configurationMenuItem);

		exitMenuItem.setText(language.getProperty("Exit"));
		exitMenuItem.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				System.exit(0);
			}
		});
		fileMenu.add(exitMenuItem);

		menuBar.add(fileMenu);

		runMenu.setText(language.getProperty("Run"));

		clearMenuItem.setText(language.getProperty("Clear_Console"));
		clearMenuItem.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				textComponent.setText("");
				fileText.setText(defaultResourcesPGMXPath);
			}
		});
		runMenu.add(clearMenuItem);

		runMenuItem.setText(language.getProperty("Run_Test"));
		runMenuItem.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				String content = executeTest().toString();
				textComponent.setText(content);
			}
		});

		runMenu.add(runMenuItem);

		menuBar.add(runMenu);

		helpMenu.setText(language.getProperty("Help"));

		helpMenuItem.setText(language.getProperty("About"));
		helpMenuItem.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				JOptionPane.showMessageDialog(null,
						"App: SchemaXMLTest 1.0\ndeveloped By: Andrés Giménez\n Version:1.0", "SchemaXMLTest 1.0 Help",
						0, null);
			}
		});
		helpMenu.add(helpMenuItem);

		menuBar.add(helpMenu);

		setJMenuBar(menuBar);

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(
				layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(scrollPane)
						.addComponent(toolBar, javax.swing.GroupLayout.DEFAULT_SIZE, 478, Short.MAX_VALUE).addComponent(
								panel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE));
		layout.setVerticalGroup(
				layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
								.addComponent(toolBar, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
								.addComponent(panel, javax.swing.GroupLayout.PREFERRED_SIZE, 37,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
								.addComponent(scrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 372, Short.MAX_VALUE)));

		pack();
	}

	public String getPropValues() throws IOException {
		//This function retunrs the properties object
		Properties properties = new Properties();
		properties.load(new FileInputStream(new File("./config.properties")));

		return properties.getProperty("user");
	}

	static void openFileChooserDialog() {
		//This method load the file chooser dialog
		int optionSelected = fileChooser.showOpenDialog(panel);

		if (optionSelected == JFileChooser.APPROVE_OPTION) {
			File file = fileChooser.getSelectedFile();
			resourcesPGMXPath = file.getAbsolutePath() + "/";
			fileText.setText(resourcesPGMXPath);
		}
	}

	public StringBuffer executeTest() {
		// Method generator test results
		URL url = getClass().getResource("configurations/config.properties");
		File file = new File(url.getPath());
		System.out.println(url.getPath());
		Properties properties = new Properties();

		try {
			properties.load(new FileInputStream(file));
		} catch (IOException e) {
			e.printStackTrace();
		}

		resourcesPath = properties.getProperty("default_schema_path");
		testHeader = properties.getProperty("test_header");
		xsdFile = properties.getProperty("xsd_file");

		resourcesPGMXPath = fileText.getText();

		StringBuffer sbuffer = new StringBuffer();
		PGMXSchemaValidator javaIOUtils = new PGMXSchemaValidator();
		ArrayList<String> directoryList = javaIOUtils.readFolderFiles(resourcesPGMXPath);

		// Add header
		System.out.println();
		sbuffer.append(testHeader);
		sbuffer.append(resourcesPath);
		sbuffer.append(xsdFile);

		// Add body
		for (String xmlFile : directoryList) {
			try {
				sbuffer.append(
						"-----------------------------------------------------------------------------------------------<br>");
				System.out.println(xmlFile + " validates against " + xsdFile + ": "
						+ javaIOUtils.validateXMLSchema(resourcesPath + xsdFile, resourcesPGMXPath + xmlFile));

				String result = javaIOUtils.validateXMLSchema(resourcesPath + xsdFile, resourcesPGMXPath + xmlFile);

				sbuffer.append(xmlFile + " validates against " + xsdFile + ":<br> ");
				if (result != "") {
					sbuffer.append("<font color='red'>" + result + "</font><br>");
				} else {
					sbuffer.append("<font color='blue'>OK, Test passed</font><br>");
				}

			} catch (IOException e) {
				e.printStackTrace();
				JOptionPane.showInternalMessageDialog(null, e);
			} catch (JAXBException e) {
				e.printStackTrace();
				JOptionPane.showInternalMessageDialog(null, e);
			}
		}
		
		//Return result text on String buffer
		return sbuffer;
	}

	/**
	 * @param args the command line arguments
	 */
	public static void main(String args[]) {
		//Main method
		try {
			for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
				if ("Nimbus".equals(info.getName())) {
					javax.swing.UIManager.setLookAndFeel(info.getClassName());
					break;
				}
			}
		} catch (ClassNotFoundException ex) {
			java.util.logging.Logger.getLogger(SchemaXMLTest.class.getName()).log(java.util.logging.Level.SEVERE, null,
					ex);
		} catch (InstantiationException ex) {
			java.util.logging.Logger.getLogger(SchemaXMLTest.class.getName()).log(java.util.logging.Level.SEVERE, null,
					ex);
		} catch (IllegalAccessException ex) {
			java.util.logging.Logger.getLogger(SchemaXMLTest.class.getName()).log(java.util.logging.Level.SEVERE, null,
					ex);
		} catch (javax.swing.UnsupportedLookAndFeelException ex) {
			java.util.logging.Logger.getLogger(SchemaXMLTest.class.getName()).log(java.util.logging.Level.SEVERE, null,
					ex);
		}

		/* Create and display the form */
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				new SchemaXMLTest().setVisible(true);
			}
		});
	}

	// Variables declaration - do not modify

	private javax.swing.JMenu fileMenu;
	private javax.swing.JMenu runMenu;
	private javax.swing.JMenu helpMenu;
	private javax.swing.JMenuBar menuBar;
	private javax.swing.JMenuItem selectPathMenuItem;
	private javax.swing.JMenuItem exitMenuItem;
	private javax.swing.JMenuItem configurationMenuItem;
	private javax.swing.JMenuItem clearMenuItem;
	private javax.swing.JMenuItem runMenuItem;
	private javax.swing.JMenuItem helpMenuItem;

	private javax.swing.JLabel fileChooserLabel;
	private javax.swing.JToolBar.Separator separator1;
	private javax.swing.JToolBar.Separator separator2;
	private javax.swing.JToolBar.Separator separator3;

	private static javax.swing.JTextField fileText;
	private static javax.swing.JPanel panel;
	private javax.swing.JButton helpButton;
	private javax.swing.JButton configButton;
	private javax.swing.JToolBar toolBar;
	private javax.swing.JScrollPane scrollPane;

	static javax.swing.JFileChooser fileChooser = new JFileChooser();
	private javax.swing.JButton closeTestButton;
	private javax.swing.JButton runTestButton;
	private javax.swing.JButton selectPathButton;
	private javax.swing.JButton cleanPathButton;
	private javax.swing.JTextPane textComponent;

	// LiteralS
	static String xsdFile;
	static String resourcesPath;
	static String resourcesPGMXPath;
	static String defaultResourcesPGMXPath;
	static String testHeader;

	// End of variables declaration
}
