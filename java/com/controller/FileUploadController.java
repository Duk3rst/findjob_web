package com.controller;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class FileUploadController {
  
    @RequestMapping(value = "/uploadfile",method = RequestMethod.POST)
    @ResponseBody
    public String fileUpload(@RequestParam("file")
               MultipartFile file, HttpSession s,
               Model mod)
    {
    String filePath = "C:\\Users\\Admin\\eclipse-workspace\\PRJ321_ASM02\\src\\main\\webapp\\WEB-INF\\uploads";
    	System.out.println(filePath);
    	try {
    		file.transferTo(Paths.get(filePath, StringUtils.cleanPath(file.getOriginalFilename())));
//			file.transferTo(Paths.get(filePath, file.getOriginalFilename()));
		} catch (IllegalStateException | IOException e) {
			e.printStackTrace();
		}
  
        // Getting bytes of file and
        // storing it in a byte array
//        byte[] data = file.getBytes();
        
//        String filePath
//            = s.getServletContext().getRealPath("/")
//              + "WEB-INF" + File.separator + "resources"
//              + File.separator + "image" + File.separator
//              + file.getOriginalFilename();
  
        // Try block to check for exceptions
//        try {
//            // Creating an object of FileOutputStream class
//            FileOutputStream fileout = new FileOutputStream(filePath);
//            fileout.write(data);
//  
//            // Closing connections of file
//            // using close() method
//            fileout.close();
//            mod.addAttribute("imgName",file.getOriginalFilename());
//        }
//        // Catch block to handle the exceptions
//        catch (Exception e) {
//            e.printStackTrace();
//        }
  
    	return file.getOriginalFilename();
    }   
    
}
            
            
            
            