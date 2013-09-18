package org.eclipsercp.integration.intro;

import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.ui.actions.ActionFactory;
import org.eclipse.ui.actions.ActionFactory.IWorkbenchAction;
import org.eclipse.ui.application.ActionBarAdvisor;
import org.eclipse.ui.application.IActionBarConfigurer;
import org.eclipse.ui.operations.UndoActionHandler;
import org.eclipse.ui.IWorkbenchActionConstants;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipsercp.integration.action.NewProjectAction;

public class ApplicationActionBarAdvisor extends ActionBarAdvisor {
	private IWorkbenchAction newAction;
	private NewProjectAction newProjectAction;
	private IWorkbenchAction openAction;
	private IWorkbenchAction importAction;
	private IWorkbenchAction exportAction;
	private IWorkbenchAction exitAction;

	private IWorkbenchAction undoAction;
	private IWorkbenchAction redoAction;
	
	private IWorkbenchAction resetPerspectiveAction;
	
	private IWorkbenchAction aboutAction;
    
	public ApplicationActionBarAdvisor(IActionBarConfigurer configurer) {
		super(configurer);
	}

	protected void makeActions(IWorkbenchWindow window) {
		//file menGroup action
    	newProjectAction = new NewProjectAction();
    	register(newProjectAction);
		openAction = ActionFactory.OPEN_PERSPECTIVE_DIALOG.create(window);
		openAction.setText("打开文件");
		register(openAction);		
		importAction = ActionFactory.IMPORT.create(window);
		importAction.setText("导入...");
		register(importAction);		
		exportAction = ActionFactory.EXPORT.create(window);
		exportAction.setText("导出...");
		register(exportAction);		
    	exitAction = ActionFactory.QUIT.create(window);
    	exitAction.setText("退出");
    	register(exitAction);
    	
    	//edit menuGroup action
    	undoAction = ActionFactory.UNDO.create(window);
    	undoAction.setText("撤销");
    	register(undoAction);
    	redoAction = ActionFactory.REDO.create(window);
    	redoAction.setText("恢复");
    	register(redoAction);
    	
    	//windows menuGroup action
    	resetPerspectiveAction = ActionFactory.RESET_PERSPECTIVE.create(window);
    	resetPerspectiveAction.setText("重置");
    	register(resetPerspectiveAction);
    	
    	//help menuGroup action
	   	aboutAction = ActionFactory.ABOUT.create(window);
	   	aboutAction.setText("关于集成建模工具...");
    	register(aboutAction);
    	
	}

	protected void fillMenuBar(IMenuManager menuBar) {
		MenuManager fileMenu = new MenuManager("&File", "FILE");
		//MenuManager newProject = new MenuManager("&集成项目","NEW_PROJECT");
	    MenuManager editMeun = new MenuManager("&Edit",IWorkbenchActionConstants.M_EDIT);
	    MenuManager windowMenu = new MenuManager("&Window",IWorkbenchActionConstants.M_WINDOW);
		//MenuManager helpMenu = new MenuManager("&帮助", IWorkbenchActionConstants.M_HELP);
		fileMenu.add(newProjectAction);
		fileMenu.add(openAction);
		fileMenu.add(importAction);
		fileMenu.add(exportAction);
		fileMenu.add(exitAction);
		editMeun.add(undoAction);
		editMeun.add(redoAction);
		windowMenu.add(resetPerspectiveAction);
		//helpMenu.add(aboutAction);
		menuBar.add(fileMenu);
		menuBar.add(editMeun);
		menuBar.add(windowMenu);
		//menuBar.add(helpMenu);
	}
	
    protected void fillTrayItem(IMenuManager trayItem) {
    	trayItem.add(exitAction);
    	trayItem.add(aboutAction);		
	}

}
