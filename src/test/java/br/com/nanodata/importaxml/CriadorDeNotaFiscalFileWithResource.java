package br.com.nanodata.importaxml;

import java.io.FileInputStream;
import java.net.URL;

import org.springframework.core.io.ResourceLoader;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.web.multipart.MultipartFile;

public class CriadorDeNotaFiscalFileWithResource {

	public MultipartFile getNfFile() throws Exception {
		ClassLoader classLoader = ResourceLoader.class.getClassLoader();;
		var fileName = "nfe-teste01.xml";
		URL resource = classLoader.getResource(fileName );
		FileInputStream inputStream = new FileInputStream(resource.getFile());
		return new MockMultipartFile(fileName, inputStream);
	}

}
