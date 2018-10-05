package dictionary;

import java.util.Scanner;


public class DictionaryCommandline {
	DictionaryManagement dictionarymanagement = new DictionaryManagement();
	Scanner sc =new Scanner(System.in);
	public  void showAllWord(){
		System.out.println("|No   |English   |Vietnamese");
		for (int i = 0; i < Dictionary.listWord.size(); i++) {
			Word word = Dictionary.listWord.get(i);
			System.out.println(i+"     "+word.getWord_target()+"         "
			+word.getWord_explain());
		}
	}
	public void dictionaryBasic(){
		dictionarymanagement.insertFromCommandline();
		showAllWord();
	}
	public void dictionaryAdvanced(){
		//dictionarymanagement.insertFromCommandline();
		dictionarymanagement.insertFromFile();
                int choose;
                do{
                System.out.println("-----------------------------------------");
		System.out.println("Choose: ");
		System.out.println("1.Add Word ");
		System.out.println("2.Delete Word ");
		System.out.println("3.edit Word ");
		System.out.println("4.Find Word");
                System.out.println("5.ShowAllWord");
		choose = sc.nextInt();
		sc.nextLine();
		switch(choose){
			case 1: 
				dictionarymanagement.addWord();
				break;
			case 2:
				dictionarymanagement.deleteWord();
				break;
			case 3:
				dictionarymanagement.editWord();
				break;
			case 4:
				dictionarymanagement.dictionarySearcher();
				break;
                        case 5:
                                showAllWord();
                                break;
				
		}
                }while(choose>=1 && choose<=4);
		dictionarymanagement.dictionaryExportToFile();
		
	}
	public static void main(String [] args){
		DictionaryCommandline dicCommand = new  DictionaryCommandline();
		//dicCommand.dictionaryAdvanced();
                dicCommand.dictionaryAdvanced();
                
	}
}
