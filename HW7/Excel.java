import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.UIManager;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import org.apache.poi.ss.usermodel.Row;

/**
 * Program generates a UI that allows a user to enter in a .xlsx sheet that
 * keeps track of instrument inventory and update it with a vendor sheet and
 * outputting a new sheet in the user's desired directory
 * 
 * @author peter
 *
 */
public class Excel extends JFrame {
	static JTextField masterLocation;
	static JTextField vendorLocation;
	static JTextField outputLocation;
	static JTextField runProduct;
	static ArrayList<Row> master = new ArrayList<Row>();
	static ArrayList<Row> vendor = new ArrayList<Row>();
	static ArrayList<Row> output = new ArrayList<Row>();
	static int mskuLocation = 0;
	static int mmapLocation = 0;
	static int vskuLocation = 0;
	static int vmapLocation = 0;
	static String outLocation = "";
	private JButton masterFile;
	private JButton vendorFile;
	private JButton outputFile;
	private JButton run;

	Excel() {
		masterFile = new JButton("Select Master Sheet: ");
		vendorFile = new JButton("Select Vendor Sheet: ");
		outputFile = new JButton("Select save location: ");
		run = new JButton("Run");

		masterLocation = new JTextField(20);
		masterLocation.setText("...");
		masterLocation.setEditable(false);

		vendorLocation = new JTextField(20);
		vendorLocation.setText("...");
		vendorLocation.setEditable(false);

		outputLocation = new JTextField(20);
		outputLocation.setText("...");
		outputLocation.setEditable(false);

		runProduct = new JTextField(20);
		runProduct.setText("");
		runProduct.setEditable(false);

		GridBagConstraints layoutConst = null;

		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Exception e) {
		}

		ActionListener master = new masterAction();
		ActionListener vendor = new vendorAction();
		ActionListener output = new outputAction();
		ActionListener runner = new runAction();
		masterFile.addActionListener(master);
		vendorFile.addActionListener(vendor);
		outputFile.addActionListener(output);
		run.addActionListener(runner);

		setTitle("Excel");
		setLayout(new GridBagLayout());

		layoutConst = new GridBagConstraints();
		layoutConst.gridx = 0;
		layoutConst.gridy = 0;
		layoutConst.insets = new Insets(10, 10, 10, 10);
		add(masterFile, layoutConst);

		layoutConst = new GridBagConstraints();
		layoutConst.gridx = 1;
		layoutConst.gridy = 0;
		layoutConst.insets = new Insets(10, 10, 10, 10);
		add(masterLocation, layoutConst);

		layoutConst = new GridBagConstraints();
		layoutConst.gridx = 0;
		layoutConst.gridy = 1;
		layoutConst.insets = new Insets(10, 10, 10, 10);
		add(vendorFile, layoutConst);

		layoutConst = new GridBagConstraints();
		layoutConst.gridx = 1;
		layoutConst.gridy = 1;
		layoutConst.insets = new Insets(10, 10, 10, 10);
		add(vendorLocation, layoutConst);

		layoutConst = new GridBagConstraints();
		layoutConst.gridx = 0;
		layoutConst.gridy = 2;
		layoutConst.insets = new Insets(10, 10, 10, 10);
		add(outputFile, layoutConst);

		layoutConst = new GridBagConstraints();
		layoutConst.gridx = 1;
		layoutConst.gridy = 2;
		layoutConst.insets = new Insets(10, 10, 10, 10);
		add(outputLocation, layoutConst);

		layoutConst = new GridBagConstraints();
		layoutConst.gridx = 0;
		layoutConst.gridy = 3;
		layoutConst.insets = new Insets(10, 10, 10, 10);
		add(run, layoutConst);

		layoutConst = new GridBagConstraints();
		layoutConst.gridx = 1;
		layoutConst.gridy = 3;
		layoutConst.insets = new Insets(10, 10, 10, 10);
		add(runProduct, layoutConst);
	}

	/**
	 * Generates UI that allows user to enter program to update his current
	 * inventory sheet with another sheet both in a .xlsx file format
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		Excel masterAction = new Excel();

		masterAction.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		masterAction.pack();
		masterAction.setVisible(true);

	}

}