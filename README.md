

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

## Tutorial 3
#### Github
    1. Pada class MenuDb, terdapat method findByRestoranIdRestoran, apakah kegunaan dari method tersebut?

Untuk mencari list menu yang dicari berdasarkan IdRestoran, jika ID sesuai maka akan mengembalikan list menu yang terdapat pada restoran tersebut.

    2. Pada class RestoranController, jelaskan perbedaan method addRestoranFormPage dan addRestoranSubmit?

Method addRestoranFormPage mengembalikan halaman untuk mengisi data restoran dan pada html-nya akan mengambil data yang sudah diisi. Sedangkan addRestoranSubmit untuk memasukkan data yang sudah diisi ke dalam database.

    3. Jelaskan apa kegunaan dari JPA Repository?

JPA Repository digunakan untuk mempermudah memetakan objek-objek java ke dalam relational database dan pembuatan table pada Java. Dengan JPA dapat mudah untuk melakukan Create, Delete, dan Update. JPA adalah ORM (Object Relational Mapping) yang berfungsi sebagai penghubung database dan model. JPA dapat berfungsi sebagai sekuriti yang dapat menghindari SQL injection. 

    4. Sebutkan dan jelaskan di bagian kode mana sebuah relasi antara RestoranModel dan MenuModel dibuat?
Pada kode @OneToMany dan @ManyToOne. Yang dimana @OneToMany menunjukkan satu restoran memiliki banyak menu dan @ManyToOne berarti banyak menu terdapat di satu restoran.

    5. Jelaskan kegunaan FetchType.LAZY, CascadeType.ALL, dan FetchType.EAGER

FetchType.LAZY digunakan ketika ingin mengambil data yang dibutuhkan 
CascadeType.ALL digunakan untuk melakukan perubahan update atau delete ke semua entitas yang berhubungan dengan suatu entitas. 
FetchType.EAGER digunakan ketika ingin mengambil terlebih dahulu data yang dibutuhkan, sehingga saat dibutuhkan data yang ingin diambil sudah ada.

## Tutorial 4
#### Pertanyaan
    1. Jelaskan yang anda pelajari dari melakukan latihan nomor 2, dan jelaskan tahapan bagaimana anda menyelesaikan latihan nomor 2

Menambahkan th:text=${brand} pada class navbar-brand di fragment.html lalu menambahkan (brand = 'NamaYangDiinginkan) pada navbar th:replace semua file html seperti berikut. 
```
<nav th:replace="fragments/fragment :: navbar(brand = 'Add Restoran')"></nav>
```

    2. Jelaskan yang anda pelajari dari latihan nomor 3, dan jelaskan tahapan bagaimana anda menyelesaikan latihan nomor 3

Karena kita membutuhkan banyak fields sekaligus, kita bisa menggunakan ArrayList. Kita dapat menambahkan row fields sehingga membutuhkan tombol addRow yang menambah index di arrayList. Selain itu, kita juga dapat menghapus suatu row, sehingga kita butuh removeRow, Karena kita punya banyak value di dalam arrayList, kita save dengan for loop untuk menyimpan semuanya. Maka pada fungsi save kita menambahkan for loop arrayList saat men-post form.

    3. Jelaskan perbedaan th:include dan th:replace

th:replace akan mengganti tag dengan yang ada di fragment, jadi dia akan menggantikan si host tag dengan fragment tag dan isinya. Sedangkan th:include akan memasukkan fragmen sebagai body dari host tag namun tidak akan ikut memasukkan fragment tag nya

    4. Jelaskan bagaimana penggunaan th:object beserta tujuannya

th:object digunakan untuk menentukan objek mana yang akan diisi dari input form. th:object digunakan seperti attribut pada tag form dan diisi dengan ${namaObject}
