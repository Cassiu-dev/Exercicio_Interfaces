package entities;

import java.time.Duration;

public class RentalService {
	
	private Double pricePerHour;
	private Double pricePerDay;
	
	private BrazilTaxService taxService;
	
	
	



	public RentalService(Double pricePerHour, Double pricePerDay, BrazilTaxService taxService) {
		
		this.pricePerHour = pricePerHour;
		this.pricePerDay = pricePerDay;
		this.taxService = taxService;
	}

	
	





	public Double getPricePerHour() {
		return pricePerHour;
	}








	public void setPricePerHour(Double pricePerHour) {
		this.pricePerHour = pricePerHour;
	}








	public Double getPricePerDay() {
		return pricePerDay;
	}








	public void setPricePerDay(Double pricePerDay) {
		this.pricePerDay = pricePerDay;
	}








	public BrazilTaxService getTaxService() {
		return taxService;
	}








	public void setTaxService(BrazilTaxService taxService) {
		this.taxService = taxService;
	}








	public void processInvoice(CarRental carRental) {
		Double minutes = (double) Duration.between(carRental.getStart(), carRental.getFinish()).toMinutes();
		
		Double horas = minutes/60;
		Double basicPayment;
		Double dias = horas /24;
		if(horas <= 12) {
			basicPayment = pricePerHour * Math.ceil(horas);
		}else {
			basicPayment =pricePerDay*Math.ceil(dias);
		}
		
		Double tax = taxService.tax(basicPayment);
		
		carRental.setInvoice(new Invoice(basicPayment, tax));
	}

}
