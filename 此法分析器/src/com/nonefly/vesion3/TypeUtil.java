package com.nonefly.vesion3;

import java.lang.reflect.Field;

public class TypeUtil {
	private final String keyWords[] = { "abstract", "boolean", "break", "byte", "case", "catch", "char", "class",
			"continue", "default", "do", "double", "else", "extends", "final", "finally", "float", "for", "if",
			"implements", "import", "instanceof", "int", "interface", "long", "native", "new", "package", "private",
			"protected", "public", "return", "short", "static", "super", "switch", "synchronized", "this", "throw",
			"throws", "transient", "try", "void", "volatile", "while", "strictfp", "enum", "goto", "const", "assert" }; // �ؼ�������
	private final char operators[] = { '+', '-', '*', '/', '=', '>', '<', '&', '|', '!' }; // ���������
	private final char separators[] = { ',', ';', '{', '}', '(', ')', '[', ']', '_', ':', '.', '"', '\\' }; // �������

	public boolean isLetter(char ch) {
		return Character.isLetter(ch);
	}

	public boolean isDigit(char ch) {
		return Character.isDigit(ch);
	}

	public boolean isKeyWord(String s) {
		for (int i = 0; i < keyWords.length; i++) {
			if (keyWords[i].equals(s))
				return true;
		}
		return false;
	}

	public boolean isOperator(char ch) {
		for (int i = 0; i < operators.length; i++) {
			if (ch == operators[i])
				return true;
		}
		return false;
	}

	public boolean isSeparators(char ch) {
		for (int i = 0; i < separators.length; i++) {
			if (ch == separators[i])
				return true;
		}
		return false;
	}

	public int getType(String args) {
		int type = -1;
		Field[] fields = KeyTypes.class.getDeclaredFields();
		for (Field field : fields) {
			if (field.getName().equals(args)) {
				try {
					type = (Integer) field.get(new KeyTypes());
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		return type;
	}

}
