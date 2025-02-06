package calculator;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;

public class Application {
    public static void main(String[] args) {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        ArrayList<Character> pass = new ArrayList<>();
        pass.add(',');
        pass.add(':');
        int total=0;

        String input = Console.readLine();

        for(int i=0;i<input.length();i++){
            // '//;\\n'
            if((input.charAt(0)=='/')&&(input.charAt(1)=='/')&&(input.charAt(3)=='\\')&&input.charAt(4)=='n'){
                char custom = input.charAt(2);
                pass.add(custom); //구분자 리스트에 포함
                if(i>4 && input.charAt(i)!=custom){
                    //에외처리
                    if ((!pass.contains(input.charAt(i)))&&(input.charAt(i)-'0')<0) {
                        throw new IllegalArgumentException("예외처리");
                    }
                    int num = (input.charAt(i) - '0');
                    total+=num;
                }
            }
            //,이나:
            else if ((input.charAt(i)!=',')&&(input.charAt(i)!=':')) {
                //에외처리
                if ((!pass.contains(input.charAt(i)))&&(input.charAt(i)-'0')<0) {
                    throw new IllegalArgumentException("예외처리");
                }
                int num= (input.charAt(i) - '0');
                total+=num;
            }
        }
        System.out.println("결과 : "+ total);
    }
}
