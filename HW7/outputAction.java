import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFileChooser;

/**
 * Chooses the file location that would save the output file to
 * 
 * @author peter
 *
 */
public class outputAction implements ActionListener {

	public void actionPerformed(ActionEvent e) {
		JFileChooser fc = new JFileChooser();
		fc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
		int returnVal = fc.showSaveDialog(null);
		if (returnVal == JFileChooser.APPROVE_OPTION) {
			Excel.outputLocation
					.setText(fc.getSelectedFile().getAbsolutePath());
			Excel.outLocation = fc.getSelectedFile().getAbsolutePath();
		}
	}
}
