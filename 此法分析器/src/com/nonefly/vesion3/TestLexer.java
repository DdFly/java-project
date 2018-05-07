package com.nonefly.vesion3;

public class TestLexer extends TypeUtil {
	private StringBuffer buffer = new StringBuffer();
	private int i = 0;
	private char ch;
	private String strToken;

	public TestLexer() {
	}

	public TestLexer(String fileSrc) {
		FileUtil.readFile(buffer, fileSrc);
	}

	public void analyse() {
		strToken = "";
		FileUtil.clearFile();
		while (i < buffer.length()) {
			getChar();
			getBC();
			if (isLetter(ch)) {
				while (isLetter(ch) || isDigit(ch)) {
					concat();
					getChar();
				}
				retract();
				if (isKeyWord(strToken)) {
					writeFile(strToken, strToken);
				} else {
					writeFile("id", strToken);
				}
				strToken = "";
			} else if (isDigit(ch)) {
				while (isDigit(ch)) {
					concat();
					getChar();
				}
				if (!isLetter(ch)) {
					retract();
					writeFile("digit", strToken);
				} else
					writeFile("error", strToken);
				strToken = "";
			} else if (isOperator(ch)) {
				if (ch == '/') {
					getChar();
					if (ch == '*') {
						while (true) {
							getChar();
							if (ch == '*') {
								getChar();
								if (ch == '/') {
									getChar();
									break;
								}
							}
						}
					}
					if (ch == '/') {
						while (ch != 9) {
							// System.out.println(ch+" "+(int)ch);
							getChar();
						}
					}
					retract();
				}
				// System.out.println(ch+" "+(int)ch);
				switch (ch) {
				case '+':
					writeFile("plus", ch + "");
					break;
				case '-':
					writeFile("min", ch + "");
					break;
				case '*':
					writeFile("mul", ch + "");
					break;
				case '/':
					writeFile("div", ch + "");
					break;
				case '>':
					writeFile("gt", ch + "");
					break;
				case '<':
					writeFile("lt", ch + "");
					break;
				case '=':
					writeFile("eq", ch + "");
					break;
				case '&':
					writeFile("and", ch + "");
					break;
				case '|':
					writeFile("or", ch + "");
					break;
				case '~':
					writeFile("not", ch + "");
					break;
				default:
					break;
				}
			} else if (isSeparators(ch)) {
				writeFile("separators", ch + "");
			} else
				writeFile("error", ch + "");
		}
	}

	public void getChar() {
		ch = buffer.charAt(i);
		i++;
	}

	public void getBC() {
		while (Character.isWhitespace(ch))
			getChar();
	}

	public void concat() {
		strToken += ch;
	}

	public void retract() {
		i--;
		ch = ' ';
	}

	public void writeFile(String file, String s) {
		int temp = getType(file.toUpperCase());
		System.out.println("(" + temp + ", " + s + ")");
		file = "(" + temp + ", " + s + ")" + "\r\n";
		FileUtil.writeFile(file);
	}
}