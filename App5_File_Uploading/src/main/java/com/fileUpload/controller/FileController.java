package com.fileUpload.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.fileUpload.helper.FileUploadHelper;

@RestController
public class FileController {

	@Autowired
	private FileUploadHelper helper;
	
	@PostMapping("upload-file")
	public ResponseEntity<String> uploadFile(@RequestParam("file") MultipartFile file )
	{
//		System.out.println(file.getOriginalFilename());
//		System.out.println(file.getSize());
//		System.out.println(file.getResource());
//		System.out.println(file.getName());
//		System.out.println(file.getContentType());
		
		
		try {
			
			if(file.isEmpty())
			{
				return new ResponseEntity<>("Request must contain file !",HttpStatus.INTERNAL_SERVER_ERROR);
			}
			
			
			if(!file.getContentType().equals("image/jpeg"))
			{
				return new ResponseEntity<>("Only JPEG file required !",HttpStatus.INTERNAL_SERVER_ERROR);
			}
			
			
			//file upload ------resources/static/image or dynamically in target file so that it can dynamically deploy
			
			boolean ans=helper.uploadFile(file);
			if(ans)
			{
               //return new ResponseEntity<>("File is successfully uploaded !",HttpStatus.OK);
				
				return new ResponseEntity<>(ServletUriComponentsBuilder.fromCurrentContextPath().path("/image/").path(file.getOriginalFilename()).toUriString(),HttpStatus.OK);
			}
			
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
		
		
		return new ResponseEntity<>("Something went wrong! please try again!",HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
