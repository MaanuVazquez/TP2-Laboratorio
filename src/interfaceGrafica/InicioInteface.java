package interfaceGrafica;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

public class InicioInteface {

	protected Shell shell;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			InicioInteface window = new InicioInteface();
			window.open();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Open the window.
	 */
	public void open() {
		Display display = Display.getDefault();
		createContents();
		shell.open();
		shell.layout();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		shell = new Shell();
		shell.setToolTipText("setResult");
		shell.setSize(450, 300);
		shell.setText("Laboratorio");
		
		Button btnIngresarResultado = new Button(shell, SWT.NONE);
		btnIngresarResultado.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				new IngresarResultado(shell, 0).open();
			}
		});
		btnIngresarResultado.setToolTipText("");
		btnIngresarResultado.setBounds(10, 31, 134, 25);
		btnIngresarResultado.setText("Ingresar Resultado");
		
		Button btnVisita = new Button(shell, SWT.NONE);
		btnVisita.setToolTipText("");
		btnVisita.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				new Visita(shell, 0).open();
			}
		});
		btnVisita.setBounds(259, 31, 165, 25);
		btnVisita.setText("Iniciar Visita");

	}
	
}
