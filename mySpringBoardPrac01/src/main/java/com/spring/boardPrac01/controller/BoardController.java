package com.spring.boardPrac01.controller;

import java.util.List;
import javax.inject.Inject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import com.spring.boardPrac01.dto.BoardDTO;
import com.spring.boardPrac01.service.BoardService;

@Controller 
public class BoardController {
	
	@Inject								
	private BoardService boardService;	
	
	@RequestMapping(value = "/" , method = RequestMethod.GET) 
	public String main() {
		return "boardPrac01/main";  
	}
	
	@RequestMapping(value="/boardList")
	public String boardList(Model model) throws Exception {
		
		List<BoardDTO> boardList = boardService.listAll();
		model.addAttribute("boardList" , boardList);
		
		return "boardPrac01/bList";
	}
	
	@RequestMapping(value="/boardWrite" , method = RequestMethod.GET)
	public String boardWriteForm() {
		return "boardPrac01/bWrite";
	}
	
	@RequestMapping(value="/boardWrite" , method = RequestMethod.POST)
	public String boardWriteAction(BoardDTO bdto) throws Exception{
		boardService.insert(bdto);
		return "redirect:boardList";	
	}
	@RequestMapping(value = "/boardInfo")
	public String boardInfo(@RequestParam("num") int num, Model model) throws Exception{
		BoardDTO bdto = boardService.read(num);
		model.addAttribute("bdto", bdto);
		return "boardPrac01/bInfo";
	}
	
	@RequestMapping(value="/boardUpdate", method = RequestMethod.GET)
	public String boardUpdateForm(@RequestParam("num") int num, Model model) throws Exception {
		BoardDTO bdto = boardService.read(num);
		model.addAttribute("bdto", bdto);
		return "boardPrac01/bUpdate";
	}
	
	
	@RequestMapping(value="/boardUpdate", method = RequestMethod.POST)
	public String boardUpdate(BoardDTO bdto, Model model) throws Exception {
		if(boardService.modify(bdto)) 	model.addAttribute("success", true);
		else 							model.addAttribute("success", false);
		
		return "boardPrac01/bUpdatePro";
	}
	
	@RequestMapping(value="/boardDelete", method=RequestMethod.GET)
	public String boardDeleteForm(@RequestParam("num") int num, Model model) throws Exception {
		BoardDTO bdto = boardService.read(num);
		model.addAttribute("bdto", bdto);
		return "boardPrac01/bDelete";
	}
	
	@RequestMapping(value="/boardDelete", method=RequestMethod.POST)
	public String boardDelete(BoardDTO bdto, Model model) throws Exception {
		if(boardService.remove(bdto))	model.addAttribute("success", true);
		else							model.addAttribute("success", false);
		return "boardPrac01/bDeletePro";
	}
}
