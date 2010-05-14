package dicomux;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.util.Locale;

import javax.swing.JLabel;
import javax.swing.JPanel;

import org.dcm4che2.data.DicomObject;
import org.dcm4che2.data.Tag;

/**
 * This plug-in is for displaying patient specific data.
 * @author heidi
 *
 */
public class PatientDataPlugin extends APlugin {
	
	public PatientDataPlugin() throws Exception {
		super();
		m_keyTag.addKey(Tag.PatientName, null);
		m_keyTag.addKey(Tag.PatientSex, null);
		m_keyTag.addKey(Tag.PatientBirthDate, null);
	}
	
	@Override
	public String getName() {
		return "Patient Data";
	}
	
	// TODO extend a little bit :-)
	@Override
	public void setData(DicomObject dcm) throws Exception {
		JPanel content = new JPanel(new GridLayout(3, 2, 5, 5));
		content.add(new JLabel("Patient Name:"));
		content.add(new JLabel(dcm.getString(Tag.PatientName)));
		content.add(new JLabel("Patient Sex:"));
		content.add(new JLabel(dcm.getString(Tag.PatientSex)));
		content.add(new JLabel("Patient Birth Date:"));
		content.add(new JLabel(dcm.getDate(Tag.PatientBirthDate).toString()));
		
		m_content = new JPanel(new BorderLayout(5, 5));
		m_content.add(content, BorderLayout.NORTH);
	}
	
	// TODO implement localization
	@Override
	public void setLanguage(Locale locale) {
		
	}
}
