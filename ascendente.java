
import java.util.List;
import java.util.Stack;

public class ascendente {
    
public class ASA{
    private int i = 0;
    private boolean hayErrores = false;
    private Token preanalisis;
    private final List<Token> tokens;
    public ASA(List<Token> tokens){
        this.tokens=tokens;
        preanalisis=this.tokens.get(i);
    }

    public void analisis(){
        Stack<String> stack=new Stack<>();
        stack.push("1");//se llena con el primer estado
        String x=stack.peek();//apuntamos el tope de la pila
        Boolean re=true;
        while(re){//bulce infinito
            switch (x) {
                case "1":
                    if(preanalisis.tipo.name()=="SELECT"){
                        stack.push("SELECT");
                        stack.push("3");
                        x=stack.peek();
                        i++;
                        preanalisis=this.tokens.get(i);
                    }
                    else{
                         System.out.println("Error: se esperaba un SELECT");
                         hayErrores=true;
                         re=false;
                    }
                    break;

                case "2":
                    if(preanalisis.tipo.name()=="EOF"){
                        hayErrores=false;
                        re=false;
                    }
                    else{
                        System.out.println("Error");
                        re=false;
                    }
                    break;

                case "3":
                    if(preanalisis.tipo.name()=="DISTINCT"){
                        stack.push("DISTINCT");
                        stack.push("14");
                        x=stack.peek();
                    }
                    else if(preanalisis.tipo.name()=="ASTERISCO"){
                        stack.push("ASTERISCO");
                        stack.push("25");
                        x=stack.peek();
                    }
                    else if(preanalisis.tipo.name()=="IDENTIFICADOR"){
                        stack.push("IDENTIFICADOR");
                        stack.push("19");
                        x=stack.peek();
                    }
                    else{
                        System.out.println("Error: se esperaba un DISTINCT o ASTERISCO o IDENTIFICADOR");
                        hayErrores=true;
                        re=false;
                    }
                    i++;
                    preanalisis=this.tokens.get(i);
                    break;
                
                case "4":
                    if(preanalisis.tipo.name()=="FROM"){
                        stack.push("FROM");
                        stack.push("5");
                        x=stack.peek();
                    }
                    else{
                        System.out.println("Error: se esperaba un FROM");
                        hayErrores=true;
                        re=false;
                    }
                    i++;
                    preanalisis=this.tokens.get(i);
                    break;

                case "5":
                    if(preanalisis.tipo.name()=="IDENTIFICADOR"){
                        stack.push("IDENTIFICADOR");
                        stack.push("7");
                        x=stack.peek();
                    }
                    else{
                        System.out.println("Error: se esperaba un IDENTIFICADOR");
                        hayErrores=true;
                        re=false;
                    }
                    i++;
                    preanalisis=this.tokens.get(i);
                    break;

                case "6":
                    if(preanalisis.tipo.name()=="COMA"){
                        stack.push("COMA");
                        stack.push("8");
                        x=stack.peek();
                        i++;
                        preanalisis=this.tokens.get(i);
                    }
                    else if(preanalisis.tipo.name()=="EOF"){
                        stack.pop();
                        stack.pop();
                        stack.push("EOF");
                        stack.push("2");
                        x=stack.peek();
                    }
                    else{
                        System.out.println("Error: se esperaba una COMA");
                        hayErrores=true;
                        re=false;
                    }
                    break;
                
                case "7":
                    if(preanalisis.tipo.name()=="IDENTIFICADOR"){
                        stack.push("IDENTIFICADOR");
                        stack.push("10");
                        x=stack.peek();
                        i++;
                        preanalisis=this.tokens.get(i);
                    }
                    else if(preanalisis.tipo.name()=="COMA"){
                        stack.pop();
                        stack.pop();
                        stack.push("COMA");
                        stack.push("11");
                        x=stack.peek();
                    }
                    else if(preanalisis.tipo.name()=="EOF"){
                        stack.pop();
                        stack.pop();
                        stack.push("EOF");
                        stack.push("11");
                        x=stack.peek();
                    }
                    else{
                        System.out.println("Error: se esperaba un IDENTIFICADOR");
                        hayErrores=true;
                        re=false;
                    }
                    break;
                
                case "8":
                    if(preanalisis.tipo.name()=="IDENTIFICADOR"){
                        stack.push("IDENTIFICADOR");
                        stack.push("7");
                        x=stack.peek();
                    }
                    else{
                        System.out.println("Error: se esperaba un IDENTIFICADOR");
                        hayErrores=true;
                        re=false;
                    }
                    i++;
                    preanalisis=this.tokens.get(i);
                    break;

                case "10":
                    stack.pop();
                    stack.pop();
                    if(preanalisis.tipo.name()=="COMA"){
                        stack.push("COMA");
                        stack.push("11");
                        x=stack.peek();
                    }
                    else if(preanalisis.tipo.name()=="EOF"){
                        stack.push("EOF");
                        stack.push("11");
                        x=stack.peek();
                    }
                    else{
                        System.out.println("Error: se esperaba una COMA");
                        hayErrores=true;
                        re=false;
                    }
                    break;

                case "11":
                    stack.pop();
                    stack.pop();
                    if(preanalisis.tipo.name()=="COMA"){
                        stack.push("COMA");
                        stack.push("12");
                        x=stack.peek();
                    }
                    else if(preanalisis.tipo.name()=="EOF"){
                        stack.push("EOF");
                        stack.push("12");
                        x=stack.peek();
                    }
                    else{
                        System.out.println("Error: se esperaba una COMA");
                        hayErrores=true;
                        re=false;
                    }
                    break;

                case "12":
                    stack.pop();
                    stack.pop();
                    if(preanalisis.tipo.name()=="COMA"){
                        stack.push("COMA");
                        stack.push("6");
                        x=stack.peek();
                    }
                    else if(preanalisis.tipo.name()=="EOF"){
                        stack.push("EOF");
                        stack.push("6");
                        x=stack.peek();
                    }
                    else{
                        System.out.println("Error: se esperaba una COMA");
                        hayErrores=true;
                        re=false;
                    }
                    break;

}
