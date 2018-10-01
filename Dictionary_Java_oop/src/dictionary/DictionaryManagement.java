package dictionary;
import dictionary.Dictionary;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Scanner;
import dictionary.Word;

public class DictionaryManagement {
	Scanner sc = new Scanner(System.in);
	
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
	public void dictionaryLookup(){
		System.out.println("nhap tu can tra: ");
		String wordLookup = sc.nextLine();
		for (int i = 0; i < Dictionary.listWord.size(); i++) {
			Word word = Dictionary.listWord.get(i);
			if((word.getWord_target()).equals(wordLookup)){
				System.out.println("Find sucess!");
				System.out.println(word.getWord_target()+"         "+word.getWord_explain());
			}
			//thieu
		}
	}
	public void insertFromFile(){
		try {
			FileInputStream fis = new FileInputStream("Dictionary.txt");
			InputStreamReader isr = new InputStreamReader(fis, "UTF-8");
			BufferedReader br = new BufferedReader(isr);
			// gán dòng 1 cho line
			String line = br.readLine();
			while(line != null) {
				String []arr = line.split("\t");//tach thanh cac phan tu
				Word tu = new Word(arr[0],arr[1]);
				Dictionary.listWord.add(tu);					
				line = br.readLine();	//doc ki tu "\n"			
			}
			br.close();
			isr.close();
			fis.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
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
