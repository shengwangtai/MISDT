package org.eclipsercp.integration.view;

import java.util.HashMap;
import java.util.List;

import javax.lang.model.element.UnknownElementException;

import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.IToolBarManager;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.part.ViewPart;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.eclipse.ui.views.properties.IPropertySheetPage;
import org.eclipse.ui.views.properties.tabbed.ITabbedPropertySheetPageContributor;
import org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetPage;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.swt.graphics.Image;
import org.eclipse.jface.viewers.ViewerSorter;
import org.eclipsercp.integration.common.IImageKeys;
import org.eclipsercp.integration.intro.Application;
import org.eclipsercp.integration.model.ITree;
import org.eclipsercp.integration.model.Interface;
import org.eclipsercp.integration.model.Message;
import org.eclipsercp.integration.model.Operation;
import org.eclipsercp.integration.model.Service;
import org.eclipsercp.integration.model.TreeFactory;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.wb.swt.SWTResourceManager;

public class InterfaceTreeView extends ViewPart implements ITabbedPropertySheetPageContributor{
	private static class Sorter extends ViewerSorter {
		public int compare(Viewer viewer, Object e1, Object e2) {
			Object item1 = e1;
			Object item2 = e2;
			return 0;
		}
	}
	
	private static class ViewerLabelProvider extends LabelProvider {
		//use map to store and get image and its descriptor
		private HashMap<ImageDescriptor, Image> imageCache = new HashMap<ImageDescriptor, Image>(20);
		public Image getImage(Object element) {
			ImageDescriptor descriptor = null;
			if (element instanceof Service) {
				descriptor = AbstractUIPlugin.imageDescriptorFromPlugin(Application.ID, IImageKeys.SERVICE);
			}
			else if (element instanceof Interface) {
				descriptor = AbstractUIPlugin.imageDescriptorFromPlugin(Application.ID, IImageKeys.INTERFACE);
			}
			else if (element instanceof Operation) {
				descriptor = AbstractUIPlugin.imageDescriptorFromPlugin(Application.ID, IImageKeys.OPERATION);
			}
			else if (element instanceof Message) {
				if (((Message) element).getIsInMsg()== true) {
					descriptor = AbstractUIPlugin.imageDescriptorFromPlugin(Application.ID, IImageKeys.INMSG);					
				}
				else {
					descriptor = AbstractUIPlugin.imageDescriptorFromPlugin(Application.ID, IImageKeys.OUTMSG);
				}				
			}
			else {
				throw unknownElement(element);
			}
			
			//obtain the cached image corresponding to the description
			Image image = (Image) imageCache.get(descriptor);
			if (image == null) {
				image = descriptor.createImage();
				imageCache.put(descriptor, image);
			}
			return image;
		}
		
		protected RuntimeException unknownElement(Object element) {
			return new RuntimeException("Unkonwn type of element in the interface tree"+element.getClass().getName());
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
		Tree tree = treeViewer.getTree();
		tree.setFont(SWTResourceManager.getFont("Î¢ÈíÑÅºÚ", 10, SWT.NORMAL));
		//ContainerCheckedTreeViewer treeViewer = new ContainerCheckedTreeViewer(parent,SWT.BORDER|SWT.H_SCROLL);
		treeViewer.setSorter(new Sorter());
		//Tree tree = treeViewer.getTree();
		treeViewer.setLabelProvider(new ViewerLabelProvider());
		treeViewer.setContentProvider(new TreeContentProvider());
        treeViewer.setInput(TreeFactory.createTree());
        getSite().setSelectionProvider(treeViewer);
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

	@Override
	public String getContributorId() {
		// TODO Auto-generated method stub		
		return getSite().getId();
	}
	
	public Object getAdapter(Class type){
        if (type == IPropertySheetPage.class) {
            return new TabbedPropertySheetPage(this);
          }  
         return super.getAdapter(type);
	}
}
