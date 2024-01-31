package application;

public class Kayıtlar_Urun {
	private int UID;
	private String Urun_Ad;
	private Double Urun_fiyat;
	private int Urun_stok;
	private String Urun_tur;
	private String Urun_Aciklama;
	
	public Kayıtlar_Urun() {
		
	}
	public Kayıtlar_Urun(int Uıd,String urun_Ad,Double urun_fiyat,int urun_stok,String urun_tur,String urun_Aciklama) {
		this.UID=Uıd;
		this.Urun_Ad=urun_Ad;
		this.Urun_fiyat=urun_fiyat;
		this.Urun_stok=urun_stok;
		this.Urun_tur=urun_tur;
		this.Urun_Aciklama=urun_Aciklama;
		
	}


	public String getUrun_tur() {
		return Urun_tur;
	}


	public void setUrun_tur(String urun_tur) {
		Urun_tur = urun_tur;
	}


	public int getUID() {
		return UID;
	}


	public void setUID(int uID) {
		UID = uID;
	}


	public String getUrun_Ad() {
		return Urun_Ad;
	}


	public void setUrun_Ad(String urun_Ad) {
		Urun_Ad = urun_Ad;
	}


	public Double getUrun_fiyat() {
		return Urun_fiyat;
	}


	public void setUrun_fiyat(Double urun_fiyat) {
		Urun_fiyat = urun_fiyat;
	}


	public int getUrun_stok() {
		return Urun_stok;
	}


	public void setUrun_stok(int urun_stok) {
		Urun_stok = urun_stok;
	}


	public String getUrun_Aciklama() {
		return Urun_Aciklama;
	}


	public void setUrun_Aciklama(String urun_Aciklama) {
		Urun_Aciklama = urun_Aciklama;
	}

}
