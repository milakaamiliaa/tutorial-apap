
# Tutorial APAP
## Authors
**Siti Kaamiliaa Hasnaa** - *1706984732* - *C*

---
## Tutorial 1
### What I have learned today
Saya telah belajar bagaimana fungsi-fungsi dasar GitHub dan lebih mengerti command line nya, saya mengerti bagaimana membuat project lebih baik dan lebih teratur.
#### Github
1. Apa itu Issue Tracker? Masalah apa yang dapat diselesaikan dengan Issue Tracker?
   Issues adalah tempat untuk mencatat semua tugas-tugas, enhancements, dan bugs pada project yang kita miliki. Dapat di bagi dan dibahas oleh semua orang dalam tim.
   Masalah yang bisa diselesaikan adalah jika mengalami kesulitan dalam mengoding, untuk mempermudah membagi tugas, dan kita bisa mendokumentasi juga enhancements dari program yang kita buat. 
2. Apa perbedaan dari git merge dan merge --squash?
merge --squash akan menghasilkan merge commit dengan 1 parent, files akan digabungkan secara biasa namun metadata commit akan hanya menunjukkan salah satu parentnya. Sedangkan git merge adalah memasukkan history fork merjadi satu branch. 
#### Spring
3. Apa itu library & dependency?
Library adalah kumpulan precompiled routines yang sebuah program dapat gunakan. Dependency adalah dimana suatu software bergantung kepada software yang lainnya. 
4. Apa itu Maven? Mengapa kita perlu menggunakan Maven?
Maven adalah alat automasi untuk build project-project java. Tujuan utamanya adalah untuk konfigurasi project, compile, dan menjalankan final packaging.
5. Apa alternatif dari Maven?
Kita dapat menggunakan Jenkins, Ansible, atau juga Gradle
### What I did not understand
(tuliskan apa saja yang kurang Anda mengerti, Anda dapat men-_check_ apabila Anda sudah mengerti
dikemudian hari, dan tambahkan tulisan yang membuat Anda mengerti)
- [ ] Kenapa saya harus belajar APAP?
- [ ] Apa fungsi spring boot?
- [ ] Mengapa kita lebih mudah menggunakan eclipse?
Karena …
(Anda dapat membuat tampilan code dalam README.md menjadi lebih baik. Cari tahu lebih dalam
tentang penulisan README.md pada github pada link
[berikut](https://help.github.com/en/articles/basic-writing-and-formatting-syntax))

## Tutorial 2

### Pertanyaan 
1. Cobalah untuk menambahkan sebuah restoran dengan mengakses link berikut: 
http://localhost:8080/restoran/add?idRestoran=1&nama=PanyuFC&alamat=Kantin%20Fasilkom&nomorTelepon=14022 
Apa yang terjadi? Jelaskan mengapa hal tersebut dapat terjadi.

Muncul halaman error yang dikarenakan nomorTelepon yang kita set pada constructor berbentuk String namun yang diterima merupakan Integer.

2. Cobalah untuk menambahkan sebuah restoran dengan mengakses link berikut: 
http://localhost:8080/restoran/add?idRestoran=2&nama=KentukuFC&alamat=Kantin%20FIK 
Apa yang terjadi? Jelaskan mengapa hal tersebut dapat terjadi.

Muncul lagi halaman error, hal ini disebabkan oleh link yang kita akses tidak menyediakan informasi nomorTelepon, sedangkan constructor kelas Restoran membutuhkan nomorTelepon.

3. Jika Papa APAP ingin melihat restoran PanyuFC, link apa yang harus diakses?
Kita dapat mengakses dengan link berikut http://localhost:8080/restoran/view?idRestoran=1

4. Tambahkan 1 contoh restoran lainnya sesukamu. Lalu cobalah untuk mengakses http://localhost:8080/restoran/viewall, apa yang akan ditampilkan? Sertakan juga bukti screenshotmu.
Dia akan menampilkan semua restoran yang telah kita tambahkan pada list. Setelah restoran berhasil ditambahkan maka akan keluar halaman seperti [berikut](https://i.imgur.com/ONCo9EW.png)
dan jika ingin kita lihat daftar keseluruhannya akan keluar seperti [berikut](https://i.imgur.com/al7Egss.png)
