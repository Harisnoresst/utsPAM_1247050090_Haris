# Kopi dan Nyemil - Aplikasi Mobile

## Deskripsi Aplikasi
Kopi dan Nyemil adalah aplikasi mobile berbasis Android untuk pemesanan makanan dan minuman. Aplikasi ini dibuat sebagai pemenuhan tugas implementasi UI/UX dari wireframe menjadi aplikasi interaktif menggunakan data statis (dummy).

## Fitur Utama
* **Splash/Welcome Screen:** Tampilan awal saat aplikasi dibuka.
* **Autentikasi:** Halaman Sign Up, Login, dan Register untuk pengguna.
* **Home/Menu:** Menampilkan daftar makanan dan minuman (minimal 5 item) menggunakan RecyclerView.
* **Navigasi Utama:** Menggunakan Bottom Navigation (atau tombol) untuk berpindah antara Home, Order, dan Profile.
* **Profil Pengguna:** Halaman untuk melihat dan mengedit nama pengguna.
* **Pemesanan & Alamat:** Formulir pengisian alamat pengiriman pesanan.
* **Konfirmasi Pesanan:** Tampilan pop-up/halaman sukses setelah melakukan pemesanan.

## Teknologi yang Digunakan
* **Bahasa Pemrograman:** Kotlin (atau Java - *sesuaikan dengan yang Anda pakai*)
* **IDE:** Android Studio
* **UI/Layout:** XML (Views), RecyclerView, Material Components
* **Data:** Statis / Dummy Data (Tanpa Database)

## Cara Menjalankan Aplikasi
1. Clone repositori ini ke komputer lokal Anda:
   `git clone https://github.com/username-anda/repo-kopi-nyemil.git`
2. Buka proyek tersebut menggunakan **Android Studio**.
3. Tunggu hingga proses *Gradle Sync* selesai.
4. Sambungkan perangkat Android (fisik) atau jalankan Emulator.
5. Klik tombol **Run** (ikon segitiga hijau) atau tekan `Shift + F10`.

## Screenshot Tampilan
*(Tambahkan gambar screenshot aplikasi Anda ke dalam folder repo, lalu panggil dengan format di bawah ini)*

## Screenshot Tampilan

|         Splash & Welcome          |              Sign Up              |             Login              |
|:---------------------------------:|:---------------------------------:|:------------------------------:|
| ![Splash](screenshot/welcome.png) | ![Sign Up](screenshot/signup.png) | ![Login](screenshot/login.png) |

|               Register               |             Home             |        Alamat Pengiriman         |
|:------------------------------------:|:----------------------------:|:--------------------------------:|
| ![Register](screenshot/register.png) | ![Home](screenshot/home.png) | ![Alamat](screenshot/alamat.png) |

|              Profile              |                Edit Alamat                |            Konfirmasi Pesanan            |
|:---------------------------------:|:-----------------------------------------:|:----------------------------------------:|
| ![Profile](screenshot/profil.png) | ![Edit Alamat](screenshot/editAlamat.png) | ![Konfirmasi](screenshot/konfirmasi.png) |