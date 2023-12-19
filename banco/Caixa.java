
package banco;

public interface Caixa {
    public abstract void Criarconta(String d, int n, int s);
    public abstract void Depositar();
    public abstract void Sacar();
    public abstract void opcoes();
    public abstract void Fecharconta();
    
}
