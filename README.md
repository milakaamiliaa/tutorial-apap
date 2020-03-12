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

## Tutorial 5
#### Pertanyaan
    1. Jelaskan bagian mana saja dari test yang dibuat pada latihan no 2 adalah given, when, dan and then

given merupakan inisiasi dari dummy, mengatur attribut-attribut dari dummy tersebut mengatur return dari database, sampai pemanggilan when. ketika menggunakan service. Bagian when berupa pemanggilan mockMvc.perform(get("/store/view?idStore=1")) yang akan langsung berinteraksi dengan controller dan mengembalikan halaman berdasarkan controller. Lalu and then berupa pemanggilan method .andExpect(...) yang berfungsi untuk melakukan pengecekan interaksi sesuai dengan yang diharapkan.

    2. Jelaskan perbedaan line coverage dan logic coverage.

Line coverage adalah ukuran berapa banyak baris kode yang sudah ter-cover udah unit test tapi tidak termasuk comments, conditionals dsb.

Logic coverage adalah ukuran berapa banyak internal struktur kode seperti requirements dan decisions yang tercover oleh unit testing. 

    3. Pada keadaan ideal, apa yang seharusnya dibuat terlebih dahulu, code atau unit test? Mengapa seperti itu? Apa akibatnya jika urutannya dibalik, adakah risiko tak terlihat yang mungkin terjadi?
    
Idealnya adalah unit test perlu dibuat sebelum kita memulai membuat code, karena dari unit test kita dapat mengetahui kriteria atau requirements apa saja yang kode kita perlu penuhi, mudah menemukan error dan memperbaikinya. 
Jika kita membuat testing setelah membuat code, apa yang telah kita buat akan menjadi lebih sulit untuk di test karena dapat terjadi kita harus menyesuaikan kode kita agar dapat lulus automated test. Lalu dapat terjadi juga apa yang telah kita buat ternyata lebih kompleks dari apa yang dibutuhkan atau over engineering. 

    4. [Bonus] Jelaskan mengapa pada latihan no 3, main class spring tidak diikutsertakan ke dalam perhitungan coverage? Apa saja yang dapat menyebabkan suatu class dapat di-exclude dari perhitungan code coverage.

Main class Spring tidak memerlukan testing karena class tersebut digunakan untuk menginisiasikan spring. 
Yang dapat menyebabkan class di exclude dalam code coverage adalah file built-in, file yang tidak memiliki bisnis proses, dan jika dikehendaki class yang memiliki code coverage yang rendah.


---
## Tutorial 6
1. Apa itu postman? Apa kegunaan dari postman?
- Postman adalah sebuah aplikasi (berupa plugin) untuk browser chrome sebagai REST Client atau istilahnya adalah aplikasi yang digunakan untuk melakukan uji coba REST API yang telah kita buat. Fungsinya sebagai GUI API Caller, Sharing Collection API for Documentation (free), Testing API (free), Realtime Collaboration Team (paid), Monitoring API (paid), Integration (paid). Pertama kali postman muncul sebagai add on dari Chrome namun sekarang sudah menjadi aplikasi.

2. Apa kegunaan dari annotation @JsonIgnoreProperties?
- Digunakan untuk menekan serialisasi properti (selama serialisasi), atau mengabaikan pemrosesan properti JSON yang dibaca (saat deserialisasi).

3. Apa itu ResponseEntity dan apa kegunaannya?
- ResponseEntity mewakili seluruh respons HTTP seperti kode status, header, dan body. Maka kita dapat menggunakannya untuk mengkonfigurasi respons HTTP sepenuhnya.


## Tutorial 7
###Latihan
1. Jelaskan secara singkat perbedaan Otentikasi dan Otorisasi! Di bagian mana (dalam kode
yang telah anda buat) konsep tersebut diimplementasi?

- Perbedaannya adalah otentikasi merupakan proses memeriksa detail pengguna untuk mengidentifikasinya dan memberikan akses ke sistem sementara otorisasi merupakan proses memeriksa izin pengguna yang diotentikasi untuk mengakses sumber daya sistem.


2. Apa itu BCryptPasswordEncoder? Jelaskan secara singkat cara kerjanya!

- BCryptPasswordEncoder adalah fungsi spring untuk melakukan hashing password. BCryptPasswordEncoder menghitung dan menghasilkan hash secara acak setiap kali di call.


