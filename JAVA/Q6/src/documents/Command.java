package documents;
import java.util.Scanner;

import java.util.LinkedList;


public class Command {
	   Scanner scanner = new Scanner(System.in);

	    DocumentManager documentManager = new DocumentManager();

	    public void commandAct(String command){
	        if (command.equals("1") || command.equals("make")) {
	            makeDocument();
	        }
	        else if (command.equals("2") || command.equals("delate")) {
	            deletDocument();
	        }
	        else if (command.equals("3") || command.equals("recontetct")) {
	            reContent();
	        }
	        else if (command.equals("4") || command.equals("search")) {
	            searchDocument();
	        }
	    }

	    public void  makeDocument() {
	        System.out.println("\n[문서 생성]");
	        System.out.print("문서 이름 : ");
	        String name = scanner.nextLine();
	        System.out.print("문서 생성 날짜 : ");
	        String day = scanner.nextLine();
	        System.out.print("문서 내용 : ");
	        String content = scanner.nextLine();
	        
	        documentManager.makeDocument(day, name, content);
	    }

	    public void deletDocument() {
	        System.out.println("\n[문서 삭제]");
	        System.out.print("문서 이름 : ");
	        String name = scanner.nextLine();

	        documentManager.deletDocument(name);
	    }

	    public void reContent() {
	        System.out.println("\n[문서 내용 수정]");
	        System.out.print("문서 이름 : ");
	        String name = scanner.nextLine();
	        scanner.nextLine();
	        System.out.print("문서 내용 : ");
	        String content = scanner.nextLine();

	        documentManager.recontent(name, content);
	    }

	    public void searchDocument() {
	        System.out.println("\n[문서 검색]");
	        System.out.print("문서 이름 : ");
	        String name = scanner.nextLine();

	        if (name.isEmpty()) {
	            for (Documents document : documentManager.documents) {
	                System.out.println("\n문서 이름 : " + document.getName());
	                System.out.println("문서 생성 날짜 : " + document.getDay());
	                System.out.println("문서 내용 : " + document.getContent());
	            }
	            return;
	        }
	        Document document = documentManager.returnDocument(name);

	        if (document == null) {
	            System.out.println("\n해당 문서가 존재하지 않습니다.");
	        } else {
	            System.out.println("\n문서 이름 : " + document.getName());
	            System.out.println("문서 생성 날짜 : " + document.getDay());
	            System.out.println("문서 내용 : " + document.getContent());
	        }
	    }
}
