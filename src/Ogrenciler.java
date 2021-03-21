import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Ogrenciler {

    public static int id = 1000;
    private String ogrenciid;
    private String isim ;
    private String soyad ;
    private int sınıf ;
    private String dersler = "";
    private static int dersucreti = 600;
    private int bakiye ;

    //Benzersiz öğrenci numarası oluşturuyor.
    public void setogrenciid() {
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

        setogrenciid();

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

            ogrenciBilgi.put(o.ogrenciid,o.toString());
            System.out.println("Yeni öğrenci girmeyecekseniz S'ye basınız.");
            System.out.println("Yeni öğreni girecekseniz Enter'a basınız.");
            durdurma =scan.nextLine();
        }
    }
    public static void getOgrenciNumarası() {
        Scanner scan =new Scanner(System.in);
        String ogrencinumarasi= "";
        String sonuc= "";

        do {
            System.out.println("Öğrencinin numarasını giriniz ");
            System.out.println("Çıkış yapmak için X'e basınız.");
            ogrencinumarasi = scan.nextLine();
            sonuc = ogrenciBilgi.get(ogrencinumarasi);


            if(!ogrencinumarasi.equals("X")) {
                System.out.println(sonuc);
            }
        }while(!ogrencinumarasi.equals("X"));
    }





}
