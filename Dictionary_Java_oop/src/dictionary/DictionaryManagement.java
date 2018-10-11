package TuDien;

import TuDien.Dictionary;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import TuDien.Word;

public class DictionaryManagement {
	Scanner sc = new Scanner(System.in);

	public void insertFromCommandline() {
		System.out.println("Nhap so luong tu: ");
		int numberWord = sc.nextInt();
		sc.nextLine();
		// sc.nextLine() de doc not ki tu "\n" khi nhap sc.nextInt()
		for (int i = 0; i < numberWord; i++) {
			System.out.println("Nhap tu: ");
			String word_target = sc.nextLine();
			System.out.println("Giai nghia: ");
			String word_explain = sc.nextLine();
			Word word = new Word(word_target, word_explain);
			Dictionary.listWord.add(word);
		}
	}

	public void dictionaryLookup() {
		System.out.print("nhap tu can tra: ");
		String wordLookup = sc.nextLine();
		for (int i = 0; i < Dictionary.listWord.size(); i++) {
			Word word = Dictionary.listWord.get(i);
			int check = word.getWord_target().compareToIgnoreCase(wordLookup);
			if (check == 0) {
				System.out.println("Find sucess!");
				System.out.println(word.getWord_target() + "         " + word.getWord_explain());
				break;
			}
			if ((i == Dictionary.listWord.size() - 1) && (word.getWord_target()).equals(wordLookup) == false) {
				System.out.println("Không có trong database");
			}
		}
	}

	// them tu
	public void addWord() {
		System.out.println("Nhap tu can them: ");
		String wordAdd = sc.nextLine();
		for (int i = 0; i < Dictionary.listWord.size(); i++) {
			Word word = Dictionary.listWord.get(i);
			if ((word.getWord_target()).equals(wordAdd)) {
				System.out.println("Tu nay da ton tai!");
				return;
			}
		}
		System.out.println("Giai nghia: ");
		String wordAddMean = sc.nextLine();
		Dictionary.listWord.add(new Word(wordAdd, wordAddMean));
		System.out.println("Them thanh cong!");
	}

	// xoa tu
	public void deleteWord() {
		System.out.println("Nhap tu muon xoa: ");
		String wordDelete = sc.nextLine();
		boolean check = false;
		for (int i = 0; i < Dictionary.listWord.size(); i++) {
			Word word = Dictionary.listWord.get(i);
			if (word.getWord_target().equals(wordDelete)) {
				Dictionary.listWord.remove(word);
				System.out.println("Xoa thanh cong!");
				check = true;
			}
		}
		if (check == false)
			System.out.println("Tu nay khong ton tai trong tu dien!");
	}

	// sua tu
	public void editWord() {
		System.out.println("Nhap tu muon thay the: ");
		String replaceWord = sc.nextLine();
		boolean check = false;
		for (int i = 0; i < Dictionary.listWord.size(); i++) {
			Word word = Dictionary.listWord.get(i);
			if (word.getWord_target().equals(replaceWord)) {
				System.out.println("Nhap tu thay the: ");
				String editWord = sc.nextLine();
				System.out.println("Giai nghia: ");
				String editWordMean = sc.nextLine();
				Dictionary.listWord.set(i, new Word(editWord, editWordMean));
				System.out.println("Sua thanh cong!");
				check = true;
			}
		}
		if (check == false)
			System.out.println("Tu nay khong ton tai trong tu dien!");
	}
	
	// ham tim kiem cac tu
	public void dictionarySearcher() {
		System.out.println("Nhap tu can tim: ");
		String wordSearch = sc.nextLine();
		ArrayList<Word> newList = new ArrayList<>();
		for (int i = 0; i < Dictionary.listWord.size(); i++) {
			Word word = Dictionary.listWord.get(i);
			if (word.getWord_target().indexOf(wordSearch) == 0) {
				newList.add(word);
			}
		}
		int i = 1;
		for (Word word : newList) {
			System.out.printf(i + " %-15s%-15s\n", word.getWord_target(), word.getWord_explain());
			i++;
		}
	}

	public void insertFromFile() {
		try {
			//FileInputStream fis = new FileInputStream("C:\\Users\\TUNG318\\Desktop\\TuDien\\dictionaries.txt");
			FileInputStream fis = new FileInputStream("C:\\Users\\TUNG318\\Desktop\\TuDien\\dictionaries.txt");
			InputStreamReader isr = new InputStreamReader(fis, "UTF-8");
			BufferedReader br = new BufferedReader(isr);
			// gán dòng 1 cho line
			String line = br.readLine();
			while (line != null) {
				int indexKhoangTrang = line.indexOf(" ");
				String s1 = line.substring(0, indexKhoangTrang);
				String s2 = line.substring(indexKhoangTrang+1);
				Word tu = new Word(s1, s2);
				Dictionary.listWord.add(tu); // đọc vào list từ luôn
				line = br.readLine(); // doc ki tu "\n"
			}
			br.close();
			isr.close();
			fis.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void dictionaryExportToFile() {
		try {
			FileOutputStream fos = new FileOutputStream("C:\\Users\\TUNG318\\Desktop\\TuDien\\OutPut.txt");
			
			OutputStreamWriter osw = new OutputStreamWriter(fos, "UTF-8");
			BufferedWriter bw = new BufferedWriter(osw);
			for (Word tu : Dictionary.listWord) {
				String line = tu.getWord_target() + " " + tu.getWord_explain();
				bw.write(line);
				bw.newLine();

			}
			bw.close();
			osw.close();
			fos.close();
			// return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// sắp xếp
	public void sortListWord() {
		Collections.sort(Dictionary.listWord, new WordTargetComparator());
	}
	
