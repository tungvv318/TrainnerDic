package dictionary;
import dictionary.Dictionary;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;
import dictionary.Word;

public class DictionaryManagement {
	Scanner sc = new Scanner(System.in);
	//ham nhap tu man hinh
	public  void insertFromCommandline(){
		System.out.println("Nhap so luong tu: ");
		int numberWord = sc.nextInt();
		sc.nextLine();
		// sc.nextLine() de doc not ki tu "\n" khi nhap sc.nextInt()
		for(int i=0; i<numberWord; i++){
			System.out.println("Nhap tu: ");
			String word_target = sc.nextLine();
			System.out.println("Giai nghia: ");
			String word_explain = sc.nextLine();
			Word word = new Word(word_target, word_explain); 
			Dictionary.listWord.add(word);
		}
	}
	//ham tim kiem
	public void dictionaryLookup(){
		System.out.println("nhap tu can tra: ");
		String wordLookup = sc.nextLine();
		for (int i = 0; i < Dictionary.listWord.size(); i++) {
			Word word = Dictionary.listWord.get(i);
			if((word.getWord_target()).equals(wordLookup)){
				System.out.println("Da tim thay!");
				System.out.println(word.getWord_target()+"         "+word.getWord_explain());
			}
			else{
				System.out.println("Khong tim thay!");
			}
		}
	}
	//them tu
	public void addWord(){
		System.out.println("Nhap tu can them: ");
		String wordAdd =sc.nextLine();
		System.out.println("Giai nghia: ");
		String wordAddMean =sc.nextLine();
		Dictionary.listWord.add(new Word(wordAdd,wordAddMean));
		System.out.println("Them thanh cong");
	}
	//xoa tu
	public void deleteWord(){
		System.out.println("Nhap tu muon xoa: ");
		String wordDelete = sc.nextLine();
		for (int i = 0; i < Dictionary.listWord.size(); i++) {
			Word word = Dictionary.listWord.get(i);
			if(word.getWord_target().equals(wordDelete)){
				Dictionary.listWord.remove(word);
			}
			}
		System.out.println("Xoa thanh cong!");
	}
	//sua tu
	public void editWord(){
		System.out.println("Nhap tu muon thay the: ");
		String replaceWord = sc.nextLine();
		for(int i=0; i<Dictionary.listWord.size(); i++){
			Word word = Dictionary.listWord.get(i);
			if(word.getWord_target().equals(replaceWord)){
				System.out.println("Nhap tu thay the: ");
				String editWord = sc.nextLine();
				System.out.println("Giai nghia: ");
				String editWordMean = sc.nextLine();
				Dictionary.listWord.set(i, new Word(editWord, editWordMean));
			}
			System.out.println("Sua thanh cong!");
		}
	}
	//ham tim kiem cac tu
	public void dictionarySearcher(){
		System.out.println("Nhap tu can tim: ");
		String wordSearch = sc.nextLine();
		ArrayList<Word> newList = new ArrayList<Word>();
		for(int i=0; i<Dictionary.listWord.size(); i++){
			Word word = Dictionary.listWord.get(i);
			if(word.getWord_target().indexOf(wordSearch) == 0){
				newList.add(word);
			}
		}
		int i=1;
		for(Word word : newList){
			System.out.printf(i+" %-15s%-15s\n", word.getWord_target(), word.getWord_explain());
			i++;
		}
	}
	//ham nhap tu file
	public void insertFromFile(){
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("Dictionary.txt")
                                , "UTF-8"));
			// gán dòng 1 cho line
			String line = br.readLine();
			while(line != null) {
				String []arr = line.split("\t");//tach thanh cac phan tu
				Word tu = new Word(arr[0],arr[1]);
				Dictionary.listWord.add(tu);					
				line = br.readLine();	//doc ki tu "\n"			
			}
			br.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	//ham xuat ra file
	public void dictionaryExportToFile(){
		try {
			FileOutputStream fos = new FileOutputStream("OutputFile.txt");
			PrintWriter out = new PrintWriter(fos);
			for(int i=0; i<Dictionary.listWord.size();i++){
				Word word = Dictionary.listWord.get(i);
				out.printf("|%d\t|%s\t|%s\n",i,word.getWord_target(),word.getWord_explain());
			}
			out.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