3. Jelaskan secara singkat apa itu UUID dan mengapa kita memakai UUID di UserModel.java?

- UUID (Universally Unique Identifier) adalah 36 karakter (string) yang dibuat secara acak dengan teknik khusus yang terdiri dari 32 karakter alphanumerik dan 4 karakter tanda hubung (strip), sangat kecil kemungkinan sebuah karakter UUID akan sama bahkan jika di-generate dalam tempo 1 detik sekalipun. Umumnya dia digunakan sebagai Primary Key. UUID digunakan untuk menghindari konflik primary key dan juga untuk mengamankan data.

  
4. Apa kegunaan class UserDetailsServiceImpl.java? Mengapa harus ada class tersebut
padahal kita sudah memiliki class UserRoleServiceImpl.java?
- UserServiceImpl ada pada package service, sementara UserDetailServiceImpl pada package security. Service ini melakuakn import dari org.springframework.security.core.userdetails.UserDetailsService yang berisi antarmuka inti yang memuat data khusus pengguna


## Tutorial 8
1. Ceritakan langkah - langkah yang kalian lakukan untuk solve LATIHAN no.1, dan mengapa kalian melakukan langkah - langkah tersebut?
- Menambahkan setState pada Restorans.js -> this.setState({nama: "", alamat:"", nomorTelepon:"", rating:""}); Karena jika tidak di setState menggunakan string kosong, form yang ditampilkan ketika add restoran akan terisi dengan informasi yang sudah diinput sebelumnya.

2. Jelaskan fungsi dari async dan await!
- Async digunakan untuk mengatasi asynchronous pada javascript.
Await digunakan untuk menunggu proses asynchronous selesai kemudian baru melanjutkan ke baris selanjutnya. Async digunakan sebelum fungsi dan tidak harus ada wait sedangkan await harus menggunakan async.

3. Masukkan jawaban dari TODO (Screenshot) pada Component Lifecycle pada
pertanyaan ini.
- ![Memasukkan fungsi componentDidMount dan shouldComponentUpdate](https://i.imgur.com/HDXHplX.png)
![Terlihat gambar seperti berikut setelah aplikasi dijalankan](https://i.imgur.com/QwXEBTM.png)
![Terlihat shouldComponentUpdate tidak ada](https://i.imgur.com/G8RWbi8.png)
![Setelah ditambahkan tombol, sebelum tombol dipencet](https://i.imgur.com/QcZQb6H.png)
![Setelah dipencet maka akan keluar shouldComponentUpdate](https://i.imgur.com/5Ml165O.png)


4. Jelaskan fungsi dari componentDidMount, shouldComponentUpdate, componentDidUpdate, componentWillReceiveProps, componentWillUnmount. Notes : Penjelasan harus mencantumkan “kapan fungsi dipanggil” dan “use case apa saja yang biasanya menggunakan lifecycle method tersebut”.
- componentDidMount: fungsi ini dipanggil setelah component dirender. Fungsi ini proses pemanggilan ajax dan perubahan isi state setelah proses ajax dipanggil.
ShouldComponentUpdate: fungsi ini selalu dipanggil sebelum dirender yang akan memungkinkan untuk mengatur apakah re-rendering diperlukan atau tidak. Fungsi initidak pernah dipanggil pada inisiasi dan harus mengembalikkan nilai yang berupa boolean (true atau false) tetapi best way nya fungsi ini mengembalikan false pada kondisi tertentu.
componentDidUpdate: fungsi ini dipanggil setelah fungsi render. Fungsi ini serupa dengan componentDidMount, dapat digunakan untuk melakukan operasi DOM setelah data diperbaharui
componentWillReceiveProps: fungsi ini akan dipanggil ketika props sudah berubah dan tidak pada saat rendering awal. Fungsi ini akan melakukan perubahan state berdasarkan pada props yang sekarang dan props yang baru.
componentWillUnmount: fungsi ini dipanggil ketika komponen sudah dibuang dari DOM. Fungsi ini digunakan ketika aksi-aksi yang berhubungan dengan pembersihan diperlukan. Use case nya adalah ketika membuang timer yang sebelumnya didefinisikan di componentDidMount. Urutan pemanggilannya sebagai berikut Mounting: componentWillMount -> render -> componentDidMount Updating: componentWillReceiveProps -> shouldcomponentupdate -> true -> componentWillUpdate -> render -> componentDidUpdate Unmouting: componentWillUnmount
