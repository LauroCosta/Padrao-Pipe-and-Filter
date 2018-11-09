package pipes;

public class PipeLetrasMinusculas implements Pipe {
   
    private String nome = "LMI";
    
    @Override
    public String filtrar(String entrada) {
        return entrada.toLowerCase();
    }
      
    @Override
    public String getNome() {
        return this.nome;
    }
    
}
