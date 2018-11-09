package pipes;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PipeSemConsoante implements Pipe {

    private String nome = "RCO";
    
    @Override
    public String filtrar(String entrada) {
      String consoantes = "[bçcdfghjklmnpqrstwvxzBÇCDFGHJLMNPQRSTWVXZ]";   
      Pattern p = Pattern.compile(consoantes);   
      Matcher m = p.matcher(entrada);   
      String saida  = m.replaceAll("");   
         
      return saida;
    }
    
    @Override
    public String getNome() {
        return this.nome;
    }
    
}
