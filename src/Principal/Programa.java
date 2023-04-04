package Principal;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;

import entities.BrazilTaxService;
import entities.CarRental;
import entities.RentalService;
import entities.Vehicle;

public class Programa {
	
	public static void main (String[] args) {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
		
		System.out.println("Entre com os dados do aluguel");
		System.out.println("Modelo do carro:");
		String carro = sc.nextLine();
		
		System.out.println("Retirada (dd/MM/yyyy hh:mm) :" );
		LocalDateTime  start = LocalDateTime.parse(sc.nextLine(),fmt);
		
		System.out.println("Entrega (dd/MM/yyyy hh:mm) :");
		LocalDateTime finish = LocalDateTime.parse(sc.nextLine(),fmt);
		
		CarRental cr = new CarRental(start,finish,new Vehicle(carro));
		
		
		System.out.println("Entre com o valor por hora");
		Double valorHora = sc.nextDouble();
		System.out.println("Entre com o valor por dia");
		Double valorDia = sc.nextDouble();
		
		RentalService rc = new RentalService(valorHora,valorDia,new BrazilTaxService());
		rc.processInvoice(cr);
		System.out.println("FATURA");
		System.out.println("Pagamento basico" + cr.getInvoice().getBasicPayment());
		System.out.println("Imposto" + cr.getInvoice().getTax());
		System.out.println("Pagamento Total : "+ cr.getInvoice().getTotalPayment());
		
		
		
		
		
		
		
		
		sc.close();
	}

}
