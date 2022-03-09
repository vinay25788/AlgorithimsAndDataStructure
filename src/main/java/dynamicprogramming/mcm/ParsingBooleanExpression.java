package dynamicprogramming.mcm;

import java.util.Stack;

class ParsingBooleanExpression{
    public static boolean parseBoolExpr(String expression) {
        Character result=null;
        Stack<Character> operations = new Stack();
        Stack<Character> values = new Stack();
        for(char c: expression.toCharArray()){  //"|(f,t)";
            if(c=='!' || c=='|' || c=='&'){
                operations.push(c);
            }
            else if(c==')'){
                char oper= operations.pop();
                while(true){
                    char temp =  values.pop();
                    if(temp=='('){
                        result = apply(result,oper);
                        values.push(result);
                        break;
                    }
                    else{
                        result = apply(result,temp,oper);
                    }

                }

            }
            else{
                if(c!=','){
                    values.push(c);
                }
            }
        }




        return result=='t'?true:false;

    }

    private static char  apply(Character result,Character oper){
        if(oper=='!'){
            return result=='f'?'t':'f';
        }
        return result;
    }

    private static char  apply(Character result,Character second, Character oper){

        if(result==null){
            return second;
        }

        if(oper=='|'){
            return (result=='t' || second=='t')?'t':'f';
        }
        if(oper=='&')
            return (result=='t' && second=='t')?'t':'f';


        return second;

    }

    public static void main(String[] args) {
        //String st="!(f)";
        String st = "|(f,t)";
        System.out.println(parseBoolExpr(st));
    }
}