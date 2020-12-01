package org.kg.myapp.file.model.dao;

import java.util.HashMap;
import java.util.List;

import org.kg.myapp.file.model.vo.FileVO;

public interface IFileRepository {

	int getMaxFileId();
	void uploadFile(FileVO file);
	FileVO getFile(int fileId);
	void deleteFile(int fileId);
	List<FileVO>getFileList(String directoryName);
	List<FileVO>getAllFileList();
	void updateDirectory(HashMap<String,Object>map);
	void updateFile(FileVO file);
	
	
	
}
