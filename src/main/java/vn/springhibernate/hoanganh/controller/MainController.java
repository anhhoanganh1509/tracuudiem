package vn.springhibernate.hoanganh.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import vn.springhibernate.hoanganh.model.Diem;
import vn.springhibernate.hoanganh.model.MonHoc;
import vn.springhibernate.hoanganh.model.SinhVien;
import vn.springhibernate.hoanganh.model.ViewStudent;
import vn.springhibernate.hoanganh.service.MonHocService;
import vn.springhibernate.hoanganh.service.UserService;

@Controller
public class MainController {
	
	@Autowired
	private UserService uService;

	@Autowired
	private MonHocService mService;
	
	@RequestMapping(value = {"/","login"}, method = RequestMethod.GET)
	public String login(@RequestParam(value = "error", required = false) String error,
			@RequestParam(value = "logout", required = false) String logout, Model model) {
		if (error != null) {
			model.addAttribute("error", "Invalid username and password!");
		}
		if (logout != null) {
			model.addAttribute("msg", "You've been logged out successfully.");
		}
		return "login";
	}
	
	@RequestMapping(value="jsp/index")
	public String adminPages(Authentication au, Model model) {
		try {
			if(uService.finbyUserId(au.getName()).getDaxoa() == 1) {
				SinhVien sv = uService.finbyStudent(au.getName());
				model.addAttribute("infoStudent", sv);
				String msv = sv.getMasinhvien().trim();
				List<ViewStudent> vStudent = mService.finbyViewStudent(msv);
				model.addAttribute("infoMonHoc", vStudent);
				return "jsp/index";
			}else if(uService.finbyUserId(au.getName()).getDaxoa() == 2){
				List<MonHoc> mh = mService.finbyMonHocList();
				model.addAttribute("finbyMonHocList",mh);
				model.addAttribute("popupAddNewMonHoc",new MonHoc());
				model.addAttribute("popupCapNhatDiem",new Diem());
				model.addAttribute("popupAddNewSinhVien",new ViewStudent());
				model.addAttribute("admin","admin");
				model.addAttribute("mamonhocChoose","");
				model.addAttribute("hockyChoose","");
				model.addAttribute("namhocChoose","");
				return "jsp/admin";	
			}else {
				return "jsp/changePass";	
			}
		}catch(Exception e) {
			
		}
		return null;				
	}

