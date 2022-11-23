package dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import vo.GalleryVO;

public class GalleryDAO {
	
	SqlSession sqlSession; //Mapper접근
	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}
	
	//사진첩 전체목록 조회
	public List<GalleryVO> selectList(){
		List<GalleryVO> list = sqlSession.selectList("cw.gallery_list");
		return list;
	}
	
	//새 글 추가
	public int insert(GalleryVO vo) {
		//맵퍼로 딱 한개의 객체만 넘겨줄 수 있다.
		int res = sqlSession.insert("cw.gallery_insert", vo);
		return res;
	}
	
	//글 삭제
	public int delete( int galleryContentRef ) {
		int res = sqlSession.delete("cw.gallery_delete", galleryContentRef);
		return res;
	}
	
	//수정을 위한 게시글 한 건 조회
	public GalleryVO selectOne( int galleryContentRef ) {
		GalleryVO vo = sqlSession.selectOne("cw.gallery_one", galleryContentRef);
		return vo;
	}
	
	//게시글 수정
	public int update( GalleryVO vo ) {
		int res = sqlSession.update("cw.gallery_update", vo);
		return res;
	}
	
	
	
}
