package schema;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.xml.bind.JAXBException;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;

import org.xml.sax.SAXException;

/**
 * @author Andrés Giménez Perales
 */
public class PGMXSchemaValidator {

	/**
	 * Explanation of the method by which we read the folder we pass as parameter if
	 * exists, returning a list of files on the directory
	 *
	 * @param folder <code>String</code> path.
	 * @return <code>ArrayList<String></code> list of filpublic es in path
	 */
	ArrayList<String> readFolderFiles(String folder) {
		ArrayList<String> resultado = new ArrayList<String>();
		File folderFile = new File(folder);

		if (folderFile.exists()) {
			File[] files = folderFile.listFiles();
			for (File file : files) {
				boolean isFolder = file.isDirectory();
				if (!isFolder) {
					resultado.add(file.getName());
				}
			}
		}
		return resultado;
	}

	/**
	 * Explanation of the method by which we read the paths (pgmx file path and the
	 * xsd file path) we pass as parameter if has match, returning a true otherwise
	 * return a false value and print the exception on console.
	 * 
	 * @param folder <code>String</code> path xsd file.
	 * @param folder <code>String</code> path pgmx file.
	 * @return <code>String</code> match error string or ""
	 */
	public String validateXMLSchema(String xsdPath, String pgmxPath) throws IOException, JAXBException {

		try {
			SchemaFactory factory = SchemaFactory.newInstance("http://www.w3.org/XML/XMLSchema/v1.1");
			Schema schema = factory.newSchema(new File(xsdPath));

			Validator validator = schema.newValidator();
			validator.validate(new StreamSource(new File(pgmxPath)));

		} catch (SAXException e) {
			System.out.println("Exception: " + e.getMessage());
			return "Exception: " + e.getMessage();
		}
		return "";
	}
}
