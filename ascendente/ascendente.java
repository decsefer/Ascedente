package ascendente;
import java.util.List;
import java.util.Stack;

public class ascendente{
    private int i = 0;
    private boolean hayErrores = false;
    private Token preanalisis;
    private final List<Token> tokens;

    public ascendente(List<Token> tokens){
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
                    if("SELECT".equals(preanalisis.tipo.name())){
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
                    if("EOF".equals(preanalisis.tipo.name())){
                        hayErrores=false;
                        re=false;
                    }
                    else{
                        System.out.println("Error");
                        re=false;
                    }
                    break;

                case "3":
                    if("DISTINCT".equals(preanalisis.tipo.name())){
                        stack.push("DISTINCT");
                        stack.push("14");
                        x=stack.peek();
                    }
                    else if("ASTERISCO".equals(preanalisis.tipo.name())){
                        stack.push("ASTERISCO");
                        stack.push("25");
                        x=stack.peek();
                    }
                    else if("IDENTIFICADOR".equals(preanalisis.tipo.name())){
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
                    if("FROM".equals(preanalisis.tipo.name())){
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
                    if("IDENTIFICADOR".equals(preanalisis.tipo.name())){
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
                    if("COMA".equals(preanalisis.tipo.name())){
                        stack.push("COMA");
                        stack.push("8");
                        x=stack.peek();
                        i++;
                        preanalisis=this.tokens.get(i);
                    }
                    else if("EOF".equals(preanalisis.tipo.name())){
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
                    if("IDENTIFICADOR".equals(preanalisis.tipo.name())){
                        stack.push("IDENTIFICADOR");
                        stack.push("10");
                        x=stack.peek();
                        i++;
                        preanalisis=this.tokens.get(i);
                    }
                    else if("COMA".equals(preanalisis.tipo.name())){
                        stack.pop();
                        stack.pop();
                        stack.push("COMA");
                        stack.push("11");
                        x=stack.peek();
                    }
                    else if("EOF".equals(preanalisis.tipo.name())){
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
                    if("IDENTIFICADOR".equals(preanalisis.tipo.name())){
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
                    if("COMA".equals(preanalisis.tipo.name())){
                        stack.push("COMA");
                        stack.push("11");
                        x=stack.peek();
                    }
                    else if("EOF".equals(preanalisis.tipo.name())){
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
                    if("COMA".equals(preanalisis.tipo.name())){
                        stack.push("COMA");
                        stack.push("12");
                        x=stack.peek();
                    }
                    else if("EOF".equals(preanalisis.tipo.name())){
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
                    if("COMA".equals(preanalisis.tipo.name())){
                        stack.push("COMA");
                        stack.push("6");
                        x=stack.peek();
                    }
                    else if("EOF".equals(preanalisis.tipo.name())){
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

                case "13":
                    stack.pop();
                    stack.pop();
                    if("COMA".equals(preanalisis.tipo.name())){
                        stack.push("COMA");
                        stack.push("6");
                        x=stack.peek();
                    }
                    else if("EOF".equals(preanalisis.tipo.name())){
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

                case "14":
                    if("ASTERISCO".equals(preanalisis.tipo.name())){
                        stack.push("ASTERISCO");
                        stack.push("25");
                        x=stack.peek();
                    }
                    else if("IDENTIFICADOR".equals(preanalisis.tipo.name())){
                        stack.push("IDENTIFICADOR");
                        stack.push("19");
                        x=stack.peek();
                    }
                    else{
                        System.out.println("Error: se esperaba un ASTERISCO o IDENTIFICADOR");
                        hayErrores=true;
                        re=false;
                    }
                    i++;
                    preanalisis=this.tokens.get(i);
                    break;

                case "15":
                    stack.pop();
                    stack.pop();
                    if("FROM".equals(preanalisis.tipo.name())){
                        stack.push("FROM");
                        stack.push("4");
                        x=stack.peek();
                    }
                    else{
                        System.out.println("Error: se esperaba un FROM");
                        hayErrores=true;
                        re=false;
                    }
                    break;

                case "16":
                    if("COMA".equals(preanalisis.tipo.name())){
                        stack.push("COMA");
                        stack.push("17");
                        x=stack.peek();
                        i++;
                        preanalisis=this.tokens.get(i);
                    }
                    else if("FROM".equals(preanalisis.tipo.name())){
                        stack.push("FROM");
                        stack.push("15");
                        x=stack.peek();
                    }
                    else{
                        System.out.println("Error: se esperaba una COMA ");
                        hayErrores=true;
                        re=false;
                    }
                    
                    break;

                case "17":
                    if("IDENTIFICADOR".equals(preanalisis.tipo.name())){
                        stack.push("IDENTIFICADOR");
                        stack.push("19");
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

                case "18":
                    if("FROM".equals(preanalisis.tipo.name())){
                        stack.push("FROM");
                        stack.push("16");
                        x=stack.peek();
                    }
                    else if("COMA".equals(preanalisis.tipo.name())){
                        stack.push("COMA");
                        stack.push("16");
                        x=stack.peek();
                    }
                    else{
                        System.out.println("Error: se esperaba una COMA o FROM");
                        hayErrores=true;
                        re=false;
                    }
                    break;

                case "19":
                    if("PUNTO".equals(preanalisis.tipo.name())){
                            stack.push("PUNTO");
                            stack.push("21");
                            x=stack.peek();
                            i++;
                            preanalisis=this.tokens.get(i);
                    }
                    else if("FROM".equals(preanalisis.tipo.name())){
                        stack.pop();
                        stack.pop();
                        stack.push("FROM");
                        stack.push("20");
                        x=stack.peek();
                    }
                    else if("COMA".equals(preanalisis.tipo.name())){
                        stack.pop();
                        stack.pop();
                        stack.push("COMA");
                        stack.push("20");
                        x=stack.peek();
                    }
                    else{
                        System.out.println("Error: se esperaba un PUNTO");
                        hayErrores=true;
                        re=false;
                    }
                    break;

                case "20":
                    if("FROM".equals(preanalisis.tipo.name())){
                            stack.push("FROM");
                            stack.push("24");
                            x=stack.peek();
                    }
                    else if("COMA".equals(preanalisis.tipo.name())){
                            stack.push("COMA");
                            stack.push("24");
                            x=stack.peek();
                    }
                    else{
                        System.out.println("Error: se esperaba un FROM o COMA");
                        hayErrores=true;
                        re=false;
                    }
                    break;

                case "21":
                    if("IDENTIFICADOR".equals(preanalisis.tipo.name())){
                        stack.push("IDENTIFICADOR");
                        stack.push("23");
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

                case "23":
                    if("FROM".equals(preanalisis.tipo.name())){
                            stack.push("FROM");
                            stack.push("20");
                            x=stack.peek();
                    }
                    else if("COMA".equals(preanalisis.tipo.name())){
                            stack.push("COMA");
                            stack.push("20");
                            x=stack.peek();
                    }
                    else{
                        System.out.println("Error: se esperaba un FROM o COMA");
                        hayErrores=true;
                        re=false;
                    }
                    break;

                case "24":
                    if("FROM".equals(preanalisis.tipo.name())){
                            stack.push("FROM");
                            stack.push("16");
                            x=stack.peek();
                    }
                    else if("COMA".equals(preanalisis.tipo.name())){
                            stack.push("COMA");
                            stack.push("16");
                            x=stack.peek();
                    }
                    else{
                        System.out.println("Error: se esperaba un FROM o COMA");
                        hayErrores=true;
                        re=false;
                    }
                    break;

                case "25":
                    stack.pop();
                    stack.pop();
                    if("FROM".equals(preanalisis.tipo.name())){
                            stack.push("FROM");
                            stack.push("15");
                            x=stack.peek();
                    }
                    else{
                        System.out.println("Error: se esperaba un FROM");
                        hayErrores=true;
                        re=false;
                    }
                    break;

                case "26":
                    if("FROM".equals(preanalisis.tipo.name())){
                            stack.push("FROM");
                            stack.push("4");
                            x=stack.peek();
                    }
                    else{
                        System.out.println("Error: se esperaba un FROM");
                        hayErrores=true;
                        re=false;
                    }
                    break;
                default:
                    System.out.println("Error: se ha encontrado error desconocido");
                    re=false;
                    hayErrores=true;
                    break;
            }
        }
    }
    
    public boolean parse(){
        analisis();
        return !hayErrores;
    }
}