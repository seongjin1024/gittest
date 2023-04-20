package com.jdbc.board.view;

import java.util.List;
import java.util.Scanner;

import com.jdbc.board.controller.BoardController;
import com.jdbc.board.model.dto.Board;

public class MainView {
	
	public void mainMenu() {
		Scanner sc=new Scanner(System.in);
		BoardController controller=new BoardController();
		while(true) {
			System.out.println("===== 게시글 조회하기 =====");
			System.out.println("1. 게시글 전체 조회하기");
			System.out.println("0. 프로그램 종료");
			System.out.print("메뉴선택 : ");
			int cho=sc.nextInt();
			switch(cho) {
				case 1 : controller.selectBoardAll();break;
				case 0 : System.out.println("프로그램을 종료합니다.");return;
				default : System.out.println("없는 메뉴입니다 다시 선택하세요");
			}
		}
	}
	
	public void printBoard(List<Board> boards) {
		System.out.println("====== 게시글 리스트 ======");
		if(boards.isEmpty()) {
			System.out.println("조회된 게시글이 없습니다");
		}else {
			boards.forEach(b->System.out.println(b));
		}
		System.out.println("=======================");
	}
	
	
}