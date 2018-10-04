package dictionary;
import dictionary.DictionaryManagement;

import java.util.Scanner;

import dictionary.Dictionary;

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
		System.out.println("Choose: ");
		System.out.println("1.Add Word ");
		System.out.println("2.Delete Word ");
		System.out.println("3.edit Word ");
		System.out.println("4.Find Word");
		int x = sc.nextInt();
		sc.nextLine();
		switch(x){
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
				
		}
		dictionarymanagement.dictionaryExportToFile();
		//showAllWord();
	}
	public static void main(String [] args){
		DictionaryCommandline dicCommand = new  DictionaryCommandline();
		dicCommand.dictionaryAdvanced();
	}
}
