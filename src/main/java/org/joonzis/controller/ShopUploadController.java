package org.joonzis.controller;

import java.io.File;
import java.net.URLDecoder;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.annotation.MultipartConfig;

import org.joonzis.domain.ReviewAttachVO;
import org.joonzis.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import lombok.extern.log4j.Log4j;

@Log4j
@Controller
@RequestMapping("/shopUpload")
public class ShopUploadController {
	
	@Autowired
	ReviewService service;
	
	@GetMapping("/uploadForm")
	public String uploadForm() {
		log.info("upload form..");
		return "uploadForm";
	}
	
	// 동기 방식 파일 업로드
	@PostMapping("/uploadFormAction")
	public void uploadFormPost(MultipartFile[] uploadFile, Model model) {
		for(MultipartFile multipartFile : uploadFile) {
			log.info("-------------------");
			log.info("Upload File Name : " + multipartFile.getOriginalFilename() );
			log.info("Upload File Size : " + multipartFile.getSize() );
		}
	}
	
	@GetMapping("/uploadAsync")
	public String uploadAsync() {
		log.info("upload Async");
		return "uploadAsync";
	}
	
	// 비동기 방식 파일 업로드
	@ResponseBody
	@PostMapping(value =  "/uploadAsyncAction", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<ReviewAttachVO> uploadAsyncPost(@RequestParam("uploadFile") MultipartFile uploadFile, Model model) {
		
		ReviewAttachVO ravo = new ReviewAttachVO();
		
		log.info("upload Async post...");
		
		String uploadFolder = "C:\\dev\\workspace\\workSpace_spring\\project_paperGround\\src\\main\\webapp\\resources\\images";
		
		// make folder --------------
		File uploadPath = new File(uploadFolder);
		log.info("uploadPath : " + uploadPath);
		
		if(!uploadPath.exists()) {
			// make directory
			uploadPath.mkdirs();
		}
		
			log.info("-------------------");
			log.info("Upload File Name : " + uploadFile.getOriginalFilename() );
			log.info("Upload File Size : " + uploadFile.getSize() );
			
			String uploadFileName = uploadFile.getOriginalFilename();
			
			log.info("이전 file name : " + uploadFileName);
			uploadFileName = uploadFileName.substring(uploadFileName.lastIndexOf("\\") + 1);
			log.info("only file name : " + uploadFileName);
			
			UUID uuid = UUID.randomUUID();
			uploadFileName = uuid.toString() + "_" + uploadFileName;
			
			log.warn("비동기 업로드 컨트롤러 uuid : " + uuid);
			try {
				File saveFile = new File(uploadPath, uploadFileName);
				uploadFile.transferTo(saveFile);
				
				ravo.setReviewimguuid(uuid.toString());
				ravo.setReviewimgpath("");
				ravo.setReviewimgname(uploadFile.getOriginalFilename());
			} catch (Exception e) {
				log.error(e.getMessage());
			}
			
			log.warn("비동기 업로드 컨트롤러 ravo.uuid.." + ravo.getReviewimguuid());
			

			return new ResponseEntity<ReviewAttachVO>(ravo, HttpStatus.OK);
	
	}
	
//	// 파일 다운로드
//	@GetMapping(value = "/download", produces = MediaType.APPLICATION_OCTET_STREAM_VALUE)
//	@ResponseBody
//	public ResponseEntity<Resource> downloadFile(String fileName){
//		
//		log.info("download file ... " + fileName);
//		Resource resource = new FileSystemResource("C:\\upload\\" + fileName);
//		
//		log.info("resource : " + resource);
//		
//		String resourceName = resource.getFilename();
//		HttpHeaders headers = new HttpHeaders();
//		
//		try {
//			headers.add("Content-Disposition", "attach; fileName=" + new String(resourceName.getBytes("utf-8"), "ISO-8859-1"));
//		} catch (Exception e) {
//			log.error(e.getMessage());
//		}
//		
//		return new ResponseEntity<Resource>(resource, headers, HttpStatus.OK);
//	}
	
	@PostMapping("/deleteFile")
	@ResponseBody
	public ResponseEntity<String> deleteFile(@RequestBody String fileName){
		
		log.info("delete File : " + fileName);
		
		File file = null;
		
		try {
			file = new File("C:\\upload\\" + URLDecoder.decode(fileName, "utf-8"));
			log.info("파일 삭제 로직 성공시 : " + file); 
			file.delete();
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<String>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<String>("deleted", HttpStatus.OK);
	}
	
//	@PostMapping("/deleteMFile")
//	@ResponseBody
//	public ResponseEntity<String> deleteFile(@RequestBody List<Map<String, String>> fileDataList) {
//	    for (Map<String, String> fileData : fileDataList) {
//	        String uuid = fileData.get("uuid");
//	        String fileName = fileData.get("fileName");
//	        String fileCallPath = fileData.get("fileCallPath");
//
//	        log.info("아타치삭제야..." + uuid + ", 아타치이름..." + fileName + ", 파일 삭제 경로..." + fileCallPath);
//
//	        service.attachDelete(uuid); 
//
//	        // 파일 삭제 로직
//	        File file = null;
//	        
//	        try {
//				file = new File("C:\\upload\\" + URLDecoder.decode(fileCallPath, "utf-8"));
//				log.info("파일 삭제 로직.." + fileCallPath);
//				file.delete();
//			} catch (Exception e) {
//				e.printStackTrace();
//				return new ResponseEntity<String>(HttpStatus.NOT_FOUND);
//			}
//	    }
//	    return new ResponseEntity<String>("deleted", HttpStatus.OK);
//	}



	
	// 오늘 날짜 경로를 문자열로 생성
	private String getFolder() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date date = new Date();
		String str = sdf.format(date);
		// "-" 을 "/" 로 바꾸겠다.
		return str.replace("-", File.separator);
	}
}
