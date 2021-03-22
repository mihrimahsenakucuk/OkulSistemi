import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Ogrenciler {

    public static int id = 1000;
    private static String ogrenciid;
    private String isim ;
    private String soyad ;
    private int sınıf ;
    private String dersler = "";
    private static int dersucreti = 600;
    private int bakiye ;

    //Benzersiz öğrenci numarası oluşturuyor.
    public void ogrenciId() {
        id++;
        this.ogrenciid= sınıf + "" + id ;
    }


    public Ogrenciler() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Öğrenci adını giriniz.");
        this.isim= scan.nextLine();
        System.out.println("Öğrencinin soyadını giriniz.");
        this.soyad= scan.nextLine();
        System.out.println("Öğrencinin sınıfını giriniz.");
        System.out.println("1.Sınıf");
        System.out.println("2.Sınıf");
        System.out.println("3.Sınıf");
        System.out.println("4.Sınıf");
        this.sınıf= scan.nextInt();

        ogrenciId();

    }

    public void kayıt() {
        do {
            Scanner scan = new Scanner(System.in);
            System.out.println("Kaydolmak istediğiniz dersi giriniz. (Çıkış için Q)");
            String alinanders= scan.nextLine();
		
            if(!alinanders.equals("Q")) {
                dersler = dersler + "\n" + alinanders ;
                bakiye = bakiye + dersucreti ;

            }else {
                break;
            }

        }while(true);
        System.out.println("Kayıt olunan ders: " + dersler);

    }

    public void odeme() {
        System.out.println("Borcunuz: " + bakiye + "TL" );
        Scanner scan = new Scanner(System.in);
        System.out.println("Ne kadar ödemek istiyorsunuz?");
        int odenentutar= scan.nextInt();
	    
        bakiye = bakiye - odenentutar;
	    
        System.out.println("Ödemeniz tamamlandı" + odenentutar);
        System.out.println("Kalan borcunuz: " + bakiye);
	
	ogrenciId();
    }

    public String toString() {
        return   "ÖGRENCİ NUMARASI: " + ogrenciid +
                "\nÖGRENCİ ADI: " + isim + " " + soyad +
                "\nSINIF: " + sınıf +
                "\nDERSLER: " + dersler +
                "\nÖDENECEK TUTAR: " + bakiye ;
    }

    static Map<String , String> ogrenciBilgi = new HashMap<>();

    public static void OgrenciMapEkleme() {
        Scanner scan = new Scanner(System.in);
        String durdurma= "";
        while(!durdurma.equals("S")) {
            Ogrenciler o = new Ogrenciler();
            o.kayıt();
            o.odeme();
            ogrenciBilgi.put(o.ogrenciid,o.toString());
            System.out.println("Yeni öğrenci girmeyecekseniz S'ye basınız.");
            System.out.println("Yeni öğreni girecekseniz Enter'a basınız.");
            durdurma =scan.nextLine();
        }
        secenekler();
    }
    
    public static void ogrenciBilgileri() {
		 Scanner scan =new Scanner(System.in);
		 String ogrencinumarasi= "";
		 String sonuc= "";
		 
		 do {
			 System.out.println("Öğrencinin numarasını giriniz ");
		     System.out.println("Çıkış yapmak için X'e basınız.");
		     
		     ogrencinumarasi = scan.nextLine();
		     sonuc = ogrenciBilgi.get(ogrenciid);
		     
		     
		     if(!ogrencinumarasi.equals("X")) {
		    	 System.out.println(sonuc);
		       }
		 }while(!ogrencinumarasi.equals("X"));
		 
		 secenekler();
	 }
	
	 public static void ogrenciSilme() {
		 Scanner scan = new Scanner(System.in);
		 String ogrencinumarasi="";
		 String sonuc=""; 
		 
		 do {
			 System.out.println("Silmek istediğiniz öğrencinin numarasını giriniz.");
		     System.out.println("Çıkış yapmak için X'e basınız.");
		 
		 if (!ogrencinumarasi.equals("X") ) {
			 System.out.println(sonuc);
			 System.out.println("Öğrenci silindi");
		 }
		 }while(!ogrencinumarasi.equals("X"));
		 
		 secenekler();
	 }
	 
	 
	 public static void secenekler() {
		 System.out.println("Seçenekler:");
		 System.out.println("1:Öğrenci ekleme");
		 System.out.println("2:Öğrenci numarasını gösterme");
		 System.out.println("3:Öğrenci numarasını silme");
		 
		 Scanner scan = new Scanner(System.in);
		 int secenek = scan.nextInt();
		 
		 switch(secenek) {
		 case 1 : 
			 OgrenciMapEkleme();
			 break;
		 case 2 :
			 ogrenciBilgileri();
			 break;
		 case 3 :
			 ogrenciSilme();
			 break;
		 default:
			 System.out.println("Geçersiz seşim.1,2 ya da 3'ü seçiniz.Başka");
		 }
		 secenekler();
	 }
	
	 

}
