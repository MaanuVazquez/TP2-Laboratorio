package interfaceGrafica;

import org.eclipse.swt.widgets.Dialog;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

public class IngresarResultado extends Dialog {

	protected Object result;
	protected Shell shell;

	/**
	 * Create the dialog.
	 * @param parent
	 * @param style
	 */
	public IngresarResultado(Shell parent, int style) {
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
		
		Button btnPaciente = new Button(shell, SWT.NONE);
		btnPaciente.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				shell.close();
				new IngresarNombreOId(new Shell(), 0, true).open();
			}
		});
		btnPaciente.setBounds(10, 10, 214, 65);
		btnPaciente.setText("Ingresar Resultado Por Paciente");
		
		Button btnEstudio = new Button(shell, SWT.NONE);
		btnEstudio.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				shell.close();
				new IngresarNombreOId(new Shell(), 0, false).open();
			}
		});
		btnEstudio.setBounds(10, 147, 214, 89);
		btnEstudio.setText("Ingresar Resultado Por Estudio");
	}

}
