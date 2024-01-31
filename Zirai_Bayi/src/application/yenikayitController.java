package application;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Random;
import java.util.ResourceBundle;
import java.util.random.RandomGeneratorFactory;

import com.isteMYSQL.Veritabanı;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class yenikayitController {
	public yenikayitController()
	{
		baglanti = Veritabanı.Baglan();
		
	}

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btn_ekle;

    @FXML
    private Label lbl_mesaj1;

    @FXML
    private Label lbl_robotkontrol;

    @FXML
    private TextField txt_kulad;

    @FXML
    private TextField txt_robot;

    @FXML
    private TextField txt_sifre;

    @FXML
    private TextField txt_sifretekrar;
    
    Connection baglanti=null;
    PreparedStatement sorgu = null;
    ResultSet getirilen = null;
    String sql;
    public int sonuç;

    
    @FXML
    void btn_ekle_Click(ActionEvent event) {
    	sql="select * from gi̇ri̇ş where Kullanıcı_AD=?";
    	try {
    		sorgu=baglanti.prepareStatement(sql);
			sorgu.setString(1, txt_kulad.getText().trim());
            ResultSet getirilen = sorgu.executeQuery();
			
			if(!getirilen.next()) {
				if (kontrol()) {
					ekle();
				}
				
			}
			else {
				lbl_mesaj1.setText("kullanıcı adı mevcut");
			}
		}
    	catch (Exception e) {
			System.out.println(e.getMessage());
		}

    }
    
    
    
    public boolean kontrol() {
    	if (txt_kulad.getText() != "" && txt_sifre.getText() !="" && txt_robot.getText() !="" && txt_sifretekrar.getText() !="") {
    		if (txt_sifretekrar.getText().equals(txt_sifre.getText())) {
    			if(sonuç == Integer.valueOf(txt_robot.getText())) {
    				return true;
    			}
    			else {
    				lbl_mesaj1.setText("robotsun");
    				return false;
    			}	
			} else {
				lbl_mesaj1.setText("şifre aynı değil");
				return false;

			}
		}
		else {
			lbl_mesaj1.setText("boş geçme");
			return false;
		}
    	
    }
    
    
    
    public void ekle() {
    	sql="insert into gi̇ri̇ş (Kullanıcı_AD,Sıfre,Yetki) values(?,?,?)";
    	try {
    		sorgu=baglanti.prepareStatement(sql);
    		sorgu.setString(1, txt_kulad.getText().trim());
    		sorgu.setString(2, txt_sifre.getText().trim());
    		sorgu.setString(3, "2");
    		sorgu.executeUpdate();
    		lbl_mesaj1.setText("işlem başarılı");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
    }
    public void RobotMu() {
    	int sayi1;
    	int sayi2;
    	Random rd = new Random();
    	sayi1 = rd.nextInt(100);
    	sayi2 = rd.nextInt(100);
    	sonuç = sayi1 + sayi2;
    	lbl_robotkontrol.setText(String.valueOf(sayi1 + "+" + sayi2));
    
    }

    @FXML
    void initialize() {
       RobotMu();

    }

}
