package application;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ResourceBundle;

import com.isteMYSQL.Veritabanı;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

public class TabloGeçmisController {
	public TabloGeçmisController() {
		baglanti = Veritabanı.Baglan();
	}

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;
    
    @FXML
    private TableColumn<Kayıtlar_Geçmis, Double> Urun_Birimfiyat;

    @FXML
    private TableColumn<Kayıtlar_Geçmis, String> Urun_Adı;

    @FXML
    private TableColumn<Kayıtlar_Geçmis, String> Urun_Alankisi;

    @FXML
    private TableColumn<Kayıtlar_Geçmis, String> Urun_Borç;

    @FXML
    private TableColumn<Kayıtlar_Geçmis, Double> Urun_Fiyat;

    @FXML
    private TableColumn<Kayıtlar_Geçmis, String> Urun_Satankisi;

    @FXML
    private TableColumn<Kayıtlar_Geçmis, Integer> Urun_Satılan;

    @FXML
    private TableColumn<Kayıtlar_Geçmis, String> Urun_Tarih;

    @FXML
    private TableColumn<Kayıtlar_Geçmis, String> Urun_Tur;
    
    @FXML
    private TableColumn<Kayıtlar_Geçmis,Integer> Urun_ID;
    
    @FXML
    private TableColumn<Kayıtlar_Geçmis, Double> Urun_odedigi;

    @FXML
    private Button btn_Borç;
    
    @FXML
    private TextField txt_alankisi;

    @FXML
    private TextField txt_odedigi;

    @FXML
    private TableView<Kayıtlar_Geçmis> tableview_geçmis;
    
    Connection baglanti=null;
    PreparedStatement sorgu = null;
    ResultSet getirilen = null;
    String sql1,satan,islemtarih,borçdurum,sql2;
    double borcu,oncedenodenen;
    Integer ID;
    
 
    
    
    public void SqlDoldur(String sql) {	
        DegerGetir(sql);
    	this.sql2 = sql;
    }
    
    public void DegerGetir(String sql) {
    	ObservableList<Kayıtlar_Geçmis> kayıt = FXCollections.observableArrayList();
    	try {
			sorgu = baglanti.prepareStatement(sql);
			ResultSet getirilen = sorgu.executeQuery();
			while (getirilen.next()) {
				kayıt.add(new Kayıtlar_Geçmis(getirilen.getInt("ID"),getirilen.getString("Urun_ad"),getirilen.getDouble("Urun_fiyat"),getirilen.getInt("Urun_sayi"),getirilen.getString("Urun_Tur"),getirilen.getString("Urun_alankisi"),getirilen.getString("Urun_satankisi"),getirilen.getString("Urun_borç"),getirilen.getInt("Urun_Birimfiyat"), getirilen.getDouble("Urun_odedigi") ,getirilen.getString("Urun_tarih")));
				
			}
			Urun_ID.setCellValueFactory(new PropertyValueFactory<>("ID"));
			Urun_Adı.setCellValueFactory(new PropertyValueFactory<>("Urun_ad"));
			Urun_Fiyat.setCellValueFactory(new PropertyValueFactory<>("Urun_fiyat"));
			Urun_Satılan.setCellValueFactory(new PropertyValueFactory<>("Urun_sayi"));
			Urun_Tur.setCellValueFactory(new PropertyValueFactory<>("Urun_tur"));
			Urun_Alankisi.setCellValueFactory(new PropertyValueFactory<>("Urun_alankisi"));
			Urun_Satankisi.setCellValueFactory(new PropertyValueFactory<>("Urun_satankisi"));
			Urun_Birimfiyat.setCellValueFactory(new PropertyValueFactory<>("Urun_Birimfiyat"));
			Urun_Borç.setCellValueFactory(new PropertyValueFactory<>("Urun_borç"));
			Urun_odedigi.setCellValueFactory(new PropertyValueFactory<>("Urun_odedigi"));
			Urun_Tarih.setCellValueFactory(new PropertyValueFactory<>("Urun_tarih"));
			
			
			
			tableview_geçmis.setItems(kayıt);
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
    }

    @FXML
    void btn_Borç_Click(ActionEvent event) {
    	GirişController a = new GirişController();
    	Date bugun =new Date();
    	SimpleDateFormat dateForm = new SimpleDateFormat("MM/dd/Y hh:mm a");
    	if(borcu == Double.valueOf( txt_odedigi.getText()))
			borçdurum = "+";
    	else
    		borçdurum = "-";
    	sql1="update gecmis set Urun_satankisi=? , Urun_borç=?  ,Urun_odedigi=? , Urun_tarih=? where ID=? ";
    	try {
    		sorgu=baglanti.prepareStatement(sql1);
    		sorgu.setString(1,a.kullanıcı + "," + satan );
    		sorgu.setString(2,borçdurum + String.valueOf(borcu - Double.valueOf(txt_odedigi.getText())));
    		sorgu.setDouble(3, oncedenodenen + Double.valueOf(txt_odedigi.getText()));
    		sorgu.setString(4,dateForm.format(bugun) + "," + islemtarih );
    		sorgu.setInt(5,ID);
    		
    		sorgu.executeUpdate();
    		DegerGetir(sql2);
    		
    		
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

    }

    @FXML
    void tableview_geçmis_Click(MouseEvent event) {
    	Kayıtlar_Geçmis kayıt1 = new Kayıtlar_Geçmis();
    	kayıt1 = (Kayıtlar_Geçmis)tableview_geçmis.getItems().get(tableview_geçmis.getSelectionModel().getSelectedIndex());
    	txt_alankisi.setText(kayıt1.getUrun_alankisi());   	
    	txt_odedigi.setText(String.valueOf( Double.valueOf(kayıt1.getUrun_fiyat()) - Double.valueOf(kayıt1.getUrun_odedigi())));
    	oncedenodenen = Double.valueOf(kayıt1.getUrun_odedigi());
    	if(kayıt1.getUrun_fiyat() > kayıt1.getUrun_odedigi())
    			borcu = Double.valueOf(kayıt1.getUrun_fiyat()) - Double.valueOf(kayıt1.getUrun_odedigi());
    	else {
			borcu = 0;
		}
    	ID = kayıt1.getID();
    	satan = kayıt1.getUrun_satankisi();
    	islemtarih = kayıt1.getUrun_tarih();

    }

    @FXML
    void initialize() {
    	
    }

}
