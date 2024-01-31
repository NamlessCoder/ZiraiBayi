package application;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ResourceBundle;
import java.util.Date;
import com.isteMYSQL.Veritabanı;
import com.mysql.cj.protocol.Message;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.InputMethodEvent;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

public class urunlerController {
	
	public urunlerController() {
		baglanti=Veritabanı.Baglan();
	}

    @FXML
    private ResourceBundle resources;
    
    @FXML
    private AnchorPane anchor_satıs;

    @FXML
    private AnchorPane anchor_stokekleme;
    
    @FXML
    private URL location;
    
    @FXML
    private Button btn_stokekle;
    
    @FXML
    private Button btn_stokGüncelle;
    
    @FXML
    private Button btn_stosil;

    @FXML
    private Button btn_satinal;
    
    @FXML
    private ComboBox<String> combobox_tur;
    
    @FXML
    private ComboBox<String> combobox_Etki;

    @FXML
    private Label lbl_hakkında;
    
    @FXML
    private TableColumn<Kayıtlar_Urun, String> table_Tur;
    
    @FXML
    private TableColumn<Kayıtlar_Urun, Integer> table_UID;

    @FXML
    private TableColumn<Kayıtlar_Urun, String> table_aciklama;

    @FXML
    private TableColumn<Kayıtlar_Urun, String> table_urunad;

    @FXML
    private TableColumn<Kayıtlar_Urun, Double> table_urunfiyat;

    @FXML
    private TableColumn<Kayıtlar_Urun, Integer> table_urunstok;

    @FXML
    private TableView<Kayıtlar_Urun> tableview_kayıtlar;
    
    @FXML
    private TextField txt_Alankisi;
    
    @FXML
    private TextField txt_Odedigi;

    @FXML
    private TextField txt_fiyat;

    @FXML
    private TextField txt_sayi;
    
    @FXML
    private TextField txt_stok;
    
    @FXML
    private TextField txt_eklenenfiyat;
    
    @FXML
    private TextField txt_Urun_AD;
    
    @FXML
    private TextField txt_urunad;
    
    Connection baglanti=null;
    PreparedStatement sorgu = null;
    ResultSet getirilen = null;
    String sql1;
    String tur;
    int urunıd,gelen;
    int stok;
    String sql,urunad,borç;
   
   
    public void Anchordoldur(int gelen) {
    	if(gelen == 2)
    		anchor_stokekleme.setVisible(true);
    	else if(gelen == 1)
    		anchor_satıs.setVisible(true);
    	this.gelen = gelen;
    }
    
    public void SqlDoldur(String sql) {	
        DegerGetir(sql);
    	this.sql = sql;
    }
    
