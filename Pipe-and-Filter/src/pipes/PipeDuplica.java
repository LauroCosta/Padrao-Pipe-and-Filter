package pipes;


public class PipeDuplica implements Pipe {
  
    private String nome = "DPL";

    @Override
    public String filtrar(String entrada) {
        return entrada + entrada;
    }

    
    @Override
    public String getNome() {
        return this.nome;
    }
    
    
}
