package ascendente;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Scanner {
    private final String source;
    private final List<Token> tokens= new ArrayList<>();
    private static final Map<String, Token.TipoToken> palabrasReservadas;
    
    static {
        palabrasReservadas = new HashMap<>();
        palabrasReservadas.put("select", Token.TipoToken.SELECT);
        palabrasReservadas.put("from", Token.TipoToken.FROM);
        palabrasReservadas.put("distinct", Token.TipoToken.DISTINCT);
        palabrasReservadas.put("*",Token.TipoToken.ASTERISCO);
        palabrasReservadas.put(",",Token.TipoToken.COMA);
        palabrasReservadas.put(".",Token.TipoToken.PUNTO);
    }
    public boolean terminal(char c){
        String caracteres=",.*";
        return caracteres.indexOf(c)!=-1;
    }
    Scanner(String source){
        this.source=source+" ";
    }
    List<Token> scanTokens(){
        String lexema="";
        int estado=0;
        char c;
        for(int i=0; i<source.length(); i++){
            c=source.charAt(i);
            switch (estado) {
                case 0:
                    if(terminal(c)){
                        i--;
                        estado=1;
                    }
                    else if(Character.isLetter(c)||Character.isDigit(c)){
                        lexema+=c;
                        estado=2;
                    }
                    break;
                    case 1:
                        if(c=='*'){
                            lexema+=c;
                            Token t=new Token(Token.TipoToken.ASTERISCO, lexema);
                            estado=0;
                            lexema="";
                            tokens.add(t);
                        }
                        else if (c=='.') {
                            lexema+=c;
                            Token t=new Token(Token.TipoToken.PUNTO, lexema);
                            estado=0;
                            lexema="";
                            tokens.add(t);
                        }
                        else if (c==',') {
                            lexema+=c;
                            Token t=new Token(Token.TipoToken.COMA, lexema);
                            estado=0;
                            lexema="";
                            tokens.add(t);
                        }
                        break;
                    case 2:
                        if(Character.isLetter(c)||Character.isDigit(c)){
                            estado=2;
                            lexema+=c;
                        }
                        else{
                            Token.TipoToken tt=palabrasReservadas.get(lexema);
                            if(tt==null){
                                Token t=new Token(Token.TipoToken.IDENTIFICADOR, lexema);
                                tokens.add(t);
                            }
                            else{
                                Token t=new Token(tt, lexema);
                                tokens.add(t);
                            }
                            estado=0;
                            lexema="";
                            i--;
                        }
                        break;
            }
        }
        tokens.add(new Token(Token.TipoToken.EOF, lexema));
        return tokens;
    }
    
    
}