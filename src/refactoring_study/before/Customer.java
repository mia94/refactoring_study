package refactoring_study.before;

import java.util.ArrayList;
import java.util.List;

public class Customer {
	private String name;
	private List<Rental> rentals = new ArrayList<>();
	
	public Customer() {

	}
	
	public void addRental(Rental aRental) {
		this.rentals.add(aRental);
	}
	
	public Customer(String name) {
		this.name = name;
	}

	public Customer(List<Rental> rentals) {
		this.rentals = rentals;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Rental> getRentals() {
		return rentals;
	}

	public void setRentals(List<Rental> rentals) {
		this.rentals = rentals;
	}
	
	public String statement() {
		
		StringBuilder result = new StringBuilder("<H1><EM>"+getName()+"고객님의 대여 기록</EM></H1><p>\n");
		for(Rental each : rentals) {
			//double thisAmount = each.getCharge();//대행메서드지우고 바로호출, 임시변수 최대한 줄이기 메소드바로호출로 변경
			
			result.append("\t"+each.getMovie().getTitle()+": ");
			result.append("\t"+String.valueOf(each.getCharge())+"<br>\n");
			
		}
		
		//result.append("누적대여료 : "+ String.valueOf(totalAmount)+"\n");
		result.append("<p>누적대여료 : <EM>");
		result.append(String.valueOf(getTotalCharge())+"</EM>\n");
		//result.append("적립 포인트 : " + String.valueOf(frequentRenterPoints));
		result.append("<p>적립 포인트 : <EM>");
		result.append(String.valueOf(getTotalFrequentRentarPoints())+"</EM><p>");
		
		return result.toString();
	}

	private int getTotalFrequentRentarPoints() {
		int result = 0;
		for(Rental rental:rentals) {
			result += rental.getFrequentRentalPoints();
		}
		return result;
	}

	private double getTotalCharge() {
		double result = 0;
		for(Rental rental : rentals) {
			result += rental.getCharge();
		}
		return result;
	}

	/*private int getFrequentRentalPoints(Rental aRental) {
		return aRental.getFrequentRentalPoints();//대행
	}*/

	/* private double amountFor(Rental aRental) {
		return aRental.amountFor();//대행
	}*/
	
}



















