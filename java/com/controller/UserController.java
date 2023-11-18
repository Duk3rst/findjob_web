package com.controller;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.dto.UserDto;
import com.dto.recruitmentdDto;
import com.entity.ApplyPost;
import com.entity.Category;
import com.entity.Company;
import com.entity.Recruitment;
import com.entity.Role;
import com.entity.Save_job;
import com.entity.User;
import com.service.applypostService;
import com.service.categoryService;
import com.service.companyService;
import com.service.recruitmentService;
import com.service.roleService;
import com.service.savejobService;
import com.service.userService;
import com.util.AuthUtil;

@Controller
public class UserController {
	@Autowired
	private applypostService applypostservice;
	
	@Autowired
	private savejobService save_jobService;
	
	@Autowired
	private recruitmentService recruitmentService;
	
	@Autowired
	private companyService companyservice;
	
	@Autowired
	private categoryService categoryservice;
	
	@Autowired
	private roleService roleService;
	
	@Autowired
	private userService userService;

	@RequestMapping("/")
	public String homepage(Model model,HttpServletRequest request) {
		List<Category> categories= categoryservice.getCategories();
		model.addAttribute("category", categories);
		
		List<Company> companies = companyservice.getCompanies();
		model.addAttribute("companies",companies);
		
		List<Recruitment> recruitments = recruitmentService.geRecruitments();
		model.addAttribute("recruitment", recruitments);

		String logedInEmail = AuthUtil.getLogedInEmail();
		model.addAttribute("logedInEmail", logedInEmail);
		System.out.println("logedInEmail  : " + logedInEmail);
		HttpSession session = request.getSession();
		
		System.out.println(session);
		return "home";
	}
	
	@GetMapping("/login")
	public String userLogin(Model model) {
		return "login";
	}
//	@PostMapping("/dangnhap")
//	public String loginauth() {
//		return "redirect:/";
//	}
	
	@PostMapping("/register")
	public String adduser(@ModelAttribute UserDto userdto) {
		User newUser = new User();
		newUser.setEmail(userdto.getEmail());
		newUser.setFullname(userdto.getFullname());
		newUser.setPassword(new BCryptPasswordEncoder().encode(userdto.getPassword()));
		newUser.setStatus(1);
		Role role = roleService.getRole(userdto.getRole_id());
		newUser.setRole(role);
		userService.saveUser(newUser);
		return "redirect:/login";
	}
	
	@PostMapping("/apply-job")
	public String applyjob(@RequestParam("iduser") String idU,
			@RequestParam("idrec") String idr,
			@RequestParam("text11") String text, 
			@RequestParam("multipartFile") MultipartFile file){
//		@ModelAttribute applypostDTO applypostDTO){	
		
		 String filePath = "C:\\Users\\Admin\\eclipse-workspace\\PRJ321_ASM02\\src\\main\\webapp\\WEB-INF\\uploads";
		 Path fileNameString = Paths.get(filePath, StringUtils.cleanPath(file.getOriginalFilename()));
	    	try {
	    		file.transferTo(fileNameString);
			} catch (IllegalStateException | IOException e) {
				e.printStackTrace();
			}
		ApplyPost applypostN = new ApplyPost();
//		if(applypostN.getName_cv()==null) {	
		User user = userService.findByIdUser(Integer.valueOf(idU));
		applypostN.setUsers(user);	
		Recruitment recruitment = recruitmentService.findbyid(Integer.valueOf(idr));
		applypostN.setRecruitment(recruitment);
		applypostN.setText(text);
//		applypostN.setText(applypostDTO.getText());
		applypostN.setStatus(1);
		applypostN.setName_cv(fileNameString.toString());
		
		applypostservice.saveApplypost(applypostN);
		System.out.println("apply post successfully! ");
			
//		else {
//		applypostN.setStatus(1);
//		User user = userService.findByIdUser(Integer.valueOf(idU));
//		Recruitment recruitment = recruitmentService.findbyid(Integer.valueOf(idr));
//		applypostN.setText(text);
		
//		ap
//		}
		return "redirect:/";
		
	}
	
	@GetMapping("/detail-company/{company_id}")
	public String detailcom(@PathVariable int company_id,Model model) {
		Company companys = companyservice.findById(company_id);
		model.addAttribute("company", companys);
		
		return "detail-company";
	}
	
	@GetMapping("/recruitment")
	public String recruitmentss(Model model,HttpServletRequest request) {
		HttpSession session = request.getSession();
		List<Recruitment> recruitments = recruitmentService.geRecruitments();
		model.addAttribute("recruitment", recruitments);
		
		List <Company> companies = companyservice.getCompanies();
		model.addAttribute("companies", companies);
		
		System.out.println(session);
		return "recruitment";
	}
	
	@GetMapping("/recruitment/{category_id}")
	public String recruitments(@PathVariable int category_id,Model model) {
		Recruitment recruitments = recruitmentService.findbyid(category_id);
		model.addAttribute("recruitment", recruitments);
		
		return "recruitment";
	}
	
	@GetMapping("/detail-post/{recruitment_id}")
	public String detailposter(@PathVariable int recruitment_id,Model model) {
		Recruitment recruitments = recruitmentService.findbyid(recruitment_id);
		model.addAttribute("recruitment", recruitments);
		
		List<ApplyPost> applyPosts = applypostservice.applyPosts();
		model.addAttribute("applypost", applyPosts);
		return "detail-post";
	}
	
	@GetMapping("/edit-job/{recruitment_id}")
	public String edjtjobs(@PathVariable("recruitment_id") int recruitment_id,Model model) {
		List<Category> categories= categoryservice.getCategories();
		model.addAttribute("category", categories);
		
		Recruitment recruitment = recruitmentService.findbyid(recruitment_id);
		model.addAttribute("recruitment", recruitment);
		
		return "edit-job";
	}
	
