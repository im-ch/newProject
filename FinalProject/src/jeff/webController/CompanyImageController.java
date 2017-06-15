package jeff.webController;

import java.io.File;
import java.io.IOException;
import java.sql.Date;
import java.util.Calendar;
import java.util.Iterator;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import jeff.domain.CompanyImage;
import jeff.service.CompanyImageService;
import jeff.util.ImageResize;

@RequestMapping("image")
@Controller
public class CompanyImageController {
	
	@Autowired
	private CompanyImageService service;
	private static final String filePath = "C:/Image/";
	
	@RequestMapping(value="regist", method=RequestMethod.POST)
	public String registImage(MultipartHttpServletRequest mreq){
		CompanyImage companyImage = new CompanyImage();
		Iterator<String> iterator = mreq.getFileNames();
		MultipartFile mf = null;
		HttpSession session = mreq.getSession();
		companyImage.setComId((String)session.getAttribute("comId"));
		
		File file = new File(mreq.getContextPath());
		if(file.exists() == false){
			file.mkdirs();
		}
		
		Date today = new Date(Calendar.getInstance().getTimeInMillis());
		while(iterator.hasNext()){
			mf = mreq.getFile(iterator.next());
			if(!mf.isEmpty()){
		         String reName= companyImage.getComId() + "_" + today.toString() + "_" + mf.getOriginalFilename();
		         companyImage.setFileName(reName);
		         companyImage.setContentType(mf.getContentType().substring(6));
		         
		         file = new File(filePath + companyImage.getFileName());
		         
		         try {
					mf.transferTo(file);
				} catch (IllegalStateException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}
		 }
	         
		}
		String originPath = filePath + companyImage.getFileName();
		try {
			ImageResize.resize(originPath, originPath, 500, 405);
		} catch (IOException e) {
			e.printStackTrace();
		}
		service.insertCompanyImage(companyImage);
          
          return "redirect:/company/detail";
	}
	
	@RequestMapping("delete")
	public String deleteImage(@RequestParam("companyImageId") String companyImageId){
		service.removeCompanyImage(Integer.parseInt(companyImageId));
		return "redirect:/company/detail";
	}

}
