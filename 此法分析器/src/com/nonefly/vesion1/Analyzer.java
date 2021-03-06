package com.nonefly.vesion1;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Analyzer {
	private String keyWords[] = { "abstract", "boolean", "break", "byte", "case", "catch", "char", "class", "continue",
			"default", "do", "double", "else", "extends", "final", "finally", "float", "for", "if", "implements",
			"import", "instanceof", "int", "interface", "long", "native", "new", "package", "private", "protected",
			"public", "return", "short", "static", "super", "switch", "synchronized", "this", "throw", "throws",
			"transient", "try", "void", "volatile", "while", "strictfp", "enum", "goto", "const", "assert" };
	private char operators[] = { '+', '-', '*', '/', '=', '>', '<', '&' };
	private char separators[] = { ',', ';', '{', '}', '(', ')', '[', ']', '_', ':', '.', '"' };
	private String fileSrcName;
	private StringBuffer buffer = new StringBuffer();
	private char ch;
	private static int i = 0;
	private static int ketType;
	private String strToken;

	public Analyzer() {
	}

	public Analyzer(String fileSrcName) {
		this.fileSrcName = fileSrcName;
	}

	public void getChar() {
		ch = buffer.charAt(i);
		i++;
	}

	public void getBc() {
		while (Character.isSpaceChar(ch))
			getChar();
	}

	public void concat() {
		strToken += ch;
	}

	boolean isLetter() {
		return Character.isLetter(ch);
	}

	boolean isDigit() {
		return Character.isDigit(ch);
	}

	public void retract() {
		i--;
		ch = ' ';
	}

	public int isKeyWord() {
		ketType = -1;
		for (int i = 0; i < keyWords.length; i++) {
			if (keyWords[i].equals(strToken))
				ketType = i + 1;
		}
		return ketType;
	}

	public int isOperator() {
		ketType = -1;
		for (int i = 0; i < operators.length; i++) {
			if (ch == operators[i])
				ketType = i + 51;
		}
		return ketType;
	}

	public int isSeparators() {
		ketType = -1;
		for (int i = 0; i < separators.length; i++) {
			if (ch == separators[i])
				ketType = i + 101;
		}
		return ketType;
	}

	public void insertKeyWords(String strToken) {
		System.out.println("(" + ketType + "," + strToken + ")");
	}

	public void insertId(String strToken) {
		System.out.println("(" + 200 + "," + ch + ")");
	}

	public void insertConst(String strToken) {
		// int num = Integer.parseInt(strToken);
		System.out.println("(" + 0 + "," + strToken + ")");
	}

	public void insertOperators(char ch) {
		System.out.println("(" + ketType + "," + ch + ")");
	}

	public void insertSeparators() {
		System.out.println("(" + ketType + "," + ch + ")");
	}

	public void readFile() {
		try {
			FileReader fis = new FileReader(this.fileSrcName);
			BufferedReader br = new BufferedReader(fis);
			String temp = null;
			while ((temp = br.readLine()) != null) {
				buffer.append(temp);
			}
			br.close();
		} catch (FileNotFoundException e) {
			System.out.println("源文件未找到");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("读写文件异常!");
			e.printStackTrace();
		}
	}

	public void analyse() {
		// boolean isCode, value;
		strToken = "";
		while (i < buffer.length()) {
			getChar();
			getBc();
			if (isLetter()) {
				while (isLetter() || isDigit()) {
					concat();
					getChar();
				}
				retract();
				if (isKeyWord() > 0) {
					insertKeyWords(strToken);
				} else {
					insertId(strToken);
				}
				strToken = "";
			} else if (isDigit()) {
				while (isDigit()) {
					concat();
					getChar();
				}
				retract();
				insertConst(strToken);
				strToken = "";
			} else if (isOperator() > 0) {
				insertOperators(ch);
			} else if (isSeparators() > 0) {
				insertSeparators();
			}
		}
	}

	public static void main(String[] args) {
		Analyzer alr = new Analyzer("./src/input.txt");
		alr.readFile();
		alr.analyse();
		// System.err.println("常数，种别0");
		// System.err.println("关键字，种别[1,50]");
		// System.err.println("运算符，种别[51,100]");
		// System.err.println("分隔符，种别[100,150]");
		// System.err.println("标识符，种别200");
	}
}