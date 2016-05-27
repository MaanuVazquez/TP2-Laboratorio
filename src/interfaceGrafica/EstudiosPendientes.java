package interfaceGrafica;

import org.eclipse.swt.widgets.Dialog;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.List;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Label;

public class EstudiosPendientes extends Dialog {

	protected Object result;
	protected Shell shell;
	private boolean paciente;

	/**
	 * Create the dialog.
	 * @param parent
	 * @param style
	 */
	public EstudiosPendientes(Shell parent, int style, boolean paciente) {
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
		
		List list = new List(shell, SWT.BORDER);
		list.setBounds(10, 42, 99, 111);
			list.add("Estudio1");
			list.add("Estudio2");
			list.add("Estudio3");
			list.add("Estudio4");
		
		Button btnIngresarResultado = new Button(shell, SWT.NONE);
		btnIngresarResultado.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				new InsgresarResultadoDelEstudio(new Shell(), getStyle()).open();
			}
		});
		btnIngresarResultado.setBounds(10, 159, 117, 38);
		btnIngresarResultado.setText("Ingresar Resultado");
		
		Button btnCerrar = new Button(shell, SWT.NONE);
		btnCerrar.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				shell.close();
			}
		});
		btnCerrar.setBounds(359, 10, 75, 25);
		btnCerrar.setText("cerrar");
		
		Label lblPacienteOEstudio = new Label(shell, SWT.NONE);
		lblPacienteOEstudio.setBounds(10, 10, 164, 15);
		if(paciente){
			lblPacienteOEstudio.setText("Nombre Del Paciente");
		} else {
			lblPacienteOEstudio.setText("Nombre Del Estudio");
		}
	}
}
