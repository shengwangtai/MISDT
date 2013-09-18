package org.eclipsercp.dialog;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CTabFolder;
import org.eclipse.swt.custom.SashForm;
import org.eclipse.swt.custom.CCombo;
import org.eclipse.swt.widgets.TabFolder;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.TabItem;
import org.eclipse.swt.custom.CTabItem;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.swt.widgets.TreeColumn;
import org.eclipse.swt.custom.TableTree;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.wb.swt.layout.grouplayout.GroupLayout;

public class SetHL7Interface {

	protected Shell shlInterfaceProperties;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			SetHL7Interface window = new SetHL7Interface();
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
		shlInterfaceProperties.open();
		shlInterfaceProperties.layout();
		while (!shlInterfaceProperties.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		shlInterfaceProperties = new Shell();
		shlInterfaceProperties.setSize(475, 601);
		shlInterfaceProperties.setText("\u6570\u636E\u5B9A\u4E49");
		
		Label lblNewLabel = new Label(shlInterfaceProperties, SWT.NONE);
		lblNewLabel.setBounds(10, 23, 55, 17);
		lblNewLabel.setText("\u5B9E\u73B0\u7C7B\u578B");
		
		SashForm sashForm = new SashForm(shlInterfaceProperties, SWT.NONE);
		sashForm.setBounds(189, 52, 0, 0);
		
		CCombo combo = new CCombo(shlInterfaceProperties, SWT.BORDER);
		combo.setItems(new String[] {"HL7", "Web Service", "Database"});
		combo.setBounds(85, 23, 88, 21);
		
		CTabFolder tabFolder = new CTabFolder(shlInterfaceProperties, SWT.BORDER);
		tabFolder.setBounds(10, 58, 437, 495);
		tabFolder.setSelectionBackground(Display.getCurrent().getSystemColor(SWT.COLOR_TITLE_INACTIVE_BACKGROUND_GRADIENT));
		
		CTabItem tbtmHl = new CTabItem(tabFolder, SWT.NONE);
		tbtmHl.setText("HL7");
		
		CTabItem tabItem = new CTabItem(tabFolder, SWT.NONE);
		tabItem.setText("New Item");
		
		Composite composite = new Composite(tabFolder, SWT.NONE);
		tabItem.setControl(composite);
		
		Label lblNewLabel_1 = new Label(composite, SWT.NONE);
		lblNewLabel_1.setText("\u89D2\u8272");
		
		Button btnRadioButton = new Button(composite, SWT.RADIO);
		btnRadioButton.setText("\u53D1\u9001\u8005");
		
		Button btnRadioButton_1 = new Button(composite, SWT.RADIO);
		btnRadioButton_1.setText("\u63A5\u6536\u8005");
		
		Label lblNewLabel_2 = new Label(composite, SWT.NONE);
		lblNewLabel_2.setText("\u7248\u672C");
		
		Combo combo_1 = new Combo(composite, SWT.NONE);
		combo_1.setItems(new String[] {"2.3", "2.4", "2.5"});
		
		Label label = new Label(composite, SWT.NONE);
		label.setText("\u6D88\u606F\u7C7B\u578B");
		
		Combo combo_2 = new Combo(composite, SWT.NONE);
		combo_2.setItems(new String[] {"\u60A3\u8005\u7BA1\u7406", "\u533B\u5631\u5F55\u5165", "\u67E5\u8BE2", "\u8D22\u52A1\u7BA1\u7406", "\u89C2\u5BDF\u62A5\u544A", "\u4E3B\u6587\u4EF6", "\u75C5\u5386\u8BB0\u5F55", "\u65E5\u7A0B\u5B89\u6392", "\u60A3\u8005\u8F6C\u8BCA", "\u60A3\u8005\u62A4\u7406", "\u4E34\u5E8A\u5B9E\u9A8C\u5BA4\u81EA\u52A8\u5316", "\u5E94\u7528\u7BA1\u7406", "\u4EBA\u4E8B\u7BA1\u7406"});
		
		Label lblNewLabel_3 = new Label(composite, SWT.NONE);
		lblNewLabel_3.setText("\u65B9\u9762");
		
		Combo combo_3 = new Combo(composite, SWT.NONE);
		combo_3.setItems(new String[] {"ADT", "QRY", "QBP"});
		
		Label label_1 = new Label(composite, SWT.NONE);
		label_1.setText("\u6D88\u606F");
		
		Label label_2 = new Label(composite, SWT.NONE);
		label_2.setText("\u89E6\u53D1\u4E8B\u4EF6");
		
		Combo combo_4 = new Combo(composite, SWT.NONE);
		combo_4.setItems(new String[] {"A01", "A02", "A03", "A04", "A05"});
		
		Tree tree = new Tree(composite, SWT.BORDER);
		GroupLayout gl_composite = new GroupLayout(composite);
		gl_composite.setHorizontalGroup(
			gl_composite.createParallelGroup(GroupLayout.LEADING)
				.add(gl_composite.createSequentialGroup()
					.add(gl_composite.createParallelGroup(GroupLayout.LEADING)
						.add(gl_composite.createSequentialGroup()
							.add(23)
							.add(gl_composite.createParallelGroup(GroupLayout.LEADING)
								.add(gl_composite.createSequentialGroup()
									.add(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 61, GroupLayout.PREFERRED_SIZE)
									.add(38)
									.add(btnRadioButton, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE)
									.add(19)
									.add(btnRadioButton_1, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE))
								.add(gl_composite.createSequentialGroup()
									.add(lblNewLabel_2, GroupLayout.PREFERRED_SIZE, 61, GroupLayout.PREFERRED_SIZE)
									.add(38)
									.add(combo_1, GroupLayout.PREFERRED_SIZE, 88, GroupLayout.PREFERRED_SIZE))
								.add(gl_composite.createSequentialGroup()
									.add(label, GroupLayout.PREFERRED_SIZE, 61, GroupLayout.PREFERRED_SIZE)
									.add(38)
									.add(combo_2, GroupLayout.PREFERRED_SIZE, 88, GroupLayout.PREFERRED_SIZE)
									.add(6)
									.add(lblNewLabel_3, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
									.add(18)
									.add(combo_3, GroupLayout.PREFERRED_SIZE, 88, GroupLayout.PREFERRED_SIZE)
									.add(6)
									.add(label_1, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE))
								.add(gl_composite.createSequentialGroup()
									.add(label_2, GroupLayout.PREFERRED_SIZE, 61, GroupLayout.PREFERRED_SIZE)
									.add(38)
									.add(combo_4, GroupLayout.PREFERRED_SIZE, 88, GroupLayout.PREFERRED_SIZE))))
						.add(gl_composite.createSequentialGroup()
							.add(18)
							.add(tree, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(33, Short.MAX_VALUE))
		);
		gl_composite.setVerticalGroup(
			gl_composite.createParallelGroup(GroupLayout.LEADING)
				.add(gl_composite.createSequentialGroup()
					.add(29)
					.add(gl_composite.createParallelGroup(GroupLayout.LEADING)
						.add(lblNewLabel_1)
						.add(btnRadioButton)
						.add(btnRadioButton_1))
					.add(11)
					.add(gl_composite.createParallelGroup(GroupLayout.LEADING)
						.add(gl_composite.createSequentialGroup()
							.add(3)
							.add(lblNewLabel_2))
						.add(combo_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.add(6)
					.add(gl_composite.createParallelGroup(GroupLayout.LEADING)
						.add(gl_composite.createSequentialGroup()
							.add(3)
							.add(label))
						.add(combo_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.add(gl_composite.createSequentialGroup()
							.add(5)
							.add(lblNewLabel_3))
						.add(gl_composite.createSequentialGroup()
							.add(2)
							.add(combo_3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.add(gl_composite.createSequentialGroup()
							.add(5)
							.add(label_1)))
					.add(5)
					.add(gl_composite.createParallelGroup(GroupLayout.LEADING)
						.add(gl_composite.createSequentialGroup()
							.add(3)
							.add(label_2))
						.add(combo_4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.add(22)
					.add(tree, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(216, Short.MAX_VALUE))
		);
		composite.setLayout(gl_composite);

	}
}
