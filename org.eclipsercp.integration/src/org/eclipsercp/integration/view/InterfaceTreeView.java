package org.eclipsercp.integration.view;

import java.util.List;

import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.IToolBarManager;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.part.ViewPart;
import org.eclipse.swt.widgets.Table;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.swt.graphics.Image;
import org.eclipse.jface.viewers.ViewerSorter;
import org.eclipsercp.integration.model.ITree;
import org.eclipsercp.integration.model.TreeFactory;

public class InterfaceTreeView extends ViewPart {
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
	public static final String ID = "org.eclipsercp.integration.view.InterfaceTreeView"; //$NON-NLS-1$

	public InterfaceTreeView() {
	}

	/**
	 * Create contents of the view part.
	 * @param parent
	 */
	@Override
	public void createPartControl(Composite parent) {
		
		TreeViewer treeViewer = new TreeViewer(parent, SWT.BORDER);
		treeViewer.setSorter(new Sorter());
		Tree tree = treeViewer.getTree();
		treeViewer.setLabelProvider(new ViewerLabelProvider());
		treeViewer.setContentProvider(new TreeContentProvider());
        treeViewer.setInput(TreeFactory.createTree());
		createActions();
		initializeToolBar();
		initializeMenu();
	}

	/**
	 * Create the actions.
	 */
	private void createActions() {
		// Create the actions
	}

	/**
	 * Initialize the toolbar.
	 */
	private void initializeToolBar() {
		IToolBarManager toolbarManager = getViewSite().getActionBars()
				.getToolBarManager();
	}

	/**
	 * Initialize the menu.
	 */
	private void initializeMenu() {
		IMenuManager menuManager = getViewSite().getActionBars()
				.getMenuManager();
	}

	@Override
	public void setFocus() {
		// Set the focus
	}
}
