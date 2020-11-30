package org.kg.myapp.file.model.dao;

import org.kg.myapp.file.model.vo.FileVO;

public interface IFileRepository {

	int getMaxFileId();
	void uploadFile(FileVO file);
	FileVO getFile(int fileId);
	
	
}
