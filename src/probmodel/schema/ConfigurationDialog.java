package schema;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.util.Properties;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;


/**
 * @author Andrés Giménez Perales
 */
public class ConfigurationDialog extends javax.swing.JDialog {

	private static final long serialVersionUID = 1L;
	
	/**
     * Creates new form ConfigurationDialog
     */
    public ConfigurationDialog(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     */
    private void initComponents() {

        xsdField = new javax.swing.JTextField();
        defaultSchemaPathField = new javax.swing.JTextField();
        saveButton = new javax.swing.JButton();
        exitButton = new javax.swing.JButton();
        defaultSchemaPathLabel = new javax.swing.JLabel();
        testHeaderLabel = new javax.swing.JLabel();
        xsdLabel = new javax.swing.JLabel();
        defaultXmlPathLabel = new javax.swing.JLabel();
        defaultXmlPathField = new javax.swing.JTextField();
        confLabel = new javax.swing.JLabel();
        testHeaderField = new javax.swing.JTextField();
        combo = new JComboBox<String>();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        URL url = getClass().getResource("configurations/config.properties");
        final File file = new File(url.getPath());
    	final Properties properties = new Properties();

		try {
			properties.load(new FileInputStream(file));
		} catch (IOException e) {
			e.printStackTrace();
		}
        
        defaultXmlPathField.setText(properties.getProperty("default_xml_path"));
        testHeaderField.setText(properties.getProperty("test_header"));
        xsdField.setText(properties.getProperty("xsd_file"));
        defaultSchemaPathField.setText(properties.getProperty("default_schema_path"));
        
        saveButton.setText("Save");
        
        
        saveButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                int sure = JOptionPane.showConfirmDialog(null, "Are you sure?");

                if (sure == 0) {
	                properties.setProperty("default_xml_path",defaultXmlPathField.getText());
	                properties.setProperty("test_header",testHeaderField.getText());
	                properties.setProperty("xsd_file",xsdField.getText());
	                properties.setProperty("default_schema_path",defaultSchemaPathField.getText());
	                
	                if(combo.getSelectedItem().equals("English")) {
	                	properties.setProperty("language","En");
	                }
	                
	                if(combo.getSelectedItem().equals("Español")) {
	                	properties.setProperty("language","Es");
	                }
	                
	                if(combo.getSelectedItem().equals("Italiano")) {
	                	properties.setProperty("language","It");
	                }
	                
	                if(combo.getSelectedItem().equals("Català")) {
	                	properties.setProperty("language","Cat");
	                }
	                
	                try {
						properties.store(new FileOutputStream(file), "saved");
					} catch (FileNotFoundException e) {
						e.printStackTrace(); 
					} catch (IOException e) {
						e.printStackTrace();
					}
	                
	                dispose();
                }
            }
        });

        exitButton.setText("Exit");
        exitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dispose();
            }
        });

        defaultSchemaPathLabel.setText("Default xml path");

        testHeaderLabel.setText("Default Schema path");

        xsdLabel.setText("testHeader");

        defaultXmlPathLabel.setText("xsdFile");

        confLabel.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        confLabel.setText("Configuration Form");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(115, 115, 115)
                        .addComponent(confLabel))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(saveButton)
                                .addGap(18, 18, 18)
                                .addComponent(exitButton)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(xsdLabel)
                                .addGap(18, 18, 18)
                                .addComponent(testHeaderField))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(defaultSchemaPathLabel)
                                .addGap(18, 18, 18)
                                .addComponent(defaultXmlPathField))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(testHeaderLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(defaultSchemaPathField, javax.swing.GroupLayout.DEFAULT_SIZE, 256, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(defaultXmlPathLabel)
                                .addGap(18, 18, 18)
                                .addComponent(xsdField)))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(confLabel)
                .addGap(53, 53, 53)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(defaultSchemaPathLabel)
                    .addComponent(defaultXmlPathField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(testHeaderLabel)
                    .addComponent(defaultSchemaPathField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(xsdLabel)
                    .addComponent(testHeaderField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(defaultXmlPathLabel)
                    .addComponent(xsdField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 46, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(saveButton)
                    .addComponent(exitButton))
                .addContainerGap())
        );
        JLabel labelIdioma = new JLabel();
        
        labelIdioma.setText("Language");
        labelIdioma.setBounds(25,40,80,20);
        
		combo.addItem("English");
		combo.addItem("Español"); 
		combo.addItem("Italiano");
		combo.addItem("Català");
		
		String lang = properties.getProperty("language");
		
		if (lang.equals("It")) { combo.setSelectedItem("Italiano"); }
		if (lang.equals("Es")) { combo.setSelectedItem("Español"); }
		if (lang.equals("En")) { combo.setSelectedItem("English"); }
		if (lang.equals("Cat")) { combo.setSelectedItem("Català"); }
		
        combo.setBounds(75,40,80,20);
        
        getContentPane().add(combo);
        getContentPane().add(labelIdioma);
        
        combo.setVisible(true);
        labelIdioma.setVisible(true);
        pack();
    }                      

    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ConfigurationDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ConfigurationDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ConfigurationDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ConfigurationDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                ConfigurationDialog dialog = new ConfigurationDialog(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setTitle("Configuration Form");
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration               
    private javax.swing.JButton saveButton;
    private javax.swing.JButton exitButton;
    private javax.swing.JLabel defaultSchemaPathLabel;
    private javax.swing.JLabel testHeaderLabel;
    private javax.swing.JLabel xsdLabel;
    private javax.swing.JLabel defaultXmlPathLabel;
    private javax.swing.JLabel confLabel;
    private javax.swing.JTextField defaultXmlPathField;
    private javax.swing.JTextField testHeaderField;
    private javax.swing.JTextField xsdField;
    private javax.swing.JTextField defaultSchemaPathField;
    private javax.swing.JComboBox<String> combo;
    // End of variables declaration                   
}
