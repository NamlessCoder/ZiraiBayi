package application;

public class Kayıtlar_Geçmis {
	private int ID;
	private String Urun_ad;
	private Double Urun_fiyat;
	private int Urun_sayi;
	private String Urun_tur;
	private String Urun_alankisi;
	private String Urun_satankisi;
	private String Urun_borç;
	private int Urun_Birimfiyat;
	private Double urun_odedigi;
	private String Urun_tarih;

	
	public Kayıtlar_Geçmis() {
		
	}
	
    public Kayıtlar_Geçmis(Integer ID,String Urun_ad,Double Urun_fiyat,int Urun_sayi,String Urun_tur,String Urun_alankisi,String Urun_satankisi,String Urun_borç,int Urun_Birimfiyat, Double urun_odedigi ,String Urun_tarih) {
    	this.ID=ID;
		this.Urun_ad = Urun_ad;
		this.Urun_fiyat = Urun_fiyat;
		this.Urun_sayi = Urun_sayi;
		this.Urun_tur = Urun_tur;
		this.Urun_alankisi = Urun_alankisi;
		this.Urun_satankisi = Urun_satankisi;
		this.Urun_borç = Urun_borç;
		this.Urun_Birimfiyat = Urun_Birimfiyat;
		this.urun_odedigi = urun_odedigi;
		this.Urun_tarih = Urun_tarih;
	}

	public int getUrun_Birimfiyat() {
		return Urun_Birimfiyat;
	}

	public void setUrun_Birimfiyat(int urun_Birimfiyat) {
		Urun_Birimfiyat = urun_Birimfiyat;
	}

	public String getUrun_ad() {
		return Urun_ad;
	}

	public void setUrun_ad(String urun_ad) {
		Urun_ad = urun_ad;
	}

	public Double getUrun_fiyat() {
		return Urun_fiyat;
	}

	public void setUrun_fiyat(Double urun_fiyat) {
		Urun_fiyat = urun_fiyat;
	}

	public int getUrun_sayi() {
		return Urun_sayi;
	}

	public void setUrun_sayi(int urun_sayi) {
		Urun_sayi = urun_sayi;
	}

	public String getUrun_tur() {
		return Urun_tur;
	}

	public void setUrun_tur(String urun_tur) {
		Urun_tur = urun_tur;
	}

	public String getUrun_alankisi() {
		return Urun_alankisi;
	}

	public void setUrun_alankisi(String urun_alankisi) {
		Urun_alankisi = urun_alankisi;
	}

	public String getUrun_satankisi() {
		return Urun_satankisi;
	}

	public void setUrun_satankisi(String urun_satankisi) {
		Urun_satankisi = urun_satankisi;
	}

	public String getUrun_borç() {
		return Urun_borç;
	}

	public void setUrun_borç(String urun_borç) {
		Urun_borç = urun_borç;
	}

	public String getUrun_tarih() {
		return Urun_tarih;
	}

	public void setUrun_tarih(String urun_tarih) {
		Urun_tarih = urun_tarih;
	}

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public Double getUrun_odedigi() {
		return urun_odedigi;
	}

	public void setUrun_odedigi(Double urun_odedigi) {
		this.urun_odedigi = urun_odedigi;
	}

	
	
	

}
