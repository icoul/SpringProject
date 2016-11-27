package com.spring.common;

import java.io.File;
import java.util.Calendar;

import org.springframework.stereotype.Repository;

import net.coobird.thumbnailator.Thumbnails;

@Repository
public class ThumbnailManager {
	
	public String doCreateThumbnail(String fileName, String path) throws Exception {
		
		String thumbnailFileName = null;
		// 섬네일 파일 이름
		
		if (fileName == null) {
			return null;
		}// 파일명이 null이면 종료시킴
		
		String fileExt = fileName.substring(fileName.lastIndexOf(",")); // 파일 확장자 가져오기
		
		if (fileExt == null || fileExt.trim().equals("")) {
			return null;
		} // 확장자가 null인지 확인
		
		// 서버에 저장할 새로운 thumbnailFileName 파일명을 만든다.
		thumbnailFileName = String.format("%1$tY%1$tm%1$td%1$tH%1$tM%1$tS", 
				                          Calendar.getInstance());
		thumbnailFileName += System.nanoTime();
		thumbnailFileName += fileExt;
		
		// 섬네일 저장될 경로 생성
		File dir = new File(path);
		if (!dir.exists()) {
			dir.mkdirs();
		}
		
		// 파일경로생성
		String pathFilename = path + File.separator + fileName;
		String pathThumbnailname = path + File.separator + thumbnailFileName;
		
		File image = new File(pathFilename);
		File thumbnail = new File(pathThumbnailname);
		
		if (image.exists()) {
			Thumbnails.of(image).size(100, 100).toFile(thumbnail);
		}
		
		return thumbnailFileName;
	}
}
