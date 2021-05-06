package com.ssafy.product.controller;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.ssafy.product.dto.FileInfoDto;

import com.ssafy.product.dto.ProductDto;
import com.ssafy.product.service.ProductService;

@Controller
public class ProductController {
	
	
	private static final Logger logger = LoggerFactory.getLogger(ProductController.class);
	
	@Autowired
	private ProductService pservice;
	
	@Autowired
	ServletContext servletContext;
	
	
	@GetMapping("/add")
	public String add() {
		return "product/add";
	}
	
	@GetMapping("/list")
	public ModelAndView list() {
		List<ProductDto> pList = pservice.list();
		
		
		for (ProductDto productDto : pList) {
			System.out.println(productDto);
		}
		ModelAndView mav = new ModelAndView();
		mav.addObject("pList", pList);
		mav.setViewName("product/list");
		return mav;
	}
	
	@PostMapping("/add")
	public String add(ProductDto productDto,Model model ,@RequestParam("upfile") MultipartFile[] files) throws IllegalStateException, IOException {
		System.out.println(productDto);
		System.out.println(files[0]);
		
		if(!files[0].isEmpty()) {
			String realPath = servletContext.getRealPath("/upload");
			System.out.println(realPath);
//			String realPath = servletContext.getRealPath("/resources/img");
			String today = new SimpleDateFormat("yyMMdd").format(new Date());
			String saveFolder = realPath + File.separator + today;
			logger.debug("저장 폴더 : {}", saveFolder);
			File folder = new File(saveFolder);
			if(!folder.exists())
				folder.mkdirs();
			List<FileInfoDto> fileInfos = new ArrayList<FileInfoDto>();
			for (MultipartFile mfile : files) {
				FileInfoDto fileInfoDto = new FileInfoDto();
				String originalFileName = mfile.getOriginalFilename();
				if (!originalFileName.isEmpty()) {
					String saveFileName = UUID.randomUUID().toString() + originalFileName.substring(originalFileName.lastIndexOf('.'));
					fileInfoDto.setSaveFolder(today);
					fileInfoDto.setOriginFile(originalFileName);
					fileInfoDto.setSaveFile(saveFileName);
					logger.debug("원본 파일 이름 : {}, 실제 저장 파일 이름 : {}", mfile.getOriginalFilename(), saveFileName);
					mfile.transferTo(new File(folder, saveFileName));
				}
				fileInfos.add(fileInfoDto);
			}
			productDto.setFileInfos(fileInfos);
		}
		
		int result = pservice.add(productDto);
		if(result>0) {
			model.addAttribute("addSuccessMsg", "상품추가에 성공하였습니다.");
			return "product/function";
		}else {
			model.addAttribute("addfailMsg","상품추가에 실패하였습니다.");
			return "product/add";
		}
	}
	
	@RequestMapping(value="/download", method=RequestMethod.GET)
	public ModelAndView downloadFile(@RequestParam("sfolder") String sfolder, @RequestParam("ofile") String ofile, 
				@RequestParam("sfile") String sfile, HttpSession session) {
		
		
			Map<String, Object> fileInfo = new HashMap<String, Object>();
		    fileInfo.put("sfolder", sfolder);
		    fileInfo.put("ofile", ofile);
		    fileInfo.put("sfile", sfile);
		 
		    return new ModelAndView("fileDownLoadView", "downloadFile", fileInfo);

	}
	
	
	
	
	
	
	@GetMapping("/function")
	public String back() {
		return "product/function";
	}
	

}
