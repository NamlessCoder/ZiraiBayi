package application;

public class Kayıtlar_Giris {
	private int ID;
	private String kulad;
	private String sifre;
	private int yetki;
	
	
	public Kayıtlar_Giris() {
		yetki = 2;
	}
	
	public Kayıtlar_Giris(int ıd,String kulad,String sifre,int yetki) {
		this.ID = ıd;
		this.kulad=kulad;
		this.sifre=sifre;
		this.yetki = yetki;
	}

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public String getKulad() {
		return kulad;
	}

	public void setKulad(String kulad) {
		this.kulad = kulad;
	}

	public String getSifre() {
		return sifre;
	}

	public void setSifre(String sifre) {
		this.sifre = sifre;
	}

	public int getYetki() {
		return yetki;
	}

	public void setYetki(int yetki) {
		this.yetki = yetki;
	}

}
