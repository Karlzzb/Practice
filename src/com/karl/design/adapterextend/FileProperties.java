package com.karl.design.adapterextend;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Properties;

public class FileProperties extends Properties implements FileIO {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7953785536002715887L;

	@Override
	public void readFromFile(String fileName) throws IOException {
		InputStream is = getClass().getResourceAsStream(fileName);
		this.load(is);
	}

	@Override
	public void writeToFile(String fileName) throws IOException {
		OutputStream out = new FileOutputStream(fileName);
		this.store(out, "written by " + getClass().getName());
		out.flush();
	}

	@Override
	public void setValue(String key, String value) {
		this.setProperty(key, value);
	}

	@Override
	public String getValue(String key) {
		return this.get(key).toString();
	}

}
