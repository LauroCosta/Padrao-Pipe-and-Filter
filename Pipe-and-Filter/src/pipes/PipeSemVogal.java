package pipes;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PipeSemVogal implements Pipe {

    private final String SIGLA = "RVO";
    
    @Override
    public String filtrar(String entrada) {
        
      String vogais = "[aeiyouAEIYOU]";   
      Pattern p = Pattern.compile(vogais);   
      Matcher m = p.matcher(entrada);   
      String saida  = m.replaceAll("");   
         
      return saida;
    }
       
    @Override
    public String getSigla() {
        return this.SIGLA;
    } 
}
