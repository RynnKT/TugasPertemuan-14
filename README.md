# Proyek PBO - Pertemuan 14  
### Aplikasi Java Desktop dengan Fitur Keamanan & Download

Proyek ini merupakan tugas Mata Kuliah **Pemrograman Berorientasi Objek (PBO)**.  
Fokus utama: peningkatan fitur keamanan pada sistem ubah password, serta penambahan fitur download laporan dalam aplikasi Java Desktop.

---

## Informasi Umum

- **Nama**: Erridho Ramadhani Setiawan  
- **NIM**: 09040624085  
- **Program Studi**: Sistem Informasi  
- **Fakultas**: Sains dan Teknologi  
- **Universitas**: UIN Sunan Ampel Surabaya  
- **Tahun Ajaran**: 2025–2026  
- **Dosen Pengampu**: Bayu Adhi Nugroho, Ph.D  

---

## Deskripsi Proyek

Aplikasi ini dikembangkan untuk meningkatkan keamanan dan fungsionalitas pada sistem berbasis Java Desktop dengan beberapa fitur utama:

### 1. Keamanan Ubah Password
- Proses ubah password tidak bisa sembarangan.
- Sistem memverifikasi:
  - Password lama  
  - Kode unik (menggunakan **nama peliharaan**).
- Tujuannya: mencegah orang yang hanya tahu username tapi bukan pemilik asli mengubah password.

---

### 2. Sistem Kode Unik
Saat proses **registrasi**, user wajib mengisi:
- Username  
- Password  
- **Kode unik** → menggunakan *nama peliharaan*

Kode unik ini digunakan sebagai lapisan keamanan tambahan saat proses ubah password.

---

### 3. Fitur Download Data (CSV)
Ditambahkan tombol **Download** pada:
- Tabel daftar pelanggan  
- Tabel daftar booking  

Fungsinya:
- Menyimpan data ke dalam file **CSV**
- Bisa digunakan untuk laporan atau backup data

---

## Tujuan Pengembangan

- Meningkatkan keamanan dalam proses ubah password.
- Mengimplementasikan fitur download data langsung dari aplikasi.
- Meningkatkan pemahaman konsep:
  - OOP (Object Oriented Programming)
  - Validasi input
  - Manajemen database
  - Pengolahan file & ekspor data
  - Penerapan normalisasi database
- Mengembangkan aplikasi Java Desktop yang:
  - Lebih aman  
  - Lebih stabil  
  - Lebih user friendly  

---

## Teknologi yang Digunakan

- Java (Desktop Application)
- Database MySQL
- iReport / JasperReport
- Export File CSV

---

## Fitur Utama

✔ Ubah Password dengan verifikasi kode unik  
✔ Tambah kode unik saat registrasi  
✔ Download data pelanggan & booking ke CSV  
✔ Sistem validasi user lebih ketat  
✔ Integrasi database dengan normalisasi  