	@GetMapping("/list-apply-jobs")
	public String listapjob(Model model) {
		List <Save_job> save_jobs = save_jobService.gsave_jobs();
		model.addAttribute("save_jobs", save_jobs);
		
		return "list-apply-job";
	}
	
	@PostMapping("/updateuser")
	public String upuser(@RequestParam ("idUser")int id,
			@RequestParam("email") String email,
			@RequestParam("fullname") String fullName,
			@RequestParam("address") String address,
			@RequestParam("phoneNumber") String phone,
			@RequestParam("description") String descript){
		
		userService.updateUser(id, email, fullName, address, phone, descript);
		return "redirect:/profile";
	}
	
	@PostMapping("/update-company")
	public String upcompa(HttpSession session,
			@RequestParam("email") String email,
			@RequestParam("name_company")String nameC,
			@RequestParam("address")String address,
			@RequestParam("phoneNumber")String phone,
			@RequestParam("description")String descript) {
		
		User currentUser = (User) session.getAttribute("user");
		if (currentUser == null) {
			throw new IllegalAccessError("User not login");
		}		
		Company company = currentUser.getCompany();
		companyservice.updatecompa(company, email, nameC, address, phone, descript);

		return "redirect:/profile";
	}
	
	@PostMapping("/updaterec")
	public String uprec(@RequestParam("idrec")int id,
			@RequestParam ("title")String title,
			@RequestParam("description")String descript,
			@RequestParam("experience")String exp,
			@RequestParam("quantity")int quantity,
			@RequestParam("address")String address,
			@RequestParam("deadline")String deadline,
			@RequestParam("salary")String salary,
			@RequestParam("category_id")int cat_id ) {
		
		recruitmentService.updaterec(id, title, descript, exp, quantity, address, deadline, salary, cat_id);
		return "redirect:/edit-job/"+id;
	}
	
	@PostMapping("/delrec")
	public String deleterec(@RequestParam("id")int id) {
		recruitmentService.delrec(id);
		
		return "redirect:/post-list";
	}
	@GetMapping("/list-follow-company")
	public String listfollowcompany(@RequestParam("company_id")int id,Model model) {
		List <Save_job> save_jobs = save_jobService.gsave_jobs();
		model.addAttribute("save_job", save_jobs);
		
		return "list-follow-company";
	}
	
	@GetMapping("/list-job")
	public String listjobs() {
		return "listjob";
	}
	
	@GetMapping("/list-re")
	public String listres() {
		return "list-re";
	}
	
	@GetMapping("/list-save-job")
	public String listsavejobs(Model model) {
		List <Save_job> save_jobs = save_jobService.gsave_jobs();
		model.addAttribute("savejob", save_jobs);
		
		return "list-save-job";
	}
	
	@GetMapping("/list-users")
	public String listusers(Model model) {
		List<ApplyPost> applyPosts = applypostservice.applyPosts();
		model.addAttribute("applypost", applyPosts);
		
		return "list-user";
	}
	
	@GetMapping("/post-company")
	public String postcampany(@RequestParam("company_id")int id,Model model) {
		List<Recruitment> recruitments = recruitmentService.geRecruitments();
		model.addAttribute("recruitment", recruitments);
		
		return "post-company";
	}
	
	@GetMapping("/post-job")
	public String postjobs(Model model,HttpServletRequest request) {
		List<Category> categories= categoryservice.getCategories();
		model.addAttribute("category", categories);
		
		return "post-job";
	}
	@PostMapping("/addrec")
	public String addrecruitment(@ModelAttribute recruitmentdDto recruitmentddto){
		Recruitment recruitment = new Recruitment();
		recruitment.setTittle(recruitmentddto.getTitle());
		recruitment.setDescript(recruitmentddto.getDescript());
		recruitment.setExperience(recruitmentddto.getExperience());
		recruitment.setQuantity(recruitmentddto.getQuantity());
		recruitment.setAddress(recruitmentddto.getAddress());
		recruitment.setDeadline(recruitmentddto.getDeadline());
		recruitment.setSalary(recruitmentddto.getSalary());
		recruitment.setStatus(1);//"1 la hoat dong , 0 la ngung hoat dong"
		Category category = categoryservice.findcatebyid(recruitmentddto.getCategory_id());
		recruitment.setCategory(category);		
		recruitmentService.saverec(recruitment);
		
		return "redirect:/post-job";
	}
	
	@GetMapping("/post-list")
	public String postlists(Model model) {
		List<Recruitment> recruitments = recruitmentService.geRecruitments();
		model.addAttribute("recruitment", recruitments);
		
		return "post-list";
	}
	
	@GetMapping("/profile")
	public String profiles() {
		
		return "profile";
	}
	
	
	@PostMapping("/result-searchs")
	public String resultsearch(@RequestParam("keySearch") String keyword,Model model) {
		List<Recruitment> recruitments = recruitmentService.seaList(keyword);
		model.addAttribute("recruitment", recruitments);
		
		return "result-search";
	}
	
	@PostMapping("/result-search-addresses")
	public String resultsearchaddress(@RequestParam("keySearchadr") String keyword,Model model) {
		List<Recruitment> recruitments = recruitmentService.seaList2(keyword);
		model.addAttribute("recruitment", recruitments);
		
		return "result-search-address";
	}
	
	@PostMapping("/result-search-users")
	public String resultsearchuser(@RequestParam("keySearchc") String keyword,Model model) {
		List<Company> companies = companyservice.seacomList(keyword);
		model.addAttribute("company", companies);
		
 		return "result-search-user";
	}
	
}
