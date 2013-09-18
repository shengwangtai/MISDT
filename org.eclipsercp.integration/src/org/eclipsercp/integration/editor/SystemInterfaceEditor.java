package org.eclipsercp.integration.editor;

import java.util.List;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorSite;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.part.EditorPart;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.swt.graphics.Image;
import org.eclipse.jface.viewers.ViewerSorter;
import org.eclipsercp.integration.model.ITree;
import org.eclipsercp.integration.model.TreeFactory;

public class SystemInterfaceEditor extends EditorPart {
	private static class Sorter extends ViewerSorter {
		public int compare(Viewer viewer, Object e1, Object e2) {
			Object item1 = e1;
			Object item2 = e2;
			return 0;
		}
	}
	private static class ViewerLabelProvider extends LabelProvider {
		public Image getImage(Object element) {
			return null;
		}
		public String getText(Object element) {
			ITree node = (ITree)element;
			return node.getName();
		}
	}
	private static class TreeContentProvider implements ITreeContentProvider {
		public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
		}
		public void dispose() {
		}
		public Object[] getElements(Object inputElement) {
			if (inputElement instanceof List) {
				List input = (List)inputElement;
				return input.toArray();
			}
			return new Object[0];
		}
		
		public Object[] getChildren(Object parentElement) {
			ITree node = (ITree)parentElement;
			List list = node.getChildren();
			if (list == null) {
				return new Object[0];				
			}
			return list.toArray();
		}
		
		public Object getParent(Object element) {
			return null;
		}
		public boolean hasChildren(Object element) {
			ITree node = (ITree)element;
			List list = node.getChildren();
			return !(list == null || list.isEmpty());
		}
	}

	public static final String ID = "org.eclipsercp.integration.editor.SystemInterfaceEditor"; //$NON-NLS-1$

	public SystemInterfaceEditor() {
	}

	/**
	 * Create contents of the editor part.
	 * @param parent
	 */
	@Override
	public void createPartControl(Composite parent) {
		Composite container = new Composite(parent, SWT.NONE);
		
		TreeViewer treeViewer = new TreeViewer(container, SWT.BORDER);
		treeViewer.setSorter(new Sorter());
		Tree tree = treeViewer.getTree();
		tree.setBounds(0, 0, 594, 473);
		treeViewer.setLabelProvider(new ViewerLabelProvider());
		treeViewer.setContentProvider(new TreeContentProvider());
		treeViewer.setInput(TreeFactory.createTree());

	}

	@Override
	public void setFocus() {
		// Set the focus
	}

	@Override
	public void doSave(IProgressMonitor monitor) {
		// Do the Save operation
	}

	@Override
	public void doSaveAs() {
		// Do the Save As operation
	}

	@Override
	public void init(IEditorSite site, IEditorInput input)
			throws PartInitException {
		// Initialize the editor part
		setSite(site);
		
	}

	@Override
	public boolean isDirty() {
		return false;
	}

	@Override
	public boolean isSaveAsAllowed() {
		return false;
	}
}
