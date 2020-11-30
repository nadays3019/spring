package org.kg.myapp.file.model.dao;

import org.kg.myapp.file.model.vo.FileVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FileService implements IFileService {


	@Autowired
	IFileRepository fileRepository;
	
	@Override
	public void uploadFile(FileVO file) {
		file.setFileId(fileRepository.getMaxFileId()+1);
		fileRepository.uploadFile(file);

	}

	@Override
	public FileVO getFile(int fileId) {
		
		return fileRepository.getFile(fileId);
	}

}
