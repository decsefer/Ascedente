
package ascendente;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;


public class main {
    static boolean existenErrores=false;
    public static void main(String[] args)throws IOException{
         ejecutarPrompt();   
    }
    public static void ejecutarPrompt()throws IOException{
        InputStreamReader input= new InputStreamReader(System.in);
        BufferedReader reader= new BufferedReader(input);

        while(true){
            System.out.print(">>>");
            String linea=reader.readLine();
            if(linea==null) break;
            ejecutar(linea);
            existenErrores=false;
        }
    }
    public static void ejecutar(String source){

       Scanner scanner= new Scanner(source);
        List<Token> tokens= scanner.scanTokens();
        
        ascendente parser = new ascendente(tokens);
        boolean exito = parser.parse(); 
     
        if(exito){
            System.out.println("Cadena valida");
        }
        
    }
}