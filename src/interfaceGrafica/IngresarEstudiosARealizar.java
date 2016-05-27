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

public class IngresarEstudiosARealizar extends Dialog {

	protected Object result;
	protected Shell shell;
	private Text text;
	private boolean paciente;

	/**
	 * Create the dialog.
	 * @param parent
	 * @param style
	 */
	public IngresarEstudiosARealizar(Shell parent, int style, boolean paciente) {
		super(parent, style);
		this.paciente = paciente;
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
		
		Label lblNombreDelPaciente = new Label(shell, SWT.NONE);
		lblNombreDelPaciente.setBounds(10, 10, 200, 15);
		if(paciente){
			lblNombreDelPaciente.setText("Nombre del paciente");
		} else {
			lblNombreDelPaciente.setText("Nombre del GrupoDeEstudios");
		}
		Label lblIngresarTipoDe = new Label(shell, SWT.NONE);
		lblIngresarTipoDe.setBounds(10, 59, 193, 15);
		lblIngresarTipoDe.setText("Ingresar tipo de estudio a realizar");
		
		text = new Text(shell, SWT.BORDER);
		text.setBounds(10, 80, 138, 21);
		
		Button btnIngresarAnalisis = new Button(shell, SWT.NONE);
		btnIngresarAnalisis.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				new IngresarAnalisis(shell, 0).open();
			}
		});
		btnIngresarAnalisis.setBounds(10, 107, 193, 25);
		btnIngresarAnalisis.setText("Ingresar Analisis");
		
		Button btnIngresarEstudio = new Button(shell, SWT.NONE);
		btnIngresarEstudio.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				new IngresarEstudio(shell, 0).open();
			}
		});
		btnIngresarEstudio.setBounds(10, 138, 193, 25);
		btnIngresarEstudio.setText("Ingresar Estudio");
		
		Button btnIngresarGrupoDe = new Button(shell, SWT.NONE);
		btnIngresarGrupoDe.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				new IngresarEstudiosARealizar(shell, 0, false).open();
			}
		});
		btnIngresarGrupoDe.setBounds(10, 169, 193, 25);
		btnIngresarGrupoDe.setText("Ingresar Grupo de Estudios");
		
		Button btnFinalizar = new Button(shell, SWT.NONE);
		btnFinalizar.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				shell.close();
			}
		});
		btnFinalizar.setBounds(359, 237, 75, 25);
		btnFinalizar.setText("Finalizar");

	}

}
