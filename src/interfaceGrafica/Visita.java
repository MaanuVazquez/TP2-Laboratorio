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

public class Visita extends Dialog {

	protected Object result;
	protected Shell shell;
	private Text text;

	/**
	 * Create the dialog.
	 * @param parent
	 * @param style
	 */
	public Visita(Shell parent, int style) {
		super(parent, style);
		setText("SWT Dialog");
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
		
		Label lblIdDelPaciente = new Label(shell, SWT.NONE);
		lblIdDelPaciente.setBounds(10, 10, 99, 15);
		lblIdDelPaciente.setText("Id Del Paciente");
		
		text = new Text(shell, SWT.BORDER);
		text.setBounds(10, 31, 117, 21);
		
		Button btnContinuar = new Button(shell, SWT.NONE);
		btnContinuar.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				shell.close();
				new IngresarEstudiosARealizar(new Shell(), 0, true).open();
			}
		});
		btnContinuar.setBounds(10, 58, 75, 25);
		btnContinuar.setText("Continuar");

		final Label lblNuevoPaciente = new Label(shell, SWT.NONE);
		lblNuevoPaciente.setBounds(10, 99, 200, 15);
		
		Button btnNuevoPaciente = new Button(shell, SWT.NONE);
		btnNuevoPaciente.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				new CrearNuevoPaciente(shell, 0, lblNuevoPaciente).open();
			}
		});
		btnNuevoPaciente.setBounds(324, 10, 110, 25);
		btnNuevoPaciente.setText("Nuevo Paciente");
		

	}

}
