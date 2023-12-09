package com.example.exampleplaterecognition;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

public class scan_result extends AppCompatActivity {

    TextView resultText,daerahText;
    ImageButton kembalibutton;
    ImageView resultphoto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.scan_result);

        Intent intent = getIntent();
        String detectedText = intent.getStringExtra("DETECTED_TEXT");
        Bitmap croppedImage = intent.getParcelableExtra("RAW_IMAGE");

        // Tampilkan string di layout lain
        resultText = findViewById(R.id.platnomorresulttext);
        resultText.setText(detectedText);

        if (detectedText != null && detectedText.contains(" ")) {
            String platNomor = detectedText.split(" ")[0]; // Ambil huruf sebelum spasi
            String daerah = deteksiDaerah(platNomor);
            daerahText = findViewById(R.id.daerahresulttext);
            daerahText.setText(daerah);

        }


        resultphoto = findViewById(R.id.scanresultimage);
        resultphoto.setImageBitmap(croppedImage);

        kembalibutton = findViewById(R.id.kembalibutton);
        kembalibutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Start a new activity when the button is clicked
                Intent newIntent = new Intent(scan_result.this, main_menu.class); // Replace with your new activity class
                startActivity(newIntent);
            }
        });
    }
    // Metode untuk mendeteksi daerah berdasarkan plat nomor
    private String deteksiDaerah(String platNomor) {
        // Misalnya, tambahkan kondisi berdasarkan huruf tertentu
        if (platNomor.equals("A")) {
            return "Tangerang, Cilegon, Lebak, Serang, dan Pandeglang";
        } else if (platNomor.equals("AA")) {
            return "Kedu, Purworejo, Temanggung, Magelang, Wonosobo, dan Kebumen";
        }else if (platNomor.equals("B")) {
            return "Bekasi, Tangerang, Tangerang Selatan, Depok, dan Bekasi";
        }else if (platNomor.equals("AD")) {
            return "Boyolali, Klaten, Wonogiri, Sukoharjo, Surakarta, Karanganyar, dan Sragen";
        }else if (platNomor.equals("K")) {
            return "Cepu, Pati, Kudus, Jepara, Grobogan, Rembang, dan Blora";
        }else if (platNomor.equals("R")) {
            return "Banjarnegara, Banyumas, Cilacap, dan Purbalingga";
        }else if (platNomor.equals("G")) {
            return "Brebes, Pemalang, Batang, Tegal, dan Pekalongan";
        }else if (platNomor.equals("H")) {
            return "Salatiga, Semarang, Kendal, dan Demak";
        }else if (platNomor.equals("AG")) {
            return "Tulungagung, Kediri, Blitar, Trenggalek, dan Nganjuk";
        }else if (platNomor.equals("AE")) {
            return "Ngawi, Madiun, Pacitan, Ponorogo, dan Magetan";
        }else if (platNomor.equals("L")) {
            return "Surabaya";
        }else if (platNomor.equals("M")) {
            return "Bangkalan, Sampang, Sumenep, dan Pamekasan";
        }else if (platNomor.equals("N")) {
            return "Malang, Pasuruan, Probolinggo, Batu, dan Lumajang";
        }else if (platNomor.equals("S")) {
            return "Tuban, Jombang, Bojonegoro, Lamongan, dan Mojokerto";
        }else if (platNomor.equals("W")) {
            return "Gresik dan Sidoarjo";
        }else if (platNomor.equals("AB")) {
            return "Yogyakarta, Bantul, Gunung Kidul, dan Kulon Progo";
        }else if (platNomor.equals("KU")) {
            return "Kalimantan Utara";
        }else if (platNomor.equals("KT")) {
            return "YKalimantan Timur";
        }else if (platNomor.equals("KH")) {
            return "Kalimantan Tengah";
        }else if (platNomor.equals("DA")) {
            return "Kalimantan Selatan";
        }else if (platNomor.equals("BA")) {
            return "Sumatra Barat";
        }else if (platNomor.equals("BD")) {
            return "Bengkulu";
        }else if (platNomor.equals("BB")) {
            return "Sumatra Utara bagian barat";
        }else if (platNomor.equals("BE")) {
            return "Lampung";
        }else if (platNomor.equals("BG")) {
            return "Sumatra Selatan";
        }else if (platNomor.equals("BH")) {
            return "Jambi";
        }else if (platNomor.equals("BK")) {
            return "Sumatra Utara bagian timur";
        }else if (platNomor.equals("BL")) {
            return "Aceh";
        }else if (platNomor.equals("BM")) {
            return "Riau";
        }else if (platNomor.equals("BN")) {
            return "Bangka Belitung";
        }else if (platNomor.equals("BP")) {
            return "Kepulauan Riau";
        }else if (platNomor.equals("D")) {
            return "Bandung, Bandung Barat, dan Cimahi";
        }else if (platNomor.equals("F")) {
            return "Bogor, Sukabumi, dan Cianjur";
        }else if (platNomor.equals("EP")) {
            return "Kuningan, Cirebon, Majalengka, dan Indramayu";
        }else if (platNomor.equals("Z")) {
            return "Banjar, Garut, Ciamis, Tasikmalaya, dan Sumedang";
        }else if (platNomor.equals("T")) {
            return "Subang, Purwakarta, dan Karawang";
        }else if (platNomor.equals("DC")) {
            return "Sulawesi Barat";
        }else if (platNomor.equals("DD")) {
            return "Sulawesi Selatan";
        }else if (platNomor.equals("DN")) {
            return "Sulawesi Tengah";
        }else if (platNomor.equals("DT")) {
            return "Sulawesi Tenggara";
        }else if (platNomor.equals("DL")) {
            return "Sitaro, Talaud, dan Sangihe";
        }else if (platNomor.equals("DM")) {
            return "Gorontalo";
        }else if (platNomor.equals("DB")) {
            return "Bolaang Mongondow, Bolaang Mongondow Timur, Bolaang Mongondow Selatan, Manado, Tomohon, Minahasa, dan Bitung";
        }else if (platNomor.equals("DK")) {
            return "Bali";
        }else if (platNomor.equals("ED")) {
            return "Sumba Timur dan Sumba Barat";
        }else if (platNomor.equals("EA")) {
            return "Sumbawa, Bima, Dompu, dan Sumbawa Barat";
        }else if (platNomor.equals("EB")) {
            return "Alor, Lembata, Sikka, Ende, Ngada, Flores Timur, Flores, Manggarai, dan Manggarai Barat";
        }else if (platNomor.equals("DH")) {
            return "Rote Ndao, Kupang, Timor, Timor Tengah Selatan, dan Timor Tengah Utara";
        }else if (platNomor.equals("DR")) {
            return "Lombok, Lombok Tengah, Lombok Timur, Lombok Barat, dan Mataram";
        }else if (platNomor.equals("DE")) {
            return "Maluku";
        }else if (platNomor.equals("DG")) {
            return "Maluku Utara";
        }else if (platNomor.equals("PA")) {
            return "Papua";
        }else if (platNomor.equals("PB")) {
            return "Papua Barat";
        }
        // Tambahkan kondisi lain jika diperlukan
        return "Daerah Tidak Terdeteksi";
    }

}
