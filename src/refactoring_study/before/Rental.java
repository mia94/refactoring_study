package refactoring_study.before;

public class Rental {

	private Movie movie;
	private int daysRented;
	
	
	public Rental(Movie aMovie, int aDaysRented) {
		this.movie = aMovie;
		this.daysRented = aDaysRented;
	}
	
	public Movie getMovie() {
		return this.movie;
	}
	
	public int getDaysRented() {
		return this.daysRented;
	}
	
	public double getCharge() {//�޼ҵ� Rental�� �ű�鼭 �Ű�����(����) ����, �޼ҵ��̸� ����
		double result = 0;// �޼ҵ� ���鼭 ���� ������ ��������
		switch(getMovie().getPriceCode()) {
		case Movie.REGULAR:
			result += 2;
			if(getDaysRented()>2) {
				result += (getDaysRented()-2)*1.5;
			}
			break;
		case Movie.NEW_RELEASE:
			result += getDaysRented()*3;
			break;
		case Movie.CHILDRENS:
			result += 1.5;
			if(getDaysRented()>3) {
				result += (getDaysRented()-3)*1.5;
			}
			break;
		}
		return result;
	}
	
	public int getFrequentRentalPoints() {
		//�Ϲ��� 1 �ֽ��� 2
		if((getMovie().getPriceCode()==Movie.NEW_RELEASE) && getDaysRented()>1) {
			return 2;
		}else {
			return 1;
		}
	}

}
