
package banco;

import javax.swing.JOptionPane;

public class Conta implements Caixa{
    
    private boolean status;
    private int numero;
    private int senha;
    private String dono;
    private float saldo;

    public Conta(){
        this.setDono(null);
        this.setNumero(0);
        this.setSaldo(0f);
        this.setStatus(false);
    }

    public int getSenha() {
        return senha;
    }

    public void setSenha(int senha) {
        this.senha = senha;
    }
    
    
    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getDono() {
        return dono;
    }

    public void setDono(String dono) {
        this.dono = dono;
    }

    public float getSaldo() {
        return saldo;
    }

    public void setSaldo(float saldo) {
        this.saldo = saldo;
    }
    
    public void setStatus(boolean status){
        this.status = status;
    }
    
    public boolean getStatus(){
        return status;
    }
    
    
    @Override
    public void Criarconta(String dono, int numero, int saldo) {
        this.setDono(dono);
        this.setNumero(numero);
        this.setSenha(saldo);
        this.setStatus(true);
        JOptionPane.showMessageDialog(null,"CONTA CRIADA COM EXITO");
    }

    @Override
    public void Fecharconta() {
        
        if(this.getSaldo()>0f){
            JOptionPane.showMessageDialog(null, "ainda ha dinheiro em sua conta, Saque para poder fechar sua conta");
        } else if(this.getSaldo()<0f){
            JOptionPane.showMessageDialog(null, "ha uma pendencia em sua conta, pague para poder fechar");
        } else{
            this.setStatus(false);
            JOptionPane.showMessageDialog(null, "sua conta foi fechada com sucesso!");
        }
        
    }
    
    @Override
    public void Depositar(){
        
        float valor = Float.parseFloat(JOptionPane.showInputDialog("Informe um valor para deposito: "));
        this.setSaldo(this.getSaldo() + valor);
        String saldo = String.format("%.2f", this.getSaldo());
        
        JOptionPane.showMessageDialog(null, "DEPOSITO REALIZADO COM SUCESSO!\nSALDO ATUAL : R$" + saldo);
    }
    
    @Override
    public void Sacar(){
        
        float valor = Float.parseFloat(JOptionPane.showInputDialog("Informe o valor do saque"));
        String saldo = String.format("%.2f", this.getSaldo());
        
        if((valor>this.getSaldo()) || this.getSaldo() == 0){
            JOptionPane.showMessageDialog(null, "SALDO INSUFICIENTE :(\n SALDO ATUAL: R$" + saldo);
        }else{
            this.setSaldo(this.getSaldo() - valor);
            saldo = String.format("%.2f", this.getSaldo());
            JOptionPane.showMessageDialog(null, "SAQUE REALIZADO COM EXITO\n SALDO ATUAL: R$" + saldo);
        }
    }
    
    
    @Override
    public void opcoes(){
        int continuar =0;
        String status;
        
        
        if(this.getStatus() == false){
            status = "STATUS DA CONTA: FECHADA";
        } else{
            status = "STATUS DA CONTA: ABERTA";
        }
       
        do{
            int resposta;
            String saldo = String.format("%.2f", this.getSaldo());
            
            String entrada = (JOptionPane.showInputDialog(null,
                "      DETALHES DA CONTA       "
                + "\n==============================\n"
                + "PROPRIETARIO:  " + this.getDono() + "\n" + 
                "NUMERO DA CONTA:  " + this.getNumero() + "\n" + 
                "SALDO ATUAL:  R$" + saldo + "\n" + status
                    + "\nOPCOES"
                    + "\n==============================\n"
                    + "[1] SACAR\n" 
                    + "[2] DEPOSITAR\n"
                    + "[3] FECHAR CONTA\n"
                    + "[4] SAIR DA CONTA\n","informações",1));
            
            if(entrada == null){
                resposta = 4;
            }else{
                resposta = Integer.parseInt(entrada);
            }
            
            switch (resposta){
                
                case 1:
                    this.Sacar();
                break;
                
                case 2:
                    this.Depositar();
                break;
                
                case 3:
                    int option = JOptionPane.showConfirmDialog(null, "Deseja excluir sua conta?", "", 2,2);
                    if(option == 0){
                        this.Fecharconta();
                        if(this.getStatus() == false){
                            continuar = 4;
                        }
                    }else if(option == 2){
                        
                    }
                break;
                
                case 4:
                    continuar = 4;
                    JOptionPane.showMessageDialog(null,"Saindo...","Volte sempre",1);
                break;
                
                default:
                    JOptionPane.showMessageDialog(null, "COMANDO INVALIDO","ERRO",2);
                break;
            }
        }while(continuar != 4);
    }
}
    
    
    

