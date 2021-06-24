package com.climax.customerreporting.ServiceImpl;

import java.io.File;

import org.apache.commons.io.FilenameUtils;

import com.climax.customerreporting.services.FileImportManager;

public class FileManagerServiceImpl implements FileImportManager {

	@Override
	public String getFileExentision(File file) {
		// TODO Auto-generated method stub
		return FilenameUtils.getExtension(file.getAbsolutePath());
	}

}
