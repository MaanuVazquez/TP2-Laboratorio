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

public class IngresarNombreOId extends Dialog {

	protected Object result;
	protected Shell shell;
	private Text IdPaciente;
	private boolean paciente;

	/**
	 * Create the dialog.
	 * @param parent
	 * @param style
	 */
	public IngresarNombreOId(Shell parent, int style, boolean paciente) {
		super(parent, style);
		setText("SWT Dialog");
		this.paciente = paciente;
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
		
		Label lblId = new Label(shell, SWT.NONE);
		lblId.setBounds(10, 10, 200, 28);
		if(paciente){
			lblId.setText("Ingresar Id Del Paciente");
		}else {
			lblId.setText("Ingresar nombre del estudio");
		}
		IdPaciente = new Text(shell, SWT.BORDER);
		IdPaciente.setBounds(10, 44, 125, 28);
		
		Button btnIngresarResultados = new Button(shell, SWT.NONE);
		btnIngresarResultados.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				shell.close();
				new EstudiosPendientes(new Shell(), 0, paciente).open();
			}
		});
		btnIngresarResultados.setBounds(10, 78, 113, 44);
		btnIngresarResultados.setText("Continuar");

	}
}
