package com.korea.cyworld;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import dao.GalleryDAO;
import util.Comm;
import vo.GalleryVO;

@Controller
public class CyworldController {

	@Autowired
	ServletContext app;// 현재 프로젝트의 기본정보들을 저장하고 있는 클래스

	@Autowired
	HttpServletRequest request;

	GalleryDAO gallery_dao;

	public void setGallery_dao(GalleryDAO gallery_dao) {
		this.gallery_dao = gallery_dao;
	}

	// 사진첩 조회
	@RequestMapping(value = { "/", "/list.do" })
	public String list(Model model) {

		List<GalleryVO> list = gallery_dao.selectList();
		model.addAttribute("list", list);// 바인딩 : jsp까지 정보운반
		return Comm.VIEW_PATH + "gallery_list.jsp";// 포워딩

	}

	@RequestMapping("/insert_form.do")
	public String insert_form() {
		return Comm.VIEW_PATH + "gallery_insert_form.jsp";
	}

	//////////////////////////
	// 새 글쓰기
	@RequestMapping("/insert.do")
	// public String insert(String name, String content, String pwd) {
	public String insert(GalleryVO vo) {

		// 클라이언트의 파일 업로드를 위한 절대경로를 생성
		String webPath = "/resources/upload/";
		String savePath = app.getRealPath(webPath);// 절대경로
		System.out.println("경로 : " + savePath);

		// 업로드를 위해 파라미터로 넘어온 사진의 정보

		  MultipartFile galleryFile = vo.getGalleryFile();
		  String galleryFileName = "no_file";
		//업로드 된 파일이 존재할 때!!
			if(!galleryFile.isEmpty()) {
				//업로드가 된 실제 파일의 이름
				galleryFileName = galleryFile.getOriginalFilename();
				
				//이미지를 저장할 경로를 지정
				File saveFile = new File(savePath, galleryFileName);
				
				if(!saveFile.exists()) {
					saveFile.mkdirs();
				}else {
					
					//동일파일명 변경
					long time = System.currentTimeMillis();
					galleryFileName = String.format("%d_%s", time, galleryFileName);
					saveFile = new File(savePath, galleryFileName);
					
				}
				
				try {
					//업로드를 위한 파일을 실제로 등록해주는 메서드
					galleryFile.transferTo(saveFile);
				} catch (IllegalStateException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
			
			vo.setGalleryFileName(galleryFileName);
			
			//DB에 새 글을 추가하기 위해 DAO에게 vo를 전달
			int res = gallery_dao.insert(vo);
			
	        //redirect: view로 이동하는 것이 아닌, 컨트롤러의 url매핑을 호출하기 위한 키워드
			return "redirect:list.do";
		}

	// 게시글 삭제
	@RequestMapping("/delete.do")
	@ResponseBody // Ajax로 요청된 메서드는 결과를 콜백메서드로 돌려주기 위해 반드시 @ResponseBody가 필요!!
	public String delete(int galleryContentRef) {
		// delete.do?idx=1
		int res = gallery_dao.delete(galleryContentRef);

		String result = "no";
		if (res == 1) {
			result = "yes";
		}

		// yes, no값을 가지고 콜백메서드(resultFn)로 돌아간다
		// 콜백으로 리턴되는 값은 영문으로 보내준다
		return result;
	}

	// 글 수정 폼으로 전환
	@RequestMapping("/modify_form.do")
	public String modify_form(Model model, int galleryContentRef) {
		// modify_form.do?idx=2&pwd=1111&c_pwd=1111
		GalleryVO vo = gallery_dao.selectOne(galleryContentRef);

		if (vo != null) {
			model.addAttribute("vo", vo);
		}

		return Comm.VIEW_PATH + "gallery_modify_form.jsp";

	}

	// 게시글 수정하기
	@RequestMapping("/modify.do")
	@ResponseBody
	public String modify(GalleryVO vo) {
		
		String webPath = "/resources/upload/";
		String savePath = app.getRealPath(webPath);// 절대경로
		System.out.println("경로 : " + savePath);

		// 업로드를 위해 파라미터로 넘어온 사진의 정보
		System.out.println(vo.getGalleryFile());
		  MultipartFile galleryFile = vo.getGalleryFile();
		  String galleryFileName = "no_file";
		  System.out.println("1");
		//업로드 된 파일이 존재할 때!!
			if(!galleryFile.isEmpty()) {
				//업로드가 된 실제 파일의 이름
				galleryFileName = galleryFile.getOriginalFilename();
				
				//이미지를 저장할 경로를 지정
				File saveFile = new File(savePath, galleryFileName);
				
				if(!saveFile.exists()) {
					saveFile.mkdirs();
				}else {
					
					//동일파일명 변경
					long time = System.currentTimeMillis();
					galleryFileName = String.format("%d_%s", time, galleryFileName);
					saveFile = new File(savePath, galleryFileName);
					
				}
				
				try {
					//업로드를 위한 파일을 실제로 등록해주는 메서드
					galleryFile.transferTo(saveFile);
				} catch (IllegalStateException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
			
			vo.setGalleryFileName(galleryFileName);
			
			System.out.println("2");
		
		int res = gallery_dao.update(vo);

		String result = "{'result':'no'}";
		if (res != 0) {
			result = "{'result':'yes'}";
		}

		return result;
	}

}
