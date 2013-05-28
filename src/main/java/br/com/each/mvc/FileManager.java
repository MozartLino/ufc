package br.com.each.mvc;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.commons.io.IOUtils;

import br.com.caelum.vraptor.interceptor.multipart.UploadedFile;
import br.com.caelum.vraptor.ioc.Component;

@Component
public class FileManager {

	private final static String FOLDER = System.getProperty("user.home")
			+ File.separator + "banco_de_dados";

	public void upload(UploadedFile uploadedFile, String local) {
		try {
			IOUtils.copy(uploadedFile.getFile(), new FileOutputStream(new File(
					FOLDER + File.separator + local)));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public File download(String local) {
		return new File(FOLDER + File.separator + local);
	}

}
