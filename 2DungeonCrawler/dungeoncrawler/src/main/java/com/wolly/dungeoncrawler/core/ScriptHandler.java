package com.wolly.dungeoncrawler.core;

import org.python.util.PythonInterpreter;
import org.springframework.beans.factory.config.BeanDefinition;

import com.wolly.dungeoncrawler.Config;
import com.wolly.dungeoncrawler.ScriptModule;
import com.wolly.dungeoncrawler.Utils;

public class ScriptHandler {
	private static ScriptHandler _instance;
	private PythonInterpreter _interpreter;
	
	private ScriptHandler() {
		init();
		executeImports();
	}
	
	private void init() {
		PythonInterpreter.initialize(System.getProperties(), System.getProperties(), null);
		_interpreter = new PythonInterpreter();
	}
	
	private void executeImports() {
		for(BeanDefinition bd : Utils.GetClassesByAnnotation(Config.BasePackage, ScriptModule.class, false)) {
			String fullPackagePath = bd.getBeanClassName();
			String className = Utils.GetClassNameFromFullPackagePath(fullPackagePath);
			String packagePath = Utils.GetPackagePathFromFullPackagePath(fullPackagePath);
			
			if (className != "" && packagePath != "") {
				_interpreter.exec("from " + packagePath + " import " + className);
			}
		}
	}
	
	public PythonInterpreter GetInterpreter() {
		return _interpreter;
	}
	
	public static ScriptHandler GetInstance() {
		if (_instance == null) {
			_instance = new ScriptHandler();
		}
		return _instance;
	}
	
}
