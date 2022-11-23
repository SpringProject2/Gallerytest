package vo;

import org.springframework.web.multipart.MultipartFile;

public class GalleryVO {
	private int galleryCommentStep, galleryCommentRef, galleryContentRef, galleryFolderDepth, galleryFolderStep, galleryFolderRef, galleryLike;
	private String galleryTopCategory, galleryMiddleCategory, galleryContent, galleryRegdate, galleryCommentRegdate, galleryCommentContent, GalleryCommentName, galleryFileName;
	
	//파일을 받기위한 클래스
	private MultipartFile galleryFile;
	
	public String getGalleryCommentName() {
		return GalleryCommentName;
	}

	public void setGalleryCommentName(String galleryCommentName) {
		GalleryCommentName = galleryCommentName;
	}

	public String getGalleryFileName() {
		return galleryFileName;
	}

	public void setGalleryFileName(String galleryFileName) {
		this.galleryFileName = galleryFileName;
	}

	public MultipartFile getGalleryFile() {
		return galleryFile;
	}

	public void setGalleryFile(MultipartFile galleryFile) {
		this.galleryFile = galleryFile;
	}

	public int getGalleryCommentStep() {
		return galleryCommentStep;
	}

	public void setGalleryCommentStep(int galleryCommentStep) {
		this.galleryCommentStep = galleryCommentStep;
	}

	public int getGalleryCommentRef() {
		return galleryCommentRef;
	}

	public void setGalleryCommentRef(int galleryCommentRef) {
		this.galleryCommentRef = galleryCommentRef;
	}

	public int getGalleryContentRef() {
		return galleryContentRef;
	}

	public void setGalleryContentRef(int galleryContentRef) {
		this.galleryContentRef = galleryContentRef;
	}

	public int getGalleryFolderDepth() {
		return galleryFolderDepth;
	}

	public void setGalleryFolderDepth(int galleryFolderDepth) {
		this.galleryFolderDepth = galleryFolderDepth;
	}

	public int getGalleryFolderStep() {
		return galleryFolderStep;
	}

	public void setGalleryFolderStep(int galleryFolderStep) {
		this.galleryFolderStep = galleryFolderStep;
	}

	public int getGalleryFolderRef() {
		return galleryFolderRef;
	}

	public void setGalleryFolderRef(int galleryFolderRef) {
		this.galleryFolderRef = galleryFolderRef;
	}

	public int getGalleryLike() {
		return galleryLike;
	}

	public void setGalleryLike(int galleryLike) {
		this.galleryLike = galleryLike;
	}

	public String getGalleryTopCategory() {
		return galleryTopCategory;
	}

	public void setGalleryTopCategory(String galleryTopCategory) {
		this.galleryTopCategory = galleryTopCategory;
	}

	public String getGalleryMiddleCategory() {
		return galleryMiddleCategory;
	}

	public void setGalleryMiddleCategory(String galleryMiddleCategory) {
		this.galleryMiddleCategory = galleryMiddleCategory;
	}

	public String getGalleryContent() {
		return galleryContent;
	}

	public void setGalleryContent(String galleryContent) {
		this.galleryContent = galleryContent;
	}

	public String getGalleryRegdate() {
		return galleryRegdate;
	}

	public void setGalleryRegdate(String galleryRegdate) {
		this.galleryRegdate = galleryRegdate;
	}

	public String getGalleryCommentRegdate() {
		return galleryCommentRegdate;
	}

	public void setGalleryCommentRegdate(String galleryCommentRegdate) {
		this.galleryCommentRegdate = galleryCommentRegdate;
	}

	public String getGalleryCommentContent() {
		return galleryCommentContent;
	}

	public void setGalleryCommentContent(String galleryCommentContent) {
		this.galleryCommentContent = galleryCommentContent;
	}


	
	
}
