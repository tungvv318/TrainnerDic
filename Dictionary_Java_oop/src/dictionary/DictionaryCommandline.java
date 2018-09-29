package dictionary;
import dictionary.DictionaryManagement;

import dictionary.Dictionary;

public class DictionaryCommandline {
	DictionaryManagement dictionarymanagement = new DictionaryManagement();
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
		dictionarymanagement.dictionaryExportToFile();
		showAllWord();
		dictionarymanagement.dictionaryLookup();
	}
	public static void main(String [] args){
		DictionaryCommandline dicCommand = new  DictionaryCommandline();
		dicCommand.dictionaryAdvanced();
	}
	
}