	@RequestMapping(value="jsp/formSubmitViewStudent", method = RequestMethod.POST)
	public String formSubmitViewStudent(Authentication au, Model model, @RequestParam(value = "mamonhoc", defaultValue = "") String mamonhoc,
			@RequestParam(value = "hocky", defaultValue = "") String hocky, @RequestParam(value = "namhoc", defaultValue = "") String namhoc) {	
		try { 
			List<MonHoc> mh = mService.finbyMonHocList();
			model.addAttribute("finbyMonHocList",mh);
			List<ViewStudent> mhList = mService.finbyViewMonHocList(mamonhoc, hocky, namhoc);
			model.addAttribute("finbyViewMonHocList",mhList);
			model.addAttribute("popupAddNewMonHoc",new MonHoc());
			model.addAttribute("popupCapNhatDiem",new Diem());
			model.addAttribute("popupAddNewSinhVien",new ViewStudent());
			model.addAttribute("admin","admin");
			model.addAttribute("mamonhocChoose",mamonhoc);
			model.addAttribute("hockyChoose",hocky);
			model.addAttribute("namhocChoose",namhoc);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return "jsp/admin";			
	}

	@RequestMapping(value="jsp/popupAddNewMonHoc", method = RequestMethod.POST)
	public String popupAddNewMonHoc(Authentication au, Model model,@ModelAttribute("popupAddNewMonHoc") MonHoc m,
			@RequestParam(value = "hockyChoose", defaultValue = "") String hocky, @RequestParam(value = "namhocChoose", defaultValue = "") String namhoc,
			@RequestParam(value = "mamonhocChoose", defaultValue = "") String mamonhoc) {	
		try {
			mService.popupAddNewMonHoc(m, au);
		}catch(Exception e) {
			e.printStackTrace(); 
		}
		List<MonHoc> mh = mService.finbyMonHocList();
		model.addAttribute("finbyMonHocList",mh);
		model.addAttribute("popupAddNewMonHoc",new MonHoc());
		model.addAttribute("popupCapNhatDiem",new Diem());
		model.addAttribute("popupAddNewSinhVien",new ViewStudent());
		model.addAttribute("mamonhocChoose",mamonhoc);
		model.addAttribute("hockyChoose",hocky);
		model.addAttribute("namhocChoose",namhoc);
		model.addAttribute("admin","admin");
		model.addAttribute("adminChooseReadyAction","admin");
		model.addAttribute("mamonhocChooseReadyAction",mamonhoc);
		model.addAttribute("hockyChooseReadyActionAction",hocky); 
		model.addAttribute("namhocChooseReadyActionAction",namhoc);
		return "jsp/admin";						
	}

	@RequestMapping(value="jsp/popupAddNewSinhVien", method = RequestMethod.POST)
	public String popupAddNewSinhVien(Authentication au, Model model, @ModelAttribute("popupAddNewSinhVien") ViewStudent sv,
			@RequestParam(value = "hockyChoose", defaultValue = "") String hocky, @RequestParam(value = "namhocChoose", defaultValue = "") String namhoc,
			@RequestParam(value = "mamonhocChoose", defaultValue = "") String mamonhoc, @RequestParam(value = "ngaysinhNew", defaultValue = "") String ngaysinhNew) {		
		try {
			uService.popupAddNewSinhVien(sv, au, ngaysinhNew);
		}catch(Exception e) {
			e.printStackTrace();
		}
		List<MonHoc> mh = mService.finbyMonHocList();
		model.addAttribute("finbyMonHocList",mh);
		model.addAttribute("popupAddNewMonHoc",new MonHoc());
		model.addAttribute("popupCapNhatDiem",new Diem());
		model.addAttribute("popupAddNewSinhVien",new ViewStudent());
		model.addAttribute("mamonhocChoose",mamonhoc);
		model.addAttribute("hockyChoose",hocky);
		model.addAttribute("namhocChoose",namhoc);
		model.addAttribute("admin","admin");
		model.addAttribute("adminChooseReadyAction","admin");
		model.addAttribute("mamonhocChooseReadyAction",mamonhoc);
		model.addAttribute("hockyChooseReadyActionAction",hocky);
		model.addAttribute("namhocChooseReadyActionAction",namhoc);
		return "jsp/admin";						
	}

	@RequestMapping(value="jsp/popupImportStudent", method = RequestMethod.POST)
	public String popupImportStudent(Authentication au, Model model, @ModelAttribute("popupAddNewSinhVien") ViewStudent sv,
			@RequestParam(value = "hockyChoose", defaultValue = "") String hocky, @RequestParam(value = "namhocChoose", defaultValue = "") String namhoc,
			@RequestParam CommonsMultipartFile fileUpload,
			@RequestParam(value = "mamonhocChoose", defaultValue = "") String mamonhoc) {		
		try {  
			uService.myFunctionDeleteSinhVien(fileUpload, sv);
		}catch(Exception e) {
			e.printStackTrace();
		}
		List<MonHoc> mh = mService.finbyMonHocList();
		model.addAttribute("finbyMonHocList",mh);
		model.addAttribute("popupAddNewMonHoc",new MonHoc());
		model.addAttribute("popupCapNhatDiem",new Diem());
		model.addAttribute("popupAddNewSinhVien",new ViewStudent());
		model.addAttribute("mamonhocChoose",mamonhoc);
		model.addAttribute("hockyChoose",hocky);
		model.addAttribute("namhocChoose",namhoc);
		model.addAttribute("admin","admin");
		model.addAttribute("adminChooseReadyAction","admin");
		model.addAttribute("mamonhocChooseReadyAction",mamonhoc);
		model.addAttribute("hockyChooseReadyActionAction",hocky);
		model.addAttribute("namhocChooseReadyActionAction",namhoc);
		return "jsp/admin";						
	}
	@RequestMapping(value = "jsp/popupCapNhatDiem", method = RequestMethod.POST)
    public String popupCapNhatDiem(Authentication au, Model model, @ModelAttribute("popupCapNhatDiem") Diem d,
    		@RequestParam(value = "mamonhoc", defaultValue = "") String mamonhoc, @RequestParam(value = "masinhvien", defaultValue = "") String masinhvien,
    		@RequestParam(value = "hocky", defaultValue = "") String hocky, @RequestParam(value = "namhoc", defaultValue = "") String namhoc){					
		try {
			if(uService.finbyUserId(au.getName()).getDaxoa() == 2) {
				mService.popupCapNhatDiem(d, mamonhoc, masinhvien);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		List<MonHoc> mh = mService.finbyMonHocList();
		model.addAttribute("finbyMonHocList",mh);
		model.addAttribute("popupAddNewMonHoc",new MonHoc());
		model.addAttribute("popupCapNhatDiem",new Diem());
		model.addAttribute("popupAddNewSinhVien",new ViewStudent());
		model.addAttribute("mamonhocChoose",mamonhoc);
		model.addAttribute("hockyChoose",hocky);
		model.addAttribute("namhocChoose",namhoc);
		model.addAttribute("admin","admin");
		model.addAttribute("adminChooseReadyAction","admin");
		model.addAttribute("mamonhocChooseReadyAction",mamonhoc);
		model.addAttribute("hockyChooseReadyActionAction",hocky);
		model.addAttribute("namhocChooseReadyActionAction",namhoc);
		return "jsp/admin";		
    }

	@RequestMapping(value = "jsp/myFunctionDelete", method = RequestMethod.POST)
    public String myFunctionDelete(Authentication au, Model model, @RequestParam(value = "myFunctionDelete", defaultValue = "") String myFunctionDelete,
    		@RequestParam(value = "mamonhoc", defaultValue = "") String mamonhoc, 
    		@RequestParam(value = "hocky", defaultValue = "") String hocky, @RequestParam(value = "namhoc", defaultValue = "") String namhoc){					
		
		try {
			if(uService.finbyUserId(au.getName()).getDaxoa() == 2) {
				uService.myFunctionDelete(myFunctionDelete);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		List<MonHoc> mh = mService.finbyMonHocList();
		model.addAttribute("finbyMonHocList",mh);
		model.addAttribute("popupAddNewMonHoc",new MonHoc());
		model.addAttribute("popupCapNhatDiem",new Diem());
		model.addAttribute("popupAddNewSinhVien",new ViewStudent());
		model.addAttribute("mamonhocChoose",mamonhoc);
		model.addAttribute("hockyChoose",hocky);
		model.addAttribute("namhocChoose",namhoc);
		model.addAttribute("admin","admin");
		model.addAttribute("adminChooseReadyAction","admin");
		model.addAttribute("mamonhocChooseReadyAction",mamonhoc);
		model.addAttribute("hockyChooseReadyActionAction",hocky);
		model.addAttribute("namhocChooseReadyActionAction",namhoc);
		return "jsp/admin";			
    }
	
	@RequestMapping(value = "/jsp/changePass", method = RequestMethod.POST)
    public String ChangePass(){			
        return "jsp/changePass";
    }

	@RequestMapping(value = "/jsp/changePassword", method = RequestMethod.POST)
    public String ChangePassword(@RequestParam(value = "newPass", defaultValue = "") String newPass, Authentication au,
    		@RequestParam(value = "repeatPass", defaultValue = "") String repeatPass, Model model){		
		try {
			if(newPass.equals(repeatPass) && newPass != null) {
				uService.UpdatePass(newPass, au.getName());
		        return "redirect:/jsp/index";
			}else {
				model.addAttribute("error", "Invalid email or student number!");
		        return "jsp/changePass";
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return null;
    }
	
}
