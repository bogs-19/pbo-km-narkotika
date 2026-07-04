# ⚖️ KMS Putusan Pengadilan Narkotika

## 📝 Deskripsi Proyek
Aplikasi ini adalah *Knowledge Management System* (KMS) berbasis Java yang dirancang khusus untuk mengelola dan menganalisis Putusan Pengadilan Narkotika. Aplikasi ini dibangun dengan mengimplementasikan konsep *Object Oriented Programming* (OOP) secara penuh dan dipisahkan secara terstruktur menggunakan pola arsitektur **MVC (Model-View-Controller)**.

Sistem ini dirancang untuk memproses dataset berskala menengah, memanfaatkan 547 file PDF putusan pengadilan pidana narkotika (Pid.Sus) dari berbagai Pengadilan Negeri di Indonesia (terutama PN Surabaya), tahun 2024–2025. 

Proyek ini dikembangkan oleh mahasiswa program studi Informatika Universitas Muhammadiyah Malang sebagai pemenuhan Tugas Besar Mata Kuliah Pemrograman Berorientasi Object (PBO) Semester Genap 2025/2026.

---

## 👥 Anggota Kelompok
Proyek ini dikerjakan secara kolaboratif menggunakan Git, dengan pembagian tugas yang selaras dengan lapisan MVC:

1. **Air Ronald Jusuf** - 202510370110223 - Kelas A
   - **Peran:** Knowledge / Database Engineer (Model)
   - **Tanggung Jawab:** Merancang entitas `Putusan`, mengelola struktur data `ArrayList`, serta logika komputasi `StatistikPutusan`.
   - **Branch Kerja:** `feature/model`

2. **Naufal Dzikrullah** - 202510370110191 - Kelas A
   - **Peran:** Backend Developer / Controller Engineer (Controller)
   - **Tanggung Jawab:** Membangun `KnowledgeController` sebagai jembatan sistem, merancang `InputHandler` dengan *exception handling* (try-catch), serta mengelola integrasi *branch* `develop`.
   - **Branch Kerja:** `feature/controller`

3. **Bagus Radhit Pratama** - 202510370110121 - Kelas A
   - **Peran:** GUI Designer / View Developer (View)
   - **Tanggung Jawab:** Mendesain antarmuka sistem yang interaktif dan *user-friendly*, serta memastikan pemisahan ketat antara *View* dan logika bisnis.
   - **Branch Kerja:** `feature/view`

---

## 💻 Prasyarat Sistem (Prerequisites)
Sebelum melakukan kompilasi dan menjalankan aplikasi, pastikan *environment* perangkat Anda telah terinstal spesifikasi minimum berikut:
* **Java Development Kit (JDK):** Versi 11 atau lebih baru.
* **Build Tool:** Apache Maven.
* **Version Control:** Git.
* **Koneksi Internet:** Diperlukan saat pertama kali *build* untuk mengunduh dependensi Maven (JavaFX dan PDFBox).

---

## ⚙️ Cara Kompilasi (Build Instructions)
1. Lakukan *clone* repository ini ke mesin lokal Anda:
   ```bash
   git clone https://github.com/bogs-19/pbo-km-narkotika.git
   ```
2. Buka terminal atau command prompt, lalu navigasikan ke direktori utama proyek:
   ```bash
   cd pbo-km-narkotika
   ```
3. Bersihkan cache sebelumnya dan unduh semua library yang dibutuhkan dengan perintah Maven berikut:
   ```bash
   mvn clean install
   ```
   *(Pastikan terminal memunculkan pesan **BUILD SUCCESS**)*.

---

## 🚀 Cara Menjalankan Aplikasi (Run Instructions)
Untuk menghindari konflik module-path pada JDK 11, aplikasi ini dikonfigurasi untuk berjalan mulus menggunakan plugin JavaFX dari Maven.

Jalankan perintah berikut di dalam terminal direktori proyek:
```bash
mvn javafx:run
```
*(Bagi pengguna IntelliJ IDEA: Anda juga dapat menjalankan aplikasi melalui panel Maven di sebelah kanan layar > Plugins > javafx > klik dua kali pada javafx:run)*.

---

## 🎥 Video Demo Aplikasi
Berikut adalah tautan menuju video presentasi berdurasi 5 menit yang mendemonstrasikan fungsionalitas KMS, tinjauan arsitektur kode (pewarisan, polimorfisme, enkapsulasi), dan bukti riwayat commit kolaborasi tim:

https://youtu.be/NsZM2c6HD_8

---

## 🖼️ Desain Antarmuka (Wireframe / Mockup)
Berikut adalah rancangan antarmuka sistem yang diimplementasikan pada layer View:

<img width="1122" height="791" alt="image" src="https://github.com/user-attachments/assets/fd55d968-a637-4edf-a860-0b2cfc1f47d1" />
<img width="1600" height="930" alt="image" src="https://github.com/user-attachments/assets/c3ae48e9-3c53-4b3e-93e8-ac7b81008c86" />
<img width="933" height="846" alt="image" src="https://github.com/user-attachments/assets/e85685fa-a39c-40e1-bcba-304db8f34403" />


