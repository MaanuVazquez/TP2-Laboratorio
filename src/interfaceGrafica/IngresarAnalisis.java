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

public class IngresarAnalisis extends Dialog {

	protected Object result;
	protected Shell shell;
	private Text text;
	private Text text_1;
	private Text text_2;

	/**
	 * Create the dialog.
	 * @param parent
	 * @param style
	 */
	public IngresarAnalisis(Shell parent, int style) {
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
		lblNombreDelEstudio.setBounds(10, 10, 159, 15);
		lblNombreDelEstudio.setText("Nombre del Analisis");
		
		Label lblValorNormalMinimo = new Label(shell, SWT.NONE);
		lblValorNormalMinimo.setBounds(10, 50, 159, 15);
		lblValorNormalMinimo.setText("Ingresar ValorNormalMinimo");
		
		text = new Text(shell, SWT.BORDER);
		text.setBounds(10, 71, 159, 21);
		
		Label lblIngresarValornormalMaximo = new Label(shell, SWT.NONE);
		lblIngresarValornormalMaximo.setBounds(10, 98, 159, 15);
		lblIngresarValornormalMaximo.setText("Ingresar ValorNormal Maximo");
		
		text_1 = new Text(shell, SWT.BORDER);
		text_1.setBounds(10, 119, 159, 21);
		
		Label lblIngresarIndicaciones = new Label(shell, SWT.NONE);
		lblIngresarIndicaciones.setBounds(10, 146, 159, 15);
		lblIngresarIndicaciones.setText("Ingresar Indicaciones");
		
		text_2 = new Text(shell, SWT.BORDER);
		text_2.setBounds(10, 167, 159, 95);
		
		Button btnIngresarEstudio = new Button(shell, SWT.NONE);
		btnIngresarEstudio.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				shell.close();
			}
		});
		btnIngresarEstudio.setBounds(309, 237, 125, 25);
		btnIngresarEstudio.setText("Ingresar Analisis");

	}

}
