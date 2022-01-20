<?php
require("koneksi.php");
$response=array();
if($_SERVER['REQUEST_METHOD']=='POST'){
    $nama=$_POST["nama"];
    $alamat=$_POST["alamat"];
    $nohp=$_POST["nohp"];
    $kota=$_POST["kota"];

    $perintah="INSERT INTO laundry (nama,alamat,nohp,kota) VALUES ('$nama','$alamat','$nohp','$kota')";
    $eksekusi=mysqli_query($konek,$perintah);
    $cek=mysqli_affected_rows($konek);
    if($cek > 0){
        $response["kode"]=1;
        $response["pesan"]="Simpan Data Berhasil";

    }
    else{
        $response["kode"]=0;
        $response["pesan"]="Data Gagal disimpan";

    }
}
else{
    $response["kode"]=0;
    $response["pesan"]="Tidak Ada Post Data";

}
echo json_encode($response);
mysqli_close($konek);