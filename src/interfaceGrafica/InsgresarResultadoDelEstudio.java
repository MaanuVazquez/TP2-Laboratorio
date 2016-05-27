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

public class InsgresarResultadoDelEstudio extends Dialog {

	protected Object result;
	protected Shell shell;
	private Text textResultadoIngresado;

	/**
	 * Create the dialog.
	 * @param parent
	 * @param style
	 */
	public InsgresarResultadoDelEstudio(Shell parent, int style) {
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
		
		Label lblNombreDelEstudio = new Label(shell, SWT.NONE);
		lblNombreDelEstudio.setBounds(10, 10, 185, 15);
		lblNombreDelEstudio.setText("Nombre Del Estudio Seleccionado");
		
		Label lblIngresarresultado = new Label(shell, SWT.NONE);
		lblIngresarresultado.setBounds(10, 56, 103, 15);
		lblIngresarresultado.setText("IngresarResultado");
		
		textResultadoIngresado = new Text(shell, SWT.BORDER);
		textResultadoIngresado.setBounds(10, 87, 137, 21);
		
		Button btnAceptar = new Button(shell, SWT.NONE);
		btnAceptar.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				shell.close();
			}
		});
		btnAceptar.setBounds(10, 124, 75, 25);
		btnAceptar.setText("Aceptar");

	}

}
