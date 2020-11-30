package org.kg.myapp.file.model.dao;

import org.kg.myapp.file.model.vo.FileVO;

public interface IFileService {

	void uploadFile(FileVO file);
	FileVO getFile(int fileId);
}
