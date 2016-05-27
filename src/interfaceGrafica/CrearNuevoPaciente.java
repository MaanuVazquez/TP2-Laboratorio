package interfaceGrafica;

import org.eclipse.swt.widgets.Dialog;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

public class CrearNuevoPaciente extends Dialog {

	protected Object result;
	protected Shell shell;
	private Text text;
	private Text text_1;
	private Text text_2;
	private Text text_3;
	private Label label;

	/**
	 * Create the dialog.
	 * @param parent
	 * @param style
	 */
	public CrearNuevoPaciente(Shell parent, int style, Label label) {
		super(parent, style);
		setText("SWT Dialog");
		this.label = label;
	}

	/**
	 * Open the dialog.
	 * @return the result
	 */
	public Object open() {
		createContents();
		shell.open();
		shell.layout();
		Display display = getParent().getDisplay();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
		return result;
	}

	/**
	 * Create contents of the dialog.
	 */
	private void createContents() {
		shell = new Shell(getParent(), getStyle());
		shell.setSize(450, 300);
		shell.setText(getText());
		
		Label lblNombre = new Label(shell, SWT.NONE);
		lblNombre.setBounds(10, 10, 93, 15);
		lblNombre.setText("Nombre");
		
		text = new Text(shell, SWT.BORDER);
		text.setBounds(10, 31, 223, 21);
		
		Label lblDni = new Label(shell, SWT.NONE);
		lblDni.setBounds(10, 60, 55, 15);
		lblDni.setText("DNI");
		
		text_1 = new Text(shell, SWT.BORDER);
		text_1.setBounds(10, 81, 223, 21);
		
		Label lblTelefono = new Label(shell, SWT.NONE);
		lblTelefono.setBounds(10, 108, 55, 15);
		lblTelefono.setText("Telefono");
		
		text_2 = new Text(shell, SWT.BORDER);
		text_2.setBounds(10, 129, 223, 21);
		
		Label lblMail = new Label(shell, SWT.NONE);
		lblMail.setBounds(10, 156, 55, 15);
		lblMail.setText("Mail");
		
		text_3 = new Text(shell, SWT.BORDER);
		text_3.setBounds(10, 177, 223, 21);
		
		Button btnContinuar = new Button(shell, SWT.NONE);
		btnContinuar.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				label.setText("El Id del nuevo paciente es 123");
				shell.close();
			}
		});
		btnContinuar.setBounds(10, 204, 75, 25);
		btnContinuar.setText("Continuar");

	}

}
