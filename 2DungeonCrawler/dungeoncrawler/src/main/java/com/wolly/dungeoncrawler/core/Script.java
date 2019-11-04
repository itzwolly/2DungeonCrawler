package com.wolly.dungeoncrawler.core;

import java.io.File;

import org.apache.commons.io.FilenameUtils;
import org.python.core.PyInstance;
import org.python.core.PyObject;

public class Script {
	private final String _filePath;
	private final GameObject _owner;
	private final File _file;
	private PyInstance _pyInstance;
	
	public Script(final String pFilePath, final GameObject pOwner) {
		_filePath = pFilePath;
		_owner = pOwner;
		_file = new File(_filePath);
		
		ScriptHandler.GetInstance().GetInterpreter().execfile(_filePath);
	}
	
	public void __init__() {
		_pyInstance = (PyInstance) ScriptHandler.GetInstance().GetInterpreter().get(GetFileNameWithoutExtension()).__call__(_owner); // Creates a python instance of the designates python file.
	}
	
	public void callMethod(final String pMethod) {
		if (hasAttr(pMethod)) {
			_pyInstance.invoke(pMethod);
		}
	}
	
	public void callMethod(final String pMethod, PyObject pObject) {
		if (hasAttr(pMethod)) {
			_pyInstance.invoke(pMethod, pObject);
		}
	}
	
	public void callMethod(final String pMethod, PyObject... pObjects) {
		if (hasAttr(pMethod)) {
			_pyInstance.invoke(pMethod, pObjects);
		}
	}
	
	private boolean hasAttr(String pAttr) {
		if (_pyInstance == null) {
			return false;
		}
		return _pyInstance.__findattr__(pAttr) != null;
	}
	
	public final String GetFileNameWithoutExtension() {
		return FilenameUtils.removeExtension(GetFileNameWithExtension());
	}
	
	public final String GetFileNameWithExtension() {
		return _file.getName();
	}
	
	public final String GetFilePath() {
		return _filePath;
	}
	
	public final GameObject GetOwner() {
		return _owner;
	}
}
