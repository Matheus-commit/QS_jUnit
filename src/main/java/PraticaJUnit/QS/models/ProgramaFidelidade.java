package PraticaJUnit.QS.models;

public class ProgramaFidelidade {

    private String nomeCliente;
    private String cpf;
    private double totalPonto;
    private double saldoCredito;


    public ProgramaFidelidade(String nomeCliente, String cpf) {
        this.nomeCliente = nomeCliente;
        this.cpf = cpf;
        this.totalPonto = 0;
        this.saldoCredito = 0;
    }

    public String getNomeCliente() {
        return nomeCliente;
    }

    public String getCpf() {
        return cpf;
    }

    public double getTotalPonto() {
        return totalPonto;
    }

    public double getSaldoCredito() {
        return saldoCredito;
    }

    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    @Override
    public String toString() {
        return "ProgramaFidelidade{" +
                "nomeCliente='" + nomeCliente + '\'' +
                ", cpf='" + cpf + '\'' +
                ", totalPonto=" + totalPonto +
                ", saldoCredito=" + saldoCredito +
                '}';
    }


    public boolean inserirCredito (double valor){

        if (valor > 0){
            this.saldoCredito += valor;
            return true;
        }

        return false;
    }

    public boolean inserirPontos (int pontos){

        if(pontos > 0){
            this.totalPonto += pontos;
            return true;
        }

        return false;
    }

    public boolean realizarCompraComCredito (double valor){

        if(this.getSaldoCredito()>= valor && valor > 0){

            double x = valor;

            while(x >= 1){

                x--;
                this.totalPonto += 2;
            }
            return true;
        }
        return false;
    }

    public boolean realizarCompraComPontos (double pontos){
         if (this.getTotalPonto() >= pontos && pontos >= 0){
             this.totalPonto -= pontos;
             return true;
         }
         return false;
    }


    public boolean venderPontos(double pontosVenda){
        if(getTotalPonto() >= pontosVenda && pontosVenda > 0){

            double x = pontosVenda;

            while (x >= 1){
                x--;
                this.saldoCredito += 1.50;

            }
            this.totalPonto -= pontosVenda;
            return true;
        }
        return false;
    }

    public boolean transferirPontos(double pontos, ProgramaFidelidade destino){
        if(pontos > 0){
            if(getTotalPonto() >= pontos){
                this.totalPonto -= pontos;
                destino.totalPonto += pontos;
                return true;
            }else
                return false;
        }
        return false;

    }
}