    public void DegerGetir(String sql) {
    	ObservableList<Kayıtlar_Urun> kayıt = FXCollections.observableArrayList();
    	try {
			sorgu = baglanti.prepareStatement(sql);
			ResultSet getirilen = sorgu.executeQuery();
			
			while (getirilen.next()) {
				kayıt.add(new Kayıtlar_Urun(getirilen.getInt("UID"),getirilen.getString("Urun_Ad"),getirilen.getDouble("Urun_fiyat"),getirilen.getInt("Urun_stok"),getirilen.getString("Urun_Tur"),getirilen.getString("Urun_Acıklama")));
				
			}
			table_UID.setCellValueFactory(new PropertyValueFactory<>("UID"));
			table_urunad.setCellValueFactory(new PropertyValueFactory<>("Urun_Ad"));
			table_urunfiyat.setCellValueFactory(new PropertyValueFactory<>("Urun_fiyat"));
			table_urunstok.setCellValueFactory(new PropertyValueFactory<>("Urun_stok"));
			table_Tur.setCellValueFactory(new PropertyValueFactory<>("Urun_tur"));
			table_aciklama.setCellValueFactory(new PropertyValueFactory<>("Urun_Aciklama"));
			
			tableview_kayıtlar.setItems(kayıt);
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
    }
    
    public void Güncelle() {
    	sql1 = "update urunler set Urun_stok=? where UID=? ";
    	try {
    		sorgu=baglanti.prepareStatement(sql1);
    		sorgu.setInt(1, stok - Integer.valueOf(txt_sayi.getText()));
    		sorgu.setInt(2, urunıd);
    	
    		sorgu.executeUpdate();	
    		
		}
    	catch (Exception e) {
			System.out.println(e.getMessage());
		}
    }
   
    @FXML
    void btn_satinal_Click(ActionEvent event) {
    	GirişController a = new GirişController();
    	Date bugun =new Date();
    	SimpleDateFormat dateForm = new SimpleDateFormat("MM/dd/Y hh:mm a");
    	
    	if(kontrol()) {
    		if(Double.valueOf(txt_Odedigi.getText()) == Double.valueOf(txt_sayi.getText()) * Double.valueOf(txt_fiyat.getText()))
        		borç = "+";
        	else {
        		borç = "-";
    		}
    		try {
    	    	sql1="insert into gecmis (Urun_ad,Urun_fiyat,Urun_sayi,Urun_tur,Urun_alankisi,Urun_satankisi,Urun_borç,Urun_Birimfiyat,Urun_odedigi,Urun_tarih) values(?,?,?,?,?,?,?,?,?,?)";
        		sorgu=baglanti.prepareStatement(sql1);
        		sorgu.setString(1, urunad);
        		sorgu.setDouble(2,Double.valueOf(txt_sayi.getText()) * Double.valueOf(txt_fiyat.getText()));
        		sorgu.setInt(3, Integer.valueOf(txt_sayi.getText()));
        		sorgu.setString(4, tur);
        		sorgu.setString(5, txt_Alankisi.getText().trim());
        		sorgu.setString(6, a.kullanıcı);
        		sorgu.setString(7, borç + String.valueOf(Double.valueOf(txt_sayi.getText()) * Double.valueOf(txt_fiyat.getText()) - Double.valueOf(txt_Odedigi.getText())));
        		sorgu.setDouble(8,Double.valueOf(txt_fiyat.getText()));
        		sorgu.setDouble(9, Double.valueOf(txt_Odedigi.getText()));
        		sorgu.setString(10, dateForm.format(bugun));
        			
        		sorgu.executeUpdate();	
        		Güncelle();
        		DegerGetir(sql);
        		lbl_hakkında.setText("İŞLEM BAŞARILI...");
    		}
        	catch (Exception e) {
    			System.out.println(e.getMessage());
    			lbl_hakkında.setText("İŞLEM BAŞARISIZ...");
    		}
    	}
    	else {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Zirai Bayi Otomasyonu");
			alert.setHeaderText("Hata boş alan bırakmayınız");
			alert.showAndWait();
		}
    

    

    }
    
    @FXML
    void btn_stokekle_Click(ActionEvent event) {
    	if(kontrol()) {
    		sql1="insert into urunler (Urun_ad,Urun_fiyat,Urun_stok,Urun_Tur,Urun_Acıklama) values(?,?,?,?,?)";
        	try {
    			sorgu = baglanti.prepareStatement(sql1);
    			sorgu.setString(1,txt_urunad.getText());
    			sorgu.setDouble(2, Double.valueOf(txt_eklenenfiyat.getText()));
    			sorgu.setInt(3, Integer.valueOf(txt_stok.getText()));
    			sorgu.setString(4, combobox_tur.getSelectionModel().getSelectedItem());
    			sorgu.setString(5, combobox_Etki.getSelectionModel().getSelectedItem());
    			
    			sorgu.executeUpdate();
    			DegerGetir(sql);
    			
    		} catch (Exception e) {
    			System.out.println(e.getMessage());
    		}
    	}
    	else {
    		Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Zirai Bayi Otomasyonu");
			alert.setHeaderText("Hata boş alan bırakmayınız");
			alert.showAndWait();
		}
    	

    }
    

    @FXML
    void btn_stokGüncelle_Click(ActionEvent event) {
    	if(kontrol()) {
    		sql1 = "update urunler set Urun_ad=? , Urun_fiyat=? , Urun_stok=? , Urun_Tur=? , Urun_Acıklama=? where UID=?";
        	try {
        		sorgu = baglanti.prepareStatement(sql1);
        		sorgu.setString(1, txt_urunad.getText());
        		sorgu.setDouble(2, Double.valueOf(txt_eklenenfiyat.getText()));
        		sorgu.setInt(3,Integer.valueOf(txt_stok.getText()));
        		sorgu.setString(4, combobox_tur.getSelectionModel().getSelectedItem());
        		sorgu.setString(5, combobox_Etki.getSelectionModel().getSelectedItem());
        		sorgu.setInt(6,urunıd);
        		
        		sorgu.executeUpdate();
        		DegerGetir(sql);
    		} catch (Exception e) {
    		  System.out.println(e.getMessage());
    		}
    	}
    	else {
    		Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Zirai Bayi Otomasyonu");
			alert.setHeaderText("Hata boş alan bırakmayınız");
			alert.showAndWait();
		}
    	
    	
    }
    
    @FXML
    void btn_stosil_Click(ActionEvent event) {
    	if(kontrol()) {
    		sql1="delete from urunler where UID=?";
        	try {
    			sorgu = baglanti.prepareStatement(sql1);
    			sorgu.setInt(1, urunıd);
    			
    			sorgu.executeUpdate();
    			DegerGetir(sql);
    			
    		} catch (Exception e) {
    			e.getMessage();
    		}

    	}
    	else {
    		Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Zirai Bayi Otomasyonu");
			alert.setHeaderText("Hata boş alan bırakmayınız");
			alert.showAndWait();
		}
    	
    }

    

    @FXML
    void tableview_Click(MouseEvent event) {
    	Kayıtlar_Urun kayıt = new Kayıtlar_Urun();
    	kayıt = (Kayıtlar_Urun) tableview_kayıtlar.getItems().get(tableview_kayıtlar.getSelectionModel().getSelectedIndex());
    	if(gelen == 1) {
    		txt_Urun_AD.setText(kayıt.getUrun_Ad());
        	txt_fiyat.setText(String.valueOf(kayıt.getUrun_fiyat()));
        	txt_sayi.setText(String.valueOf(kayıt.getUrun_stok()));
        	TutarHesapla();
        	
    	}
    	else {
    		txt_urunad.setText(kayıt.getUrun_Ad());
    		txt_eklenenfiyat.setText(String.valueOf(kayıt.getUrun_fiyat()));
    		txt_stok.setText(String.valueOf(kayıt.getUrun_stok()));
    		combobox_tur.getSelectionModel().select(kayıt.getUrun_tur());
    		combobox_Etki.getSelectionModel().select(kayıt.getUrun_Aciklama());
		}
    	tur = kayıt.getUrun_tur();
    	urunıd = kayıt.getUID();
    	urunad = kayıt.getUrun_Ad();
    	stok = kayıt.getUrun_stok();
    	

    }
    
    
    
    public void TutarHesapla() {
    	if(txt_fiyat.getText() !="" && txt_sayi.getText() != "") {
    		double tutar = Double.valueOf(txt_fiyat.getText()) * Double.valueOf(txt_sayi.getText());
        	txt_Odedigi.setText( String.valueOf(tutar));
    	}
    	else {
			
		}
    	
    }
    
    @FXML
    void txt_fiyatChange(KeyEvent event) {
    	TutarHesapla();

    }

    @FXML
    void txt_sayısıChange(KeyEvent event) {
    	TutarHesapla();

    }
    public boolean kontrol() {
    	if(this.gelen == 1) {
    		if(txt_Urun_AD.getText().isEmpty() || txt_Alankisi.getText().isEmpty() || txt_sayi.getText().toString().isEmpty() || txt_fiyat.getText().toString().isEmpty()) {
    			return false;
    			
    		}
    		else {
    			return true;
			}
    		
    	}
    	else if(this.gelen == 2) {
    		if(txt_urunad.getText().isEmpty() || txt_stok.getText().toString().isEmpty() || txt_eklenenfiyat.getText().toString().isEmpty() || combobox_tur.getSelectionModel().selectedItemProperty().equals("") || combobox_Etki.getSelectionModel().selectedItemProperty().equals("")) {
    			return false;
    		}
    		else {
    			return true;
			}
    	}
    	else {
			return true;
		}
    	
    	
    }

    @FXML
    void initialize() {
    	txt_Odedigi.setText(String.valueOf(0));
    	
    	String[] tur = {"h","g","i"};
    	combobox_tur.getItems().addAll(tur);
    	
    	String[] etki = {"böcek","mantar","ot"};
        combobox_Etki.getItems().addAll(etki);
    }

}

