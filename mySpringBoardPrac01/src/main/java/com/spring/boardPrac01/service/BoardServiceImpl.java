package com.spring.boardPrac01.service;

import java.util.List;
import javax.inject.Inject;
import org.springframework.stereotype.Service;
import com.spring.boardPrac01.dao.BoardDAO;
import com.spring.boardPrac01.dto.BoardDTO;

@Service 
public class BoardServiceImpl implements BoardService {

	@Inject
	private BoardDAO dao;	
	
	@Override
	public List<BoardDTO> listAll() throws Exception{
		return dao.getAllBoard();
	}

	@Override
	public void insert(BoardDTO bdto) throws Exception{
		dao.insertBoard(bdto);
	}

	@Override
	public BoardDTO read(int num) throws Exception {
		dao.increaseReadCount(num);
		return dao.getOneBoard(num);
	}

	@Override
	public boolean modify(BoardDTO bdto) throws Exception {
		boolean isSucceed = false;
		if(dao.validateUserCheck(bdto) != null) {
			dao.updateBoard(bdto);
			isSucceed = true;
		}
		return isSucceed;
	}

	@Override
	public boolean remove(BoardDTO bdto) throws Exception {
		boolean isSucceed = false;
		if(dao.validateUserCheck(bdto)!= null) {
			dao.deleteBoard(bdto.getNum());
			isSucceed = true;
		}
		return isSucceed;
	}
}