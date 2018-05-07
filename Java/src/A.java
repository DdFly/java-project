
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.net.URI;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Scanner;

public class A
{
    static int code;
    static int num=0;
    static int value;
    static int state;
    static String strToken;
    static char ch;
    static String s;
    static ArrayList<String> listS = new ArrayList<String>();
    static ArrayList<Integer> listI = new ArrayList<Integer>();
    static String[] save={"abstract", "boolean", "break", "byte", "case", "catch", "char", "class",
			"continue", "default", "do", "double", "else", "extends", "final", "finally", "float", "for", "if",
			"implements", "import", "instanceof", "int", "interface", "long", "native", "new", "package", "private",
			"protected", "public", "return", "short", "static", "super", "switch", "synchronized", "this", "throw",
			"throws", "transient", "try", "void", "volatile", "while", "strictfp", "enum", "goto", "const", "assert"};
    static File file = new File("C:\\Users\\代栋\\Desktop\\main.txt");
    static StringBuffer buffer = new StringBuffer();
    public static void main(String[] args)
    {
        // TODO 自动生成的方法存根
    	if(!file.exists()){
    		System.out.println("文件不存在");
    		return;
    	}
    	try { 		
    		FileReader fileReader = new FileReader("C:\\Users\\代栋\\Desktop\\main.txt");
			BufferedReader br = new BufferedReader(fileReader);
			String temp = null;
			while ((temp = br.readLine()) != null) {
				buffer.append(temp);
			}
			br.close();
		} catch (FileNotFoundException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		} catch (IOException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
        while(num<buffer.length()){
        	strToken="";
        	read();
        }

    }
    
    static void read(){
    	GetChar();
        GetBC();
         if(IsLetter(ch) || Is_(ch))
         {
             while(IsLetter(ch) || IsDigit(ch) || Is_(ch))
             {
                 Concat();
                 GetChar();
             }
             Retract();
             code = Reserve();
             if(code == 0)
             {
            	 System.out.println("标识符："+strToken);
             }
             else
             {
            	 System.out.println("关键字："+strToken);
             }
         }
         else if(IsDigit(ch)) {
	          while(IsDigit(ch)) {
	               Concat();
	               GetChar();
	          }
	          Retract();
	          //value = InsertConst();
	          System.out.println("数字："+strToken);       
         }
         else if(ch == '='){
        	 Concat();
              GetChar();
              if(ch == '='){
            	  Concat();
              }
              else
            	  Retract();
              System.out.println("运算符："+strToken);
          }
          else if(ch == '+'){
        	  Concat();
              GetChar();
              if(ch == '=' || ch == '+'){
            	  Concat();
              }
              else
            	  Retract();
              System.out.println("运算符："+strToken);       

          }
          else if(ch == '-'){
        	  Concat();
              GetChar();
              if(ch == '=' || ch == '-'){
            	  Concat();
              }
              else
            	  Retract();
              System.out.println("运算符："+strToken);
          }
          else if(ch == '*'){
        	  Concat();
              GetChar();
              if(ch == '='){
            	  Concat();
            	  System.out.println("运算符："+strToken);
              }
              else if(ch == '/'){
            	  Concat();
            	  System.out.println("注释："+strToken);
            	  
              }
              else{
            	  Retract();
            	  System.out.println("运算符："+strToken);
              }
            	  
           
          }
          else if(ch == '/'){
        	  Concat();
              GetChar();
              if(ch == '='){
            	  Concat();
            	  System.out.println("运算符："+strToken);
              }
              else if (ch == '*') {
            	  Concat();
            	  System.out.println("注释："+strToken);
					while (true) {
						GetChar();
						if (ch == '*') {
							GetChar();
							if (ch == '/') {
								strToken="*/";
								System.out.println("注释："+strToken);
								Retract();
								break;
							}
						}
					}
			}
              else if(ch == '/'){
            	  Concat();
//            	  while(ch!=9&&(num<buffer.length())){
//            		  GetChar();
//            	  }
            	  System.out.println("注释："+strToken);
              }
              else{
            	  Retract();
            	  System.out.println("运算符："+strToken);
              }
              
          }
          else if(ch == '<' || ch == '>'){
        	  Concat();
        	  GetChar();
        	  if(ch == '='){
        		  Concat();
        	  }
        	  else
        		  Retract();
        	  System.out.println("运算符："+strToken);
          }
          else if(ch=='\"'||ch=='\''){
        	  char c = ch;
        	  Concat();
        	  System.out.println("分隔符："+strToken);
        	  do{
        		  GetChar();
        	  }while(ch!=c&&(num<buffer.length()));
        	  //Retract();
        	  System.out.println("分隔符："+strToken);
          }
          else if(ch=='{'||ch=='('||ch==')'||ch=='}'||ch=='['||ch==']'||ch==','||ch=='.'||ch==';'||ch==':'){
        	  Concat();
        	  System.out.println("分隔符："+strToken);
          }
         
    }

	static void GetChar()
    {	//byte[] b = new byte[2];
		ch = buffer.charAt(num);
		num++;
    }

    static void GetBC()
    {
        while(Character.isWhitespace(ch))
        {
            GetChar();
        }
    }

    static void Concat()
    {
        strToken += ch;
    }
    
    static boolean IsLetter(char c)
    {
        if(Character.isLetter(c))
            return true;
        return false;
    }

    static boolean IsDigit(char c)
    {
        if(Character.isDigit(c))
            return true;
        return false;
    }

    static boolean Is_(char c)
    {
        if(c == '_')
            return true;
        return false;
    }

    static int Reserve()
    {
    	int i=0;
    	while(i<save.length){
    		if (strToken.equals(save[i]))
    			return i;
    		else
    			i++;
    	}
        return 0;
    }

    static int InsertId()
    {
        listS.add(strToken);
        return listS.size() - 1;
    }

    static int InsertConst()
    {
        listI.add(Integer.parseInt(strToken));
        return listI.size() - 1;
    }

    static void Retract()
    {
        num--;
        ch=' ';
    }

}
